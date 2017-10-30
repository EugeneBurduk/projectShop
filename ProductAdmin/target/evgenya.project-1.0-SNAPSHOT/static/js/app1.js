/**
 * Created by Eugene on 09.10.2017.
 */

$(document).ready(function(){
  
   // $( document ).ajaxStart(function() {
        //   event.preventDefault();
        //  $("product\index.jsp").load(function (event) {
    //  function h(text) {
    // $('#subcategory a').on('click',
    //     function(event){
    //       var val = "";
    //         console.log($(this));
    //       $.ajax({
    //           type: "GET",
    //           dataType: "json",
    //           url: document.location.origin+"/rest/products",
    //           success: function (data) {
    //               console.log("response:" + data);
    //               $.each(data, function (j, pdata) {
    //                   val = val + "[ " + pdata.id + " " + pdata.name + " " + pdata.photo +
    //                       " " + pdata.rating + "]";
    //               })
    //               $("#product").html(val + "yyy");
    //           },
    //           error: function (jqXHR, textStatus, errorThrown) {
    //               console.log(' Error in processing! ' + textStatus);
    //           }
    //
    //       });
    //         return false;
    //     });
     // }

    $('#menu li a.category').on('click',
        function(event){
            var val = "";
            $("#subcategory").empty();
            event.preventDefault();
            $.ajax({
                type: "GET",
                dataType:"json",
                url:  "http://localhost:8088/rest/subcategory"+"/"+$(this).text(),
                    success: function(data) {
                        $.each(data, function(j, pdata) {
                        // val= val + " " + pdata.name;
                        $("#subcategory").append('<a>'+ pdata.name +''+'</a>');
                        
                    })
                        $('a').css({padding: "10px"}).attr('href', '/products/');
                        $('#subcategory a').click(function (event) {
                            $('a').css({padding: "10px"}).attr('href', '/products/'+$(this).text());
                            
                        });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log(' Error in processing! '+textStatus);
                }
                
            });
            return false;


        });


});

function getProducts() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/products/"+document.location.pathname.split('/')[2],
        success: function (data) {
            $.each(data, function (j, pdata) {
                $("#products").append('<div id="' + pdata.id + '">' + '</div>');
                $("#products div").addClass('product row').attr("style","margin: 30px;");
            })

                $(".product").append('<div class="images-blok" style="display: inline-block; vertical-align: top;">'+
                    '<img class="img-responsive">'+ '</div>');
                $(".product").append('<div class="description" style="display: inline-block; vertical-align: top;">'+ '</div>');
                $(".product").append('<div class="price" style="display: inline-block; vertical-align: top; padding-left: 30px;">'+'</div>');
                $(".description").append('<div>'+ '<a>'+'</a>'+'</div>');
                $(".description").append('<div class="characteristics">'+'</div>');
                $(".description").append('<div class="rating">'+'</div>');
            $(".description").append('<div class="name">'+'</div>');
            $.each(data, function (j, pdata) {
                $("#"+pdata.id + " div a").text(pdata.name);
                $("#"+pdata.id+' div.rating').raty({ number: 5, score: pdata.rating });
                $("#"+pdata.id+" div.images-blok img").attr("src", pdata.photo);
                getPrice(pdata.name,function (num){
                    console.log("ggfgd"+num);
                    $("#"+pdata.id+" div.price").text(num);
            })
                getCharacteristics(pdata.name,function (num){
                    $("#"+pdata.id+" div.characteristics").text(num);
                })
            })
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}

function getPrice(name, callback) {

    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/prices/"+name,
        success: function (data) {
            console.log(data);
            console.log(document.location.pathname.split('/')[2]);
            console.log("lll"+data.value);
           callback (data.value);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}
function getCharacteristics(name, callback) {
    var characteristics="";
    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/characteristics/"+name,
        success: function (data) {
            console.log("characteric +"+data);
            $.each(data, function (j, pnum) {
                characteristics = characteristics + ", "+pnum.value;
            })
            callback (characteristics);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}