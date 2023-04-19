<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>


	<div class="container mt-3">

		

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">UserName</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users}">
						<tr>
							<td class="table-plus">${user.id}</td>
							<td>${user.userName}</td>
							<td>${user.password}</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>