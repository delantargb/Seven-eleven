$("#submit").click (function (event) {
    event.preventDefault();

    $.ajax({

        url: "/thankyou",
        data: $("#signupForm").serialize(),
        method: "POST",
        dataType:"json",
        error: function (e) {
            alert(e);
        },
        success: function (response) {
            if (response.message) {
                alertify.set('notifier','position', 'top-right');
                alertify.success("You have successfully Registered");
                $("#sec1").html("<h1>Thank You!</h1>"+response.name);
            } else {
                $(".has-error").removeClass("has-error");
                $(".error-msg").remove();
                //$("#errorMsg").remove();
                $.each(response, function (a, b) {
                    $("#"+a).hide().fadeIn().addClass("has-error")
                    $("#"+a).after("<p id=error-"+a+" class='error-msg'>*"+b+"</p>");
                });
                }
        },
    })
})



/*
.val(response[b])
.blur(function () {
 if (this.value == '') {this.value = response[b];}
 })
 .focus(function () {
 if (this.value == response[b]) {this.value = '';}
 })
 alertify.error(response[b]);*/
