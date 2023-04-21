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

</style>
</head>
<body>

	<h1 align="center">Welcome to RECIPLEASE</h1>
<hr/>
<form:form action ="process-login-page" method="post" modelAttribute="UserInfo">
<div align="center">
<p>
	<label for="yn">Email:</label>
    <form:input id="yn" path="email"/>
    <form:errors path="email" cssClass="error"/>
</p>
<p>
	<label for="cn">Password:</label>
    <form:password id="cn" path="password"/>
    <form:errors path = "password" cssClass="error"/>
</p>

<input type="submit" value = "Login">
<br/>
<br/>
<tr>
        <font color="red"><td colspan="2" >${errors}</td>
</tr>
</div>
</form:form>


</body> 
</html>