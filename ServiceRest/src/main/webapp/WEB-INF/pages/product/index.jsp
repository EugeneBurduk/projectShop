<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <style>
        .brand{
            text-align: left;width: 30%; display: inline-block;

        }
        .col-md-4{
            width: 27%;
        }
        .col-md-8{
            width: 70%;
        }
    </style>
<body>
<div class="row">
    <div class="col-md-4">
        <label>Бренд</label>
        <div class="producers"></div>
        <label>Цена</label>
        <form role="form" class="form-inline" style="margin-bottom: 10px;">
            <div class="form-group">
             от   <input  type="text" style="width: 40px;" id="minDiameter" value="1"/>
            </div>
            <div class="form-group">
             до   <input type="text" style="width: 40px"; id ="maxDiameter"; value=""/>
            </div>
        </form>
        <div class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all" id="slider"></div>
    </div>
    <div class="col-md-8">
        <div class="btn-group" style="float: right">
            <button type="button" class="btn btn-default">Сортировка</button>
            <button type="button" data-toggle="dropdown" class="btn btn-default dropdown-toggle"><span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a id="expensive" href="#">Сначала дорогие</a></li>
                <li><a id="cheap" href="#">Сначала дешевые</a></li>
                <li><a id="rating" href="#">Товары по рейтингу</a></li>
            </ul>
        </div>
        <div style="float: left">
            <div id="products"></div>
        </div>
    </div>
</div>

</body>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.ui-slider.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/products.js"></script>
</t:genericpage>
