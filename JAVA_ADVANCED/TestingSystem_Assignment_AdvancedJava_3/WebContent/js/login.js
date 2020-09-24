$(function() {
	$("a.login").hide();
	$("span#username").hide();
	$("span#role").hide();
	$("a.logout").hide();
});

function openNav() {
    if(document.getElementById("mySidenav").style.width != "70px"){
        document.getElementById("mySidenav").style.width = "70px";
        document.getElementById("main").style.marginLeft = "70px";
    }
    else{
        closeNav();
    }
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}

function openHome(){
    location.replace("./");
}

function login(){
	location.replace("./login");
}