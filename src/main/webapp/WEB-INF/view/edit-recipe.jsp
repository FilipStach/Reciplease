<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
 <!--  <p>
 <label>Select a recipe:</label>
	<select name='${id}'>

		<c:forEach items="${myRecipes}" var="recipe">
			<option value=4>${recipe.id}</option>
		</c:forEach>
			</select>
			
<p>
<form:select path = "id">
        <c:forEach items="${myRecipes}" var="recipe">
			<form:option value="${recipe.id}" label="${recipe.id}"/>  
		</c:forEach>
</form:select> 
</p>
<button onclick="setRecipe('${id}')">Pick</button>
-->
<form:form action="/project/edit-recipe" method="post">
			<p>
				<label>Select a recipe:</label>
				<form:select path="id">
					<c:forEach items="${myRecipes}" var="recipe">
						<form:option value="${recipe.id}">${recipe.id}</form:option>
					</c:forEach>
				</form:select>
			</p>
			<p>
				<input type="button" value="Pick" onclick="setRecipe()"/>
			</p>
		</form:form>
		<form:form action="/project/edit-recipes" method="get" id="form">
		<input type="hidden" name="id" id="id" value=""/>
	</form:form>

</div>
<script>
		function setRecipe() {
			var id = document.getElementsByName("id")[0].value;
			document.getElementById("id").value = id;
			document.getElementById("form").submit();
		}
	</script>
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
<script>
      function setRecipe(id) {
        window.location.href = '/project/edit-recipes?id=' + id;
      }
</script>
</body> 
</html>