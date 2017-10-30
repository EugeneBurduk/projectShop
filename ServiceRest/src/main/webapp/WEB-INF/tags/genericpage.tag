<%@tag description="Overall Page template" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html ng-app="myApp" translate="no">
<head>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/webjars/bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/app1.js"></script>
    <link rel="${pageContext.request.contextPath}/static/js/stylesheet" href="jquery.raty.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery.raty.js"></script>
    <link rel="stylesheet" href="/static/css/styleShop.css?text">
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/><!--Подключаем стили CSS для библиотеки Jquery UI-->
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<style type="text/css">
     .navbar-nav > li > a:hover, .navbar-nav > li > a:focus {
        color:#252a30;
        background: #B0C4DE;
    }
     .circle{
         width:30px;
         height:30px;
         display:inline-block;
         border-radius:20px;
         -moz-border-radius:20px;
         -webkit-border-radius:20px;
         -khtml-border-radius:20px;
         font-size:14px; color:#fff;
         line-height:30px;
         text-align:center;
         background:#f2f2f2;

     }
</style>

</head>

<body>
<header>
    <div style="background-color: #fbfbfb">
        <div class="image header-left" style="margin-left: 50px">
            <img src="/static/image/myshop.png">
        </div>
        <div class="search header-center"></div>
        <div class="block-right header-right" > <a href="/register">Регистрация</a> | <a href="/login">Вход</a></div>
    </div>

        <div style="background-color: #f2f2f2;vertical-align: middle" class=" collapse navbar-collapse" id="navbar-main">
            <div class="menu">
                <ul id="menu" class="menu nav navbar-nav">
                    <li><a href="/home"> Главная </a></li>
                    <li><a id="sport" class="category" href="/home">Спортивные средства </a></li>
                    <li><a id="tourism" class="category" href="/home">Туризм и кемпинг</a></li>
                    <li><a id="trainers" class="category" href="/home">Тренажеры</a></li>
                    <li><a id="winter" class="category" href="/home">Зимние виды спорта</a><li>
                </ul>
            </div>
            <div class="cart"><span class="glyphicon glyphicon-shopping-cart"></span><a href="/basket" class="link-cart">Корзина</a> <label class="circle"></label></div>
        </div>


</header>
<section style="margin: 15px auto 40px 20px; width: 95%;">
    <jsp:doBody/>
</section>
</body>
</html>