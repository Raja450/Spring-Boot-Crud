<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="stag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: RoyalBlue;
}
</style>
<title>- Employee List</title>

<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 70%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}
</style>
</head>
<body style="background-color: #FFFFE0;">
	<div style="margin-top: 50px; margin-left: 700px; height: 50px;">
		<a href="/registration">Registration</a>
	</div>
	<div style="margin-top: 50px; margin-left: 200px; height: 50px;">

		<h1>Employee List</h1>

	</div>
	<table style="margin-top: 0px; margin-left: 100px;">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Mobile Number</th>
			<th>Address1</th>
			<th>Address2</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Status</th>

		</tr>
		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}${emp.lastName}</td>
				<td>${emp.dateOfBirth}</td>
				<td>${emp.mobile}</td>
				<td>${emp.address1}</td>
				<td>${emp.address2}</td>
				<td>${emp.age}</td>
				<td>${emp.gender}</td>
				<td>${emp.email}</td>

				<td><a href="/edit?id=${emp.id}"><button class="btn">
							<i class="fa fa-edit"></i>
						</button></a>

					<form action="/delete?id=${emp.id}" method="post">

						<button class="btn">
							<i class="fa fa-trash"></i>
						</button>



					</form></td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>