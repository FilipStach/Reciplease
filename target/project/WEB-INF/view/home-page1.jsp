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

	<h1 align="center">Love Calculator</h1>
<hr/>
<form:form action ="process-homepage" method="post" modelAttribute="userInfo">
<div align="center">
<p>
	<label for="yn">Your name:</label>
    <form:input id="yn" path="userName"/>
    <form:errors path="userName" cssClass="error"/>
</p>

<p>
	<label for="cn">Crush name:</label>
    <form:password id="cn" path="crushName"/>
    <form:errors path = "crushName" cssClass="error"/>
</p>
<input type="submit" value = "calculate">
<p>
	<form:checkbox path="termAndCondition" id = "check"/>
	<label>I agree that this if for fun</label>
	<form:errors path = "termAndCondition" cssClass="error"/>
</p>
</div>
</form:form>

<a href="/spring-love-calc/register" > Register </a>
<br><br>

User Name: ${userRegistrationInfo.userName}
</body> 
</html>