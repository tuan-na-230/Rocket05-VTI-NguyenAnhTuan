<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Cong tru nhan chia</h1>
<!-- 	<form action="Exercise_2/ketqua.jsp"> -->
<!-- 		So hang 1 <input type="number" name="so1">  -->
<!-- 		<br>  -->
<!-- 		So hang 2 <input type="number" name="so2"> -->
<!-- 		<br> -->
<!-- 		<input type="button" value="+"> -->
<!-- 		<input type="button" value="-"> -->
<!-- 		<input type="button" value="*"> -->
<!-- 		<input type="button" value="/"> -->
		
<!-- 	</form> -->
	<form name="myform">
		So hang 1 <input type="text" name="so1"><br>
		So hang 2 <input type="text" name="so2"><br><br>
		<input type="button" name="" value="+" onclick="add()">
		<input type="button" name="" value="-" onclick="subtract()">
		<input type="button" name="" value="*" onclick="multiply()">
		<input type="button" name="" value="/" onclick="divide()"><br>
		<br> <input type="text" name="result">
		
		
	</form>

	<script type="text/javascript">
		function add() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 + so2;
			myform.result.value = result;
		}

		function subtract() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 - so2;
			myform.result.value = result;
		}

		function multiply() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 * so2;
			myform.result.value = result;
		}
		function divide() {
			so1 = parseInt(myform.so1.value);
			so2 = parseInt(myform.so2.value);
			result = so1 / so2;
			myform.result.value = result;
		}
	</script>
</body>
</html>