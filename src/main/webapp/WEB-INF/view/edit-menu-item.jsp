<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/style.css" rel="stylesheet" />
<title>Edit Menu Item</title>
</head>
<body>
	<header>
		truYum <a class="header-link" href="show-menu-list-admin">Menu</a>
	</header>
	<h1 class="menu-items">Edit Menu Item</h1>


	<form:form action="show-edit-menu-item" method="post"
		modelAttribute="menuItem">
		<form:hidden path="id"/>
		<table id="edit-menu-item-table">
			<tr>
				<td><form:label path="name">Name</form:label> <br /> <form:input
						path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label> <br /> <form:input
						path="price" /></td>
				<td><form:label path="active">Active</form:label> <br /> <form:radiobutton
						path="active" value="true" />Yes <form:radiobutton path="active"
						value="false" />No</td>
				<td><form:label path="dateOfLaunch">Date of Launch</form:label>
					<br /> <form:input path="dateOfLaunch" /></td>
				<td><form:label path="category">Category</form:label> <br /> <form:select
						path="category">
						<form:option value="Starters">Starters</form:option>
						<form:option value="Main Course">Main Course</form:option>
						<form:option value="Dessert">Dessert</form:option>
						<form:option value="Drinks">Drinks</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td><form:checkbox path="freeDelivery" /> Free Delivery</td>
			</tr>
			<tr>
				<td>
					<Button type="submit" name="submit" id="submit">Save</Button>
				</td>
			</tr>
		</table>
	</form:form>

</body>
</html>