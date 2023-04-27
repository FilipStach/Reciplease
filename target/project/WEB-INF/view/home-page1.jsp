<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
error {
	color: red;
	position: fixed;
	text-align: left;
	margin-left: 30px;
}

  table, th, td {
     border: 1px solid black;
     text-align: center;
  }

</style>
</head>
<body>

	<h1 align="center">Hi ${userName}</h1>
<hr/>
 
<script>
      function setSorting(sortType) {
        window.location.href = '/project/home?sort=' + sortType;
      }
</script>

<table align="center">
		<tr>
			<td>ID</td><td>CATEGORY</td><td>NAME</td><td>TIME</td><td>INGREDIENTS</td><td>CALORIES</td><td>PORTIONS</td>
		</tr>
		<c:forEach items="${recipes}" var="recipe">
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
	  <button onclick="window.location.href = '/project/user-recipes';">Go to your recipes</button>
  	  </div>
</body> 
</html>