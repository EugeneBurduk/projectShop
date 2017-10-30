<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:body>
        <div class="row">
            <form id="authorizeForm" class="form-horizontal"
                  data-bv-message="This value is not valid"
                  data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
                  data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
                  data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="username">Username</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username"
                               value=""/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">Email</label>

                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email" required
                               value=""
                               data-bv-emailaddress-message="The input is not a valid email address"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">Password</label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control" minlength="6"
                               id="password" name="password" placeholder="Password" value="${item.password}"
                               data-bv-password-message="The input is not a valid email address" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="confirmPassword" class="col-sm-2 control-label">Confirm password</label>

                    <div class="col-sm-10">
                        <input type="password" class="form-control" value=""
                               id="confirmPassword" name="confirmPassword" placeholder="Confirm password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="role" class="col-sm-2 control-label">Confirm password</label>
                    <div class="col-sm-10">
                        <select id="role" name="role" class="form-control">
                            <option value="USER">user</option>
                            <option value="ADMIN">administrator</option>
                        </select>
                    </div>
                </div>
                <c:if test="${message != null}">
                    <div class="alert alert-danger">
                            ${message}
                    </div>
                </c:if>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Registr</button>
                    </div>
                </div>
            </form>
        </div>


        <script src="${pageContext.request.contextPath}/static/js/register.js"></script>
    </jsp:body>
</t:genericpage>
