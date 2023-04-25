
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
<p>Sort by:</p>
<ul>
<button onClick="window.location.reload();">Refresh Page</button>
<button onClick="setValue()">Sort by Name</button>
</br>
<form:form action="update-model" method="post" modelAttribute="model">
  <form:hidden path="sort" />
  <form:button value="Set Value in Model" onclick="setValue('name')" />
</form:form>
    <li><a href="?sort=name">Name</a></li>
    <li><a href="?sort=calories">Calories</a></li>
</ul>
<script>
function setSorting(sortingType) {
  var input = document.getElementsByName("model.sort")[0];
  input.value = sortingType;
  var form = document.getElementById("model");
  form.submit();
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
</body> 
</html>