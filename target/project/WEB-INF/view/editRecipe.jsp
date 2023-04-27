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

	<h1 align="center">Edit your recipe</h1>
<hr/>
<div align="center">
 <p>
 <label>Select a recipe:</label>
	<select name="name">

		<c:forEach items="${myRecipes}" var="recipe">
			<option value=${recipe.name}>${recipe.name}</option>
		</c:forEach>
			</select>
</p>
</div>
<form:form action ="/project/process-add-recipe" method="post" modelAttribute="recipe">

<div align="center">
<p>
	<label>Name: </label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>
</p>
<p>
	<label>Time:</label>
    <form:input path="time"/>
    <form:errors path = "time" cssClass="error"/>
</p>
<p>
	<label>Portion: </label>
    <form:input path="portion"/>
    <form:errors path="portion" cssClass="error"/>
</p>
<p>
	<label>Calories: </label>
    <form:input path="calories"/>
    <form:errors path="calories" cssClass="error"/>
</p>
<p>
	<label>Ingredients Quantity:</label>
    <form:input path="ingredientsQuantity"/>
    <form:errors path="ingredientsQuantity" cssClass="error"/>
</p>

<input type="submit" value = "Add">
</div>
</form:form>

</body> 
</html>