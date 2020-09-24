<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <style>
    	<jsp:include page="../css/style.css"/>
    	<jsp:include page="../css/loginform.css"/>
    </style>
</head>
<body>
	<div id="mySidenav" class="sidenav">
        <jsp:include page="sidenavlogin.jsp"></jsp:include>
    </div>
    
    <div id="main">
        <div class="header">
            <jsp:include page="header.jsp"></jsp:include>
        </div>

        <div class="main-content">
            <jsp:include page="loginform.jsp"></jsp:include>
        </div>
        <div class="footer">
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </div>
    
    <script>
    	<jsp:include page="../js/login.js"/>
    </script>
</body>
</html>