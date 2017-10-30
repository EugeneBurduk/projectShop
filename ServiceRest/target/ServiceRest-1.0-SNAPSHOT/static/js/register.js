$(document).ready(function(){
    $('form').bootstrapValidator({
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and can\'t be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The username must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'The username can only consist of alphabetical, number, dot and underscore'
                    }
                }
            },
            confirmPassword: {
                validators: {
                    notEmpty: {
                        message: 'The confirm password is required and can\'t be empty'
                    },
                    identical: {
                        field: 'password',
                        message: 'The password and its confirm are not the same'
                    }
                }
            }
        }
    });
    $('form button').click(function (e) {
        e.preventDefault();
        postUser();
    });
  /*  $("#username").keypress(function (e) {
        findUser();
    });*/
    $("#username").change(function (e) {
        findUser();
    });


});
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
function findUser() {
    $.ajax({
        type: "GET",
        contentType: 'application/json',
        url: document.location.origin + "/rest/user/"+$("#username").val(),
        success: function () {
            console.log("kkkk");
        },
        error: function (data) {
            console.log(data);
        }
    });
}
