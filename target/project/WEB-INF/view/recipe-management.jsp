<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">

  table, th, td {
     border: 1px solid black;
     text-align: center;
  }

</style>
<title>Reciplease</title>
</head>
<body>
<h1 align="center">Hi ${userName} here are you recipes</h1>
 
<script>
      function setSorting(sortType) {
        window.location.href = '/project/user-recipes?sort=' + sortType;
      }
</script>

<table align="center">
		<tr>
			<td>ID</td><td>CATEGORY</td><td>NAME</td><td>TIME</td><td>INGREDIENTS</td><td>CALORIES</td><td>PORTIONS</td>
		</tr>
		<c:forEach items="${myRecipes}" var="recipe">
			<tr>
			<td>${recipe.id}</td>
			<td>${recipe.category}</td>
			<td>${recipe.name}</td>
			<td>${recipe.time}</td>
			<td>${recipe.ingredientsQuantity}</td>
			<td>${recipe.calories}</td>
			<td>${recipe.portion}</td>
			</tr>
		</c:forEach>
	</table>
	</br>
	<div style="text-align: center;">
	  <fieldset style="width: 600px;margin: 0 auto;">
		  <legend>Sort by:</legend>
		    <button onclick="setSorting('name')">NAME</button>
	  		<button onclick="setSorting('time')">TIME</button>
	  		<button onclick="setSorting('ingredients')">INGREDIENTS</button>
	  		<button onclick="setSorting('calories')">CALORIES</button>
	  		<button onclick="setSorting('portions')">PORTIONS</button>
	  		<button onclick="setSorting('category')">CATEGORY</button>
	  </fieldset>
	  </br>
  	   <button onclick="window.location.href = '/project/add-recipe';">Add new recipe</button>
	   <form:form action="/project/process-user-recipes" method="post" modelAttribute="recipe">
	   </br>
                <td><form:select path="id" title="Id">
                    <c:forEach items="${myRecipes}" var="recipeTemp">
						<form:option value="${recipeTemp.id}">${recipeTemp.id}</form:option>
					</c:forEach>
                  	</form:select></td>
            </tr>
            <tr>
                <td><form:button>Edit your recipe</form:button></td>
            </tr>
    </form:form>
    </br>
    	   <button onclick="window.location.href = '/project/home';">Come back to all recipes</button>
  	  </div>
</body>
</html>