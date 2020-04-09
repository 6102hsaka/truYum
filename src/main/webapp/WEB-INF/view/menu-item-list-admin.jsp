<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet"/>
<title>Menu-Item-List-Admin</title>
</head>
<body>
	<header>
	truYum
	<a class="header-link" href="show-menu-list-admin">Menu</a>
	</header>
	<h1 class="menu-items">Menu Items</h1>

	<table>
		<thead>
			<th class="align-left">Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>DateOfLaunch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${menuItems}" var="menuItem">
				<tr>
					<td class="align-left">${menuItem.name }</td>
					<td>${menuItem.price }</td>
					<td>${menuItem.active }</td>
					<td>${menuItem.dateOfLaunch }</td>
					<td>${menuItem.category }</td>
					<td> <c:out value="${menuItem.freeDelivery ? 'Yes' : 'No'}"/> </td>
					<td><a href="show-edit-menu-item?id=${menuItem.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<footer>
	Copyright &copy 2019
	</footer>
	
</body>
</html>