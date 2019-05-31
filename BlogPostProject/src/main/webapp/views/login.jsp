<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="color:red;text-align:center">${message}</h3>
<form:form action="dologin" method="post" modelAttribute="login">

<table>
<tr>
<td>uname</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>pwd</td>
<td><form:input path="pwd"/></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>

</form:form>

</body>
</html>