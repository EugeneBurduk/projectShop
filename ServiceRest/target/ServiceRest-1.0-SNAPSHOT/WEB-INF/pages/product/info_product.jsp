<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
   <div id="product" class="row" style="margin-left: 30px">
         <div class="col-md-3 col-sm-4 images-blok" style="width: 20%"><img class="img-responsive"></div>
         <div class="col-md-3 col-sm-4 description" style=" width: 60%">
            <div class="header">
                <div class="name"> <h3></h3></div>
                <div class="rating"></div>
            </div>
             <div class="characteristics"></div>
             <div class="row">
                 <div class="col-md-3" style="width: 30%">Производтель: </div>
                 <div class="col-md-3 producer"></div>
             </div>
             <div class="price" style="margin-top: 20px; font-size: 18px; font-weight: 700; color: #cd452f;"></div>
         </div>
         <div class="col-md-3 col-sm-4" style="width: 15%">

             <button type="button" class="btn btn-warning">В корзину</button>
         </div>

   </div>
    <script src="${pageContext.request.contextPath}/static/js/product.js"></script>
</t:genericpage>
