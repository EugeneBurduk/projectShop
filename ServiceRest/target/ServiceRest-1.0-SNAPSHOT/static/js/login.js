$(document).ready(function () {
    countOrder();
    $("form button").click(function (e) {
        e.preventDefault();
        $.ajax({
            type: "GET",
            contentType: 'application/json',
            url: document.location.origin + "/rest/login/"+$("#username").val()+"/"+$("#password").val(),
            success: function () {
                console.log("kkkk");
                countOrder();
            },
            error: function (data) {
                console.log(data);
            }
        });
    });
});

/*function countOrder() {
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        url: document.location.origin+"/rest/order",
        success: function (data) {
            console.log("ok"+data.length);
            $(".circle").text(data.length);
            $(".circle").show();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(' Error in processing! ' + textStatus);
        }

    });
}*/