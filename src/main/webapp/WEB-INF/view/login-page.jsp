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
<body>

	<h1 align="center">Welcome to RECIPLEASE</h1>
<hr/>
<form:form action ="process-login-page" method="post" modelAttribute="UserData">
<div align="center">
<p>
	<label for="yn">User name:</label>
    <form:input id="yn" path="userName"/>
    <form:errors path="userName" cssClass="error"/>
</p>

<p>
	<label for="cn">Password:</label>
    <form:password id="cn" path="password"/>
    <form:errors path = "password" cssClass="error"/>
</p>
<input type="submit" value = "Login">

</div>
</form:form>


</body> 
</html></html>