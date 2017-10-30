/**
 * Created by Eugene on 25.10.2017.
 */
var idProduct = "";
$(document).ready(function(){
    countOrder();
  getProduct();
    $("button").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "POST",
            contentType: 'application/json',
            url: document.location.origin+"/rest/order",
            data: formToJSONOrder(idProduct),
            success: function (data) {
              console.log("ok");
                countOrder();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(' Error in processing! ' + textStatus);
            }

        });
    });
});


function formToJSONOrder(idProduct){
    return JSON.stringify({
      //  "idUser": ,
        "idProduct": idProduct
    });
}
function getProduct() {

    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/products/"+document.location.pathname.split('/')[2],
        success: function (data) {
            $.each(data, function (j, pdata) {
                $(".name h3").text(pdata.name);
                $(".rating").raty({ number: 5, score: pdata.rating });
                $(".images-blok img").attr("src", pdata.photo);
                getPrice(pdata.name,function (num){
                    $(".price").text(num+",00 руб");
                });
                getCharacteristics(pdata.name,function (num){
                    $.each(num, function (j, pd) {
                        $(".characteristics").
                        append('<div class="row"><div class="col-md-3 nameCharacteristic" style="width: 30%">'+
                            pd.nameCharacteristic+'</div><div class="value col-md-3" style="60%">'+pd.value+'</div></div>');
                        
                    });
                })
                $(".producer").text(pdata.producer.name);
                sendIdProduct(pdata.id);
            })        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}
function sendIdProduct(id){
    idProduct= id;
    return idProduct;
}