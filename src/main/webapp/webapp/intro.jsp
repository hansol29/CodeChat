<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*,
*::before,
*::after{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.blur,
.main,
.particles{
    width: 100%;
    height: 100vh;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1;
}
.blur{
/*    background-color: #212121; */
   /*  background-image: url("https://github.com/ricardoolivaalonso/recursos/blob/master/bg.jpg?raw=true"); */
   	background-image: url("images/computer.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
    filter: blur(5px);
    transform: scale(1.2);
/*     animation: bg 8s linear infinite alternate; */

}
.main{
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    z-index: 100;
}
.title{
    font-family: 'Open Sans Condensed', sans-serif;
    font-size: 120x;
    font-weight: 500;
    letter-spacing: 15px;
    padding: 12.5px 25px;
    text-shadow: 1px 1px 10px black;
    border: 2px solid rgba( 255, 255, 255, .5);
    border-radius: 4px;
    color: white;
}

.particles{
    position: absolute;
    z-index: 200;
    overflow: hidden;
}

.particle{
    border-radius: 50%;
    filter: blur(3px);
    position: absolute;
}
@keyframes bg {
    0%{ transform: scale(1.2);}
    100%{ transform: scale(1.3);}
}
@keyframes move {
    0%{
        transform: translateX(0);
        opacity: 0;
    }
    10% ,90%{
        opacity: 1;
    }
    100%{
        transform: translateX(45vw);
        opacity: 0;
    }
}
</style>
</head>
<body>
	<div class="blur"></div>
	<div class="main" id="main">
		<h1 class="title">Code Chat</h1>
	</div>
	<div class="particles" id="particles"></div>
	<script>
		var particles= document.getElementById("particles");
		
		function main(){
		    var np = document.documentElement.clientWidth / 29;
		    particles.innerHTML = "";
		    for (var i = 0; i < np; i++) {
		        var w = document.documentElement.clientWidth;
		        var h = document.documentElement.clientHeight;
		        var rndw = Math.floor(Math.random() * w ) + 1;
		        var rndh = Math.floor(Math.random() * h ) + 1;
		        var widthpt = Math.floor(Math.random() * 8) + 3;
		        var opty = Math.floor(Math.random() * 5) + 2;
		        var anima = Math.floor(Math.random() * 12) + 8;
		
		        var div = document.createElement("div");
		        div.classList.add("particle");
		        div.style.marginLeft = rndw+"px";
		        div.style.marginTop = rndh+"px";
		        div.style.width = widthpt+"px";
		        div.style.height = widthpt+"px";
		        div.style.background = "white";
		        div.style.opacity = opty;
		        div.style.animation = "move "+anima+"s ease-in infinite ";
		        particles.appendChild(div);
		    }
		}
		window.addEventListener("resize", main);
		window.addEventListener("load", main);
		
		setTimeout(function() { location.href='CodeChatServlet?command=main' },3000);
	</script>
</body>
</html>