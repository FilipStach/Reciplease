<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style type="text/css">
<head>
<meta http-equiv = "Content-Type" content = "text/html; charset=UTF-8">

<title>Homepage</title>
<style type="text/css">
.error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}

</style>
</head>
<body></body>

	<h1 align="center">Welcome to Reciplease</h1>
<hr/>
<form:form action ="process-homepage" method="post" modelAttribute="loginData">
<div align="center">
${wrongData}
<p>
	<label >Email: </label>
    <form:input  path="email"/>
    <form:errors path="email" cssClass="error"/>
</p>

<p>
	<label >Password:</label>
    <form:password path="password"/>
    <form:errors path = "password" cssClass="error"/>
</p>
<input type="submit" value = "Login">
</div>
</form:form>
<br>
<div align="center">
	<button onclick="window.location.href = '/project/registration';">Register</button>
</div>
<br><br>

</body> 
</html>