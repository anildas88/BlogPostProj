<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Account Registration Form</title>

</head>

<body>

	
	<h3 style="color:red;text-align:center">${message}</h3>
	
		<h1>Account Registration</h1>
		<form:form action="accReg" method="POST" modelAttribute="userModel" >
			<p>First Name</p>
			<form:input path="name" /> 
			<p>Email :</p> 
			<form:input path="email"/>
			<p>Password :</p> 
			<form:password path="password"/>
			<input type="submit" value="Register" />
		</form:form>


	</body>
</html>