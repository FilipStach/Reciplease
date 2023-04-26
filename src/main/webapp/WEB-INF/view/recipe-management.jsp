<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Hi ${userName} here are you recipes</h1>
<hr/>
<div style="text-align: center;">
	  </br>
	  <button onclick="window.location.href = '/project/add-recipe';">Add new recipe</button>
	   <button onclick="window.location.href = '/project/edit-recipes';">Edit your recipe</button>
	   <button onclick="window.location.href = '/project/process-homepage';">Come back to all recipes</button>
  	  </div>
</body>
</html>