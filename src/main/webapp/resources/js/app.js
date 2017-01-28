/**
 * Created by JPMPC-B210 on 11/24/2016.
 */
/*
if(!alertify.myAlert){
    //define a new dialog
    alertify.dialog('myAlert',function factory(){
        return{
            main:function(message){
                this.message = message;
            },
            setup:function(){
                return {
                    buttons:[{text: "back", key:27/!*Esc*!/}],
                    focus: { element:0 }
                };
            },
            prepare:function(){
                this.setContent(this.message);
            }
        }});
}
*/

/*
if (window.localStorage.length >= 1){
    alert("Already Registered");
    $("#sec1").html("<h1>You are already Registered</h1><a href='http://localhost:8080'><input type='button' id='clearStorage' value='Register new account'/></a>");
}*/

// Hibernate JAVAX








/*
<!--Storing submit data-->
$("#submit").click (function (event){
    event.preventDefault();

    var agreement = document.getElementById("agreement").checked;
    var $email = $("#email").val();
    var $name = $("#name").val();
    var $mobile = $("#tel_no").val();
     localStorage.setItem("name", $name);
     localStorage.setItem("email", $email);
     localStorage.setItem("mobile", $mobile);
*/
 /*
 $.ajax({
        type: "post",
        url: "/post",
        data:$("#signupForm").serialize(),
        data: ({
         name: $name,
         email: $email,
         tel_no: $mobile
         }),
        dataType:"json",
        error: function () {
            alert("Failed");
        },
        success: function (response) {

        if (response.message == "required") {
            //alert("data is " + response.message);
            alertify.alert("Please fill out all data");
        }
        else if(agreement==false){
            alertify.alert("Please agree on our terms");
        }
        else{
            function validateEmail(email) {
            var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
            return re.test(email);
        }
            if (!validateEmail(response.email)) {
                alertify.alert("Please enter a valid e-mail");
            }
            else {

                alertify.confirm("Confirm Submission?.",
                    function () {
                        //$("#sec1").fadeOut();
                        alertify.alert("Thank you " + response.name);
                        alertify.set('notifier','position', 'top-left');
                        alertify.success('Successfully Registered');
                        $("#sec1").html("<a href='http://localhost:8080'><button>Register another account</button></a>");
                    },
                    function () {
                        alertify.error('Canceled');
                    });
            }
        }
        },
    })


})*/




/*
$('#clearStorage').click(function () {
    localStorage.clear();
});
*/


/*
var myDiv = $("#result");
myDiv.animate({ scrollTop: myDiv.attr("scrollHeight") - myDiv.height() }, 3000);
*/
