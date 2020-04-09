<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet" />
<title>Cart</title>
</head>
<body>

	<header>
		truYum 
		<a class="header-link" href="show-cart">Cart</a> 
		<a class="header-link" href="show-menu-list-customer">Menu</a>
	</header>
	<h1 class="menu-items">Cart</h1>
	
	<c:if test="${removeCartItemStatus==true}">
	<p class="msg-green">Item removed to Cart Successfully</p>
	</c:if>
	
	<table>
		<thead>
			<th class="align-left">Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${menuItems}" var="menuItem">
			<tr>
			<td class="align-left">${menuItem.name }</td>
			<td> <c:out value="${menuItem.freeDelivery ? 'Yes' : 'No'}"/> </td>
			<td>${menuItem.active }</td>
			<td> <a href="remove-cart?userId=1&menuItemId=${menuItem.id}">Delete</a> </td>
			</tr>
			</c:forEach>
		</tbody>
	</table>


	<footer> Copyright &copy 2019 </footer>
</body>
</html>