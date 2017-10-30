var URL = "http://localhost:8088";
$(document).ready(function() {

    getListProduct();
    getCategory();
    
    $("#subcategory").change(function () {
        getCharacteristics();
    }).change();
    $("#search").click(function (e) {
        e.preventDefault();
        searchProducts();
    });
    $('form').submit(function (e) {
        e.preventDefault();
        postProduct();
    });

})

function searchProducts() {
    console.log("поиск");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: URL + "/rest/products/"+$("#fieldSearch").val(),
        success: function (data) {
            console.log("получены продукты");
            $("#tbproduct tbody").empty();
            $.each(data, function (j, pdata) {
                $("#tbproduct tbody").append('<tr id="'+pdata.id+'"><td id="idProduct" class="text-center">'+ pdata.id+'</td> <td class="text-center">'+
                    pdata.name+'</td> <td class="text-center">'+
                    pdata.rating+'</td> <td class="text-center">'+
                    pdata.producer.name+'</td> <td class="text-center">'+
                    pdata.subcategory.name+'</td> <td>'+
                    '<button type="button" id="delete" onclick="deleteProduct('+pdata.id+')" class="btn btn-danger btn-xs">Удалить</button>'+'</td>'+'</tr>');
            })

        }
    });
}
function getListProduct() {
    console.log("получение списка продуктов");
    $.ajax({
        type: "GET",
        dataType: "json",
        url: URL + "/rest/products",
        success: function (data) {
            console.log("получены продукты");
            $.each(data, function (j, pdata) {

               $("#tbproduct tbody").append('<tr id="'+pdata.id+'"><td id="idProduct" class="text-center">'+ pdata.id+'</td> <td class="text-center">'+
                   pdata.name+'</td> <td class="text-center">'+
                   pdata.rating+'</td> <td class="text-center">'+
                   pdata.producer.name+'</td> <td class="text-center">'+
                   pdata.subcategory.name+'</td> <td>'+
                   '<button type="button" id="delete" onclick="deleteProduct('+pdata.id+')" class="btn btn-danger btn-xs">Удалить</button>'+'</td>'+'</tr>');
            })
           
        }
    });

    
}
function deleteProduct(id) {
    console.log("мы нажали на кнопку"+id);
    console.log('deleteProduct');
    $.ajax({
        type: 'DELETE',
        url: URL + "/rest/products/"+ id,
        success: function(){
            $("#"+id).empty();
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('deleteWine error');
        }
    });
}
    function postProduct() {
        var filename = $(":file").val();
        console.log("ffff" + filename);
        $.ajax({
            type: "POST",
            contentType: 'application/json',
            url: URL + "/rest/products",
            data: formToJSONProduct(),
            dataType: "json",
            success: function (data) {
                console.log("мы добавили продукт"+$("#tbproduct tbody").text());
                $("#tbproduct tbody").append('<tr id="'+data.id+'"><td id="idProduct" class="text-center">'+ data.id+'</td> <td class="text-center">'+
                    data.name+'</td> <td class="text-center">'+
                    data.rating+'</td> <td class="text-center">'+
                    data.producer.name+'</td> <td class="text-center">'+
                    data.subcategory.name+'</td> <td>'+
                    '<button type="button" id="delete" onclick="deleteProduct('+data.id+')" class="btn btn-danger btn-xs">Удалить</button>'+'</td>'+'</tr>');
               console.log("мы добавили продукт");
                postCharacteristics();
            },
        });
    }
function postCharacteristics() {
    console.log("postfCCCC");
    $.ajax({
        type: "POST",
        contentType: 'application/json',
        url: URL + "/rest/characteristicsProduct",
        data: formToJSONCharacteristics(),
        success: function () {
            console.log("мы добавили характеристики");
            $('div.result').html("Продукт добавлен");
        },
    });
}

    function formToJSONProduct() {
        console.log("hjjjj" + $("div.result").text());
        console.log("hfh" + $("#subcategory option:selected").val());
        return JSON.stringify({
            "photo":$(":file").val(),
            "name": $('#nameProduct').val(),
            //   "idProducer": $('div.result').html(),
            "idProducer": getProducer($('#producer').val()),
            "idSubcategory": $("#subcategory option:selected").val(),
            "countProduct" : $("#countProduct").val(),
            "producer":{"name": $('#producer').val()} ,
            "subcategory" : {"name" :$("#subcategory option:selected").text() }
            
        });
    }
    function formToJSONCharacteristics() {

        var arrObjects = [];
        $(".fieldValue").each(function(i,elem){
            console.log("element "+elem.getElementsByClassName("characteristic"));
            arrObjects[i] = {
                "nameCharacteristic": $(elem.getElementsByClassName("characteristic")).text(),
                "value": $(elem.getElementsByTagName("input")).val(),
                "product":{"id": getProduct($('#nameProduct').val())}
            }
        });
        return JSON.stringify(arrObjects);
    }

    function getProduct(name) {
        console.log("мы здесь");
        var str = 0;
        $.ajax({
            type: "GET",
            dataType: "json",
            async: false,
            url: URL + "/rest/products/" + name,
            success: function (data) {
                $.each(data, function (j, pdata) {
                    str = pdata.id;
                });
                //callback(str);
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(' Error in processing! ' + textStatus);
            }
        });
        return str;
    }
function getProducer(name) {
    var str = 0;
    $.ajax({
        type: "POST",
        dataType: "json",
        async: false,
        contentType: 'application/json',
        data: JSON.stringify({"name":name}),
        url: URL + "/rest/producer/",
        success: function (data) {
            $.each(data, function (j, pdata) {
                str = pdata.id;
            });
            //callback(str);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }
    });
    return str;
}

    function getCategory() {
        $.ajax({
            type: "GET",
            dataType: "json",
            url: URL + "/rest/subcategory/",
            success: function (data) {
                $.each(data, function (j, pdata) {
                    $('#subcategory').append('<option value="' + pdata.id +
                        '">' + pdata.name + '</option>');
                })
                console.log("ggggggggggggggggggggggggggggg" + $("#subcategory option").val());
            },
            error: function (jqXHR, textStatus, errorThrown) {
                console.log(' Error in processing! ' + textStatus);
            }
        });
    }

    function getCharacteristics() {
        var k = 0;
        console.log("fdkfkljg");

            var str = "";
            $("select option:selected").each(function () {
                str += $(this).text();
            });
            if ($("select option:selected").val() != "choice") {
                $(".hiding").show();
                $.ajax({
                    type: "GET",
                    dataType: "json",
                    url: URL + "/rest/characteristics/" + $("select option:selected").text(),
                    success: function (data) {
                        $.each(data, function (j, pdata) {
                            $(".characteristic:eq(" + k + ")").text(pdata.name);
                            k++;
                        });
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        console.log(' Error in processing! ' + textStatus);
                    }
                });
            }

    }
