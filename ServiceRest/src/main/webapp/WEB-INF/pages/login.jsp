<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:body>
        <div class="row">
            <form id="authorizeForm" method="post" class="form-horizontal" method="post" data-bv-message="This value is not valid"
                  data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                  data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                  data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="username">Username</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control" minlength="6"
                               id="password" name="password" placeholder="Password"
                               data-bv-password-message="The input is not a valid email address" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-1">
                        <button type="submit" class="btn btn-primary">Вход</button>
                    </div>
                    <div class="col-sm-1">
                        <a href="/register" class="btn btn-default">Регистрация</a>
                    </div>
                </div>
            </form>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('form').bootstrapValidator();
            });
        </script>
        <script src="${pageContext.request.contextPath}/static/js/login.js"></script>
    </jsp:body>
</t:genericpage>
