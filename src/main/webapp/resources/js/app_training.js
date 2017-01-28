/**
 * Created by JPMPC-B210 on 11/24/2016.
 */

canvasF();
function canvasF(){
    var v = document.getElementById('thisVid');
    var canvas = document.getElementById('myCanvas');
    var context = canvas.getContext('2d');

    var cw = Math.floor(canvas.clientWidth*2);
    var ch = Math.floor(canvas.clientHeight*2);
    canvas.width = cw;
    canvas.height = ch;

    function draw(v,c,bc,w,h) {
        if (v.paused || v.ended) return false;
        // First, draw it into the backing canvas
        bc.drawImage(v, 0, 0, w, h);
        // Grab the pixel data from the backing canvas
        var idata = bc.getImageData(0, 0, w, h);
        var data = idata.data;
        // Loop through the pixels, turning them grayscale
        for (var i = 0; i < data.length; i += 4) {
            var r = data[i];
            var g = data[i + 1];
            var b = data[i + 2];
            var brightness = (3 * r + 4 * g + b) >>> 3;
            data[i] = brightness;
            data[i + 1] = brightness;
            data[i + 2] = brightness;
        }
        idata.data = data;
        // Draw the pixels onto the visible canvas
        c.putImageData(idata, 0, 0);
        // Start over!
        setTimeout(function () {
            draw(v, c, bc, w, h);
        }, 0);
    }

    v.addEventListener('play', function(){
        draw(this,context,cw,ch);
    },false);

};

function draw(v,c,w,h) {
    if(v.paused || v.ended) return false;
    c.drawImage(v,0,0,w,h);
    setTimeout(draw,0,v,c,w,h);
}


$.validator.setDefaults({
    submitHandler: function() {
        alert("submitted!");
    }
});

$().ready(function() {
    // validate the comment form when it is submitted
    $("#signupform").validate();

    // validate signup form on keyup and submit
    $("#signupForm").validate({
        rules: {
            name: "required",
            email: {
                required: true,
                email: true
            },
            tel_no: "required"
        },
        messages: {
            name: "*field required",
            email: "*field required",
            tel_no: "*field required"
        }
    });
});


var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");
ctx.beginPath();
ctx.arc(95,50,40,0,2*Math.PI);
ctx.stroke();


var w;
function startWorker() {
    if(typeof(Worker) !== "undefined") {
        if(typeof(w) == "undefined") {
            w = new Worker("js/demo_workers.js");
        }
        w.addEventListener('message',function(e){
                var $i = e.data;
                var $count = 1+$('.conversation').length;

                $("#result").append('<p class="conversation">User says: ' + $i + '</p>');
                $("#counter").text($count);
                $("#counter1").text($i);

                $('#result').animate({
                    scrollTop: $('#result').get(0).scrollHeight
                }, 150);


            },
            false
        );
    } else {
        $("#result").html = "Sorry, your browser does not support Web Workers...";
    }
}
function stopWorker() {
    w.terminate();
    w = undefined;
}


/*start of media controls*/
function mediaController(task) {
    if(task == "play_pause"){
        if (thisAudio.paused) {
            thisAudio.play();
            document.getElementById("playPauseBtn").innerText = "▌▐";
        }
        else {
            thisAudio.pause();
            document.getElementById("playPauseBtn").innerText = "►";
        }
    }
    if (task == "stop"){
        thisAudio.currentTime = 0;
        thisAudio.pause();
        document.getElementById("playPauseBtn").innerText = "►";
    }
    if (task == "rewindVid"){
        thisVid.currentTime = thisVid.currentTime - 5;
    }
    if (task == "play_pauseVid"){
        if (thisVid.paused) {
            thisVid.play();
            document.getElementById("vidPlayBtn").innerHTML = "▌▐";
            document.getElementById("vidPlayBtn").title = "Click to pause";
        }
        else {
            thisVid.pause();
            document.getElementById("vidPlayBtn").innerHTML = "►";
            document.getElementById("vidPlayBtn").title = "Click to play";
        }
    }
    if (task == "forwardVid"){
        thisVid.currentTime = thisVid.currentTime + 10;
    }
    if (task == "stopVid"){
        thisVid.currentTime = 0;
        thisVid.pause();
        document.getElementById("vidPlayBtn").innerHTML = "►";
        document.getElementById("vidPlayBtn").title = "Click to play";
    }
    if (task == "fullscreen"){
        thisVid.webkitRequestFullscreen();
    }

}
/*end of media control controls*/