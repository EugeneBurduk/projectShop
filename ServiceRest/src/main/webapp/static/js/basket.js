$(document).ready(function(){
    flag = false;
    if(!flag){
        alert("d");
        getOrdersByUser();
    }


});

function getOrdersByUser() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/order/",
        success: function (data) {
            if(data!=null) {
                $("#products p").hide();
                $.each(data, function (j, pdata) {
                    $("#products").append('<div id="' + pdata.product.id + '">' + '</div>');
                    $("#products div").addClass('product row').attr("style", "margin: 30px;");

                });

                $.each(data, function (j, pdata) {
                if(pdata.buy!=1){ $("#"+pdata.product.id).append('<div class="button" style="display: inline-block; vertical-align: top; padding-left: 30px;">' +
                    '<button type="button" class="btn btn-primary">Купить</button>' + '</div>');}
                else  $("#"+pdata.product.id).append('<div class="text" style="display: inline-block; vertical-align: top; padding-left: 30px;">' +
                    '<label>Товар заказан. </label>' + '</div>');

                });
                $(".product").append('<div class="images-blok col-md-3" >' +
                    '<img class="img-responsive pull-right">' + '</div>');
                $(".product").append('<div class="description col-md-3">' + '</div>');
                $(".product").append('<div class="price col-md-3">' + '</div>');
                $(".description").append('<div>' + '<a href="/product">' + '</a>' + '</div>');
                $(".description").append('<div class="characteristics">' + '</div>');
                $(".description").append('<div class="rating">' + '</div>');
                $(".description").append('<div class="name">' + '</div>');
                $.each(data, function (j, pdata) {
                    $("#" + pdata.product.id + " div a").text(pdata.product.name);
                    $("#" + pdata.product.id + ' div.rating').raty({number: 5, score: pdata.product.rating});
                    $("#" + pdata.product.id + " div.images-blok img").attr("src", pdata.product.photo);
                    getPrice(pdata.product.name, function (num) {
                        console.log("ggfgd" + num);
                        $("#" + pdata.product.id + " div.price").text(num);
                    });
                    getCharacteristics(pdata.product.name, function (num) {
                        $.each(num, function (j, pd) {
                            $("#" + pdata.product.id + " div.characteristics").append('<label>' + pd.nameCharacteristic + ":" + pd.value + " ; " + '</label>');
                        });
                    })
                });
            }
            $(".product button").click(function () {
                buy($(this).parents().eq(1).attr("id"), data);
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing hbiuoh! ' + textStatus);
        }

    });
    //flag=true;
}

function buy(id, data) {
    $.each(data, function (j, pd) {
       // alert("feffs"+pd.product.id+id);
        if(id==pd.product.id){
          //  alert("555");
            buyProduct(id, pd.id, pd);
            return;
        }

    });
}
function buyProduct(idProduct,id, object) {
    alert("f"+id);
    $.ajax({
        type: "PUT",
        contentType: 'application/json',
        url: document.location.origin + "/rest/order",
        data: JSON.stringify({"id":id,"idProduct": idProduct}),
        success: function () {
            console.log("jnkl");
            if((object.product.countProduct-1)==0){
                checkProducts();
            }
            else reduceCount(object.product);

            $("#"+idProduct +" button").slideToggle();
            $("#"+idProduct).append('<div class="text" style="display: inline-block; vertical-align: top; padding-left: 30px;">' +
                '<label>Товар заказан. </label>' + '</div>');

        }
    });
}

function checkProducts(){
  alert("kkkkk");
}
function reduceCount(product) {
  //  alert("PUT"+JSON.stringify(product));
    $.ajax({
        type: "PUT",
        contentType: 'application/json',
        url: document.location.origin + "/rest/products",
        data: JSON.stringify(product),
        success: function () {
            console.log("5555jnkl");
        }
    });
}

function postUser() {
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: document.location.origin + "/rest/user",
        data: formToJSONUser(),
        success: function () {
            console.log("jnkl");
        }
    });
}
function formToJSONUser() {
    return JSON.stringify({
        "username":$("#username").val(),
        "password" : $("#password").val(),
        "email" : $("#email").val(),
        "role" : "ROLE_"+$("#role option:selected").val()
    });
}