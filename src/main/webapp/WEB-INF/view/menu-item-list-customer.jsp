<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet"/>
<title>Menu-Item-List-Customer</title>
</head>
<body>
	<header>
	truYum
	<a class="header-link" href="show-cart?userId=1">Cart</a>
	<a class="header-link" href="show-menu-list-customer">Menu</a>
	</header>
	<h1 class="menu-items">Menu Items</h1>
	
	<c:if test="${addCartStatus==true}">
	<p class="msg-green">Item Added to Cart Successfully</p>
	</c:if>
	
	<table>
		<thead>
			<th class="align-left">Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach items="${menuItems}" var="menuItem">
				<tr>
					<td class="align-left">${menuItem.name }</td>
					<td>${menuItem.freeDelivery }</td>
					<td>${menuItem.price }</td>
					<td>${menuItem.category }</td>				
					<td><a href="add-to-cart?menuItemId=${menuItem.id}">Add to Cart</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<footer> Copyright &copy 2019 </footer>

</body>
</html>