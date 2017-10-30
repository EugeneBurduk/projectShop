<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/webjars/bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
    <link rel="stylesheet"  type="text/css" media="screen"  href="/static/css/style.css?text"/>
    <title>Add product</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.min.js"></script>

    <style>
        .hiding{
            display: none;
        }
        .pad-bottom{
            margin-bottom: 10px ;
        }

    </style>
</head>
<body>
<a href="#addProductModal" role="button" class="btn" data-toggle="modal">Добавить продукт</a>

<form>
    <div class="row">
        <div class="col-xs-6">
            <div class="input-group">
                <input id="fieldSearch" type="text" class="form-control">
        <span class="input-group-btn">
          <button id="search" class="btn btn-default" type="button">Поиск</button>
        </span>
            </div>
        </div>
    </div>
</form>
<div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="studentModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Добавление товара</h4>
            </div>
            <form>
                <div class="modal-body">
                    <div class="row pad-bottom">
                        <div class="col-xs-4">
                            <label>Фото: </label>
                        </div>
                        <div class="col-xs-8">
                            <input type="file" id="file"   class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <label>Наименование товара: </label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text" id="nameProduct" name="nameProduct" placeholder="Наименование товара"  class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <label>Производитель: </label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text" id="producer" name="producer" placeholder="Производитель" class="form-control">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-4">
                            <label>Количество: </label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text" id="countProduct" name="countProduct" placeholder="Количество" class="form-control">
                        </div>
                    </div>
                    <div class="row pad-bottom">
                        <div class="col-xs-4">
                            <label>Категория товара:</label>
                        </div>
                        <div class="col-xs-8">
                            <select id="subcategory" name="subcategory"  class="form-control">
                                <option  selected="selected" value="choice">Выберите категорию</option>
                            </select>
                        </div>
                    </div>

                    <div class="row fieldValue">
                        <div class="col-xs-4">
                            <label class="characteristic"></label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text" class="form-control hiding">
                        </div>
                    </div>

                    <div class="row fieldValue">
                        <div class="col-xs-4">
                            <label class="characteristic"></label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text"  class="form-control hiding">
                        </div>
                    </div>

                    <div class="row fieldValue">
                        <div class="col-xs-4">
                            <label class="characteristic"></label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text" id="hiding" class="form-control hiding">
                        </div>
                    </div>

                    <div class="row fieldValue">
                        <div class="col-xs-4">
                            <label class="characteristic"></label>
                        </div>
                        <div class="col-xs-8">
                            <input type="text"  class="form-control hiding">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="submit"  class="btn btn-primary">
                    </div>
                    <div class="character"></div>
                    <div class="result"></div>
                </div>
            </form>
        </div>
    </div>
</div>

<div>
    <div>
        <table id="tbproduct" class="table table-hover table-striped">
            <thead>
            <th style="text-align: center;">id</th>
            <th style="text-align: center;">Название</th>
            <th style="text-align: center;">Рейтинг</th>
            <th style="text-align: center;">Производитель</th>
            <th style="text-align: center;">Подкатегория</th>
            <th></th>
            </thead>
            <tbody>
            </tbody>
        </table>

    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/product.js"></script>
</body>
</html>
