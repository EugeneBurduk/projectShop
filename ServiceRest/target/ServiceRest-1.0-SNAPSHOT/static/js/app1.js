var flag = true;
$(document).ready(function(){
    //if(flag){    countOrder();}

    $('#menu li a.category').on('click',
        function(event){
            var val = "";
            console.log("FFf");
            $("section").empty();
            event.preventDefault();
            $.ajax({
                type: "GET",
                dataType:"json",
                url:  document.location.origin+"/rest/subcategory"+"/"+$(this).text(),
                    success: function(data) {
                        $.each(data, function(j, pdata) {
                        // val= val + " " + pdata.name;
                            $("section").append('<div id="subcategory"></div>');
                        $("#subcategory").append('<a>'+ pdata.name +''+'</a>');
                        
                    })
                        $('a').css({padding: "10px"}).attr('href', '/products/');
                        $('#subcategory a').click(function (event) {
                            $('a').attr('href', '/products/'+$(this).text());
                        });
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.log(' Error in processing! '+textStatus);
                }
            });
            return false;
        });
});
function countOrder() {
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        async: false,
        url: document.location.origin+"/rest/order",
        success: function (data) {
            if(data.length!=0){
                console.log("ok"+data.length);
                $(".circle").css("background","#046e84");
                $(".circle").text(data.length);
                $(".circle").show();
            }
            else $(".circle").hide();

        },
        error: function (jqXHR, textStatus, errorThrown) {
            $(".circle").hide();
            console.log(' Error in processing! ' + textStatus);
        }

    });
}
function getProducts() {
   $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/products/subcategory/"+document.location.pathname.split('/')[2],
        success: function (data) {
            formationProducer(data);
            formationProduct(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
    
}
function formationProducer(data){
    var set = new Set();
    $.each(data, function (j, pdata) {
        set.add(pdata.producer.name);
    });
    set.forEach(function(value) {
        $(".producers").append('<label class="checkbox" style="margin-left: 18px; font-weight: 500;">  <input  type="checkbox" value="'+value+'" onClick="findByBrand(this)";>' + value + '</label>');
    });

}
function formationProduct(data) {
    
    $.each(data, function (j, pdata) {
        $("#products").append('<div id="' + pdata.id + '">' + '</div>');
        $("#products div").addClass('product row').attr("style","margin: 30px;");
    });
    $(".product").append('<div class="images-blok" style="display: inline-block; vertical-align: top;">'+
        '<img class="img-responsive">'+ '</div>');
    $(".product").append('<div class="description" style="display: inline-block; vertical-align: top;">'+ '</div>');
    $(".product").append('<div class="price" style="display: inline-block; vertical-align: top; padding-left: 30px;">'+'</div>');
    $(".description").append('<div>'+ '<a href="/product">'+'</a>'+'</div>');
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
        });
        getCharacteristics(pdata.name,function (num){
            $.each(num, function (j, pd) {
                $("#" + pdata.id + " div.characteristics").append('<label>'+pd.nameCharacteristic+":"+pd.value+" ; "+'</label>');
            });
        })
    })
    $('.description div a').click(function (event) {
        $('a').attr('href', '/product/'+$(this).text());
    });
}

function checkboxFubction() {
    $(".product").hide();
    $('.producers').find('input:checked').each(function () {
        /*$.ajax({
            type: "GET",
            dataType: "json",
            url: document.location.origin+"/rest/products/brand/"+$(this).val(),
            success: function (data) {
                    $.each(data, function (j, pdata) {
                        $('#' + pdata.id).show();
                    });
                
                // formationProduct(data);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(' Error in processing! ' + textStatus); }

        });*/
        productsFilter();
    });
    if($('.producers').find('input:checked').length==0){
        $(".product").show();
    }

}

function formToJSONFilter() {
    return JSON.stringify({
        "brand":$('.producers').find('input:checked').val(),
        "minDiameter" : $("#minDiameter").val(),
        "maxDiameter" : $("#maxDiameter").val()
    });
}
function productsFilter() {
    console.log("filter");
    console.log("filter"+formToJSONFilter());
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: document.location.origin + "/rest/products/filter",
        data: formToJSONFilter(),
        success: function () {
            console.log("ok!");
            $.each(data, function (j, pdata) {
                $('#' + pdata.id).show();
            });
        }
    });
}
function findByBrand(checkboxElem){
   if (checkboxElem.checked) {
        checkboxFubction();
    }
    else {
        checkboxFubction();
    }
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
    console.log("вызов характеристик = "+name);
    var characteristics="";
    $.ajax({
        type: "GET",
        dataType: "json",
        url: document.location.origin+"/rest/characteristicsProduct/"+name,
        success: function (data) {
            callback (data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}

    
