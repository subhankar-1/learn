<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addEmployee">
<input type="text" name="id"><br>
<input type="text" name="name"><br>
<input type="text" name="department"><br>
<input type="text" name="age"><br>
<input type="submit"><br>
</form>
<form action="getEmployeeByAge">
<input type="text" name="age"><br>
<input type="submit"><br>
</form>
<form action="getEmployeeByDepartment">
<input type="text" name="department"><br>
<input type="submit"><br>
</form>
</body>
</html>