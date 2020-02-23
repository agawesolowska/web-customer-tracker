<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>List of Customers</title>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer"
				onclick="window.location.href='/web-customer-tracker/show-form'; return false;"
				class="add-button" />
			<form method="get" action="search-customers">
				Search customer: <input type="text" name="searchName" /> <input
					type="submit" value="Search" class="add-button" />
			</form>
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="deleteLink"
						value="/web-customer-tracker/delete-customer">
						<c:param name="customerId" value="${tempCustomer.customerId}" />
					</c:url>
					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>