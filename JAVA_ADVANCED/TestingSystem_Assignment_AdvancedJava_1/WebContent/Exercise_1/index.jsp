<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<% out.print("welcome to jps"); %>
	<br>
	Current Time: <%= java.util.Calendar.getInstance().getTime() %>
	<br>
	<%! String name =  "VTI ACADEMY"; %>
	<%= "Hello " + name %>
	<br>
	<%@ page import="java.util.Date" %>
	Today is: <%= new Date() %>
	<br>
	<form action="Exercise_1/welcome.jsp">
		<input type="text" name="username">
		<input type="submit" value="GO">
	</form>
</body>
</html>