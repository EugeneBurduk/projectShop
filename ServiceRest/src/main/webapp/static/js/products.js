$(document).ready(function(){
    console.log("ghgjhbjkhun!!!!!!!!!");
    countOrder();
    getProducts();
    $(".dropdown-menu li a").click(function (e) {
        e.preventDefault();
        sorting(this.id);
        return false;
    });
   /* $(".form-group input").onfocus(function (e) {
        alert("kl");
    }) ;*/
  $('.form-group input').change(function(e){
        e.preventDefault();
        productsFilter();
    });
  $(".producers input").change(function () {
           alert("gfdgvf");
  })
});

function checkedBrand(producer){
    $('.producers').find('input:checked').each(function () {
        productsFilter(producer);
    });
}

function sorting(id) {
    console.log("эхх");
    var mylist = $('#products');
    var elements = $('.product');
    if(id=="expensive"){
            alert("expensive");
        elements.sort(function (a, b) {
            var an = +$(a).find(".price").text(),
                bn = +$(b).find(".price").text();
            return bn-an;
        });
    }
    else if(id=="cheap"){
        alert("cheap");
        elements.sort(function (a, b) {
            var an = +$(a).find(".price").text(),
                bn = +$(b).find(".price").text();
            return an-bn;
        });
    }
    else {
        elements.sort(function (a, b) {
            var an = +$(a).find(".rating input").val(),
                bn = +$(b).find(".rating input").val();
            return bn-an;
        });
    }

    $.each(elements, function(idx, itm) {
        mylist.append(itm); });

}