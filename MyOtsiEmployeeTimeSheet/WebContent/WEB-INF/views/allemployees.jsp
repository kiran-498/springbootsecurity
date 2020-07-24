<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>OTSI EMPLOYEE TIME SHEET</title>

	<style>
		tr:first-child{
			font-weight: bold;
			background-color: #C6C9C4;
		}
	</style>

</head>


<body>
	<h1 align="center">List of Employees</h1>	
	<table align="center">
		<tr>
			<td>FIRSTNAME</td><td>LASTNAME</td><td>EMAIL ID</td><td>DATE OF JOIN</td><td>STATUS</td><td>EMPLOYEE ID</td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
			<td>${employee.fname}</td>
			<td>${employee.lname}</td>
			<td>${employee.email_id}</td>
			<td>${employee.date_of_join}</td>
			<td>${employee.status}</td>
			<td>${employee.emp_id}</td>
			<td><a href="<c:url value='/edit-${employee.emp_id}-employee' />">UPDATE</a></td>
			<td><a href="<c:url value='/delete-${employee.emp_id}-employee' />">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<h4 align="center"><a href="<c:url value='/new' />">Add New Employee</a></h4>
	<h4 align="center"><a href="<c:url value='/taskdescreg' />">Add New Task</a></h4>
	<h4 align="center"><a href="<c:url value='/employeetask' />">Add Employee task start and end time</a></h4>
	<h4 align="center"><a href="<c:url value='/project' />">Add Project Details</a></h4>
	<h4 align="center"><a href="<c:url value='/projecttimesheet' />">Add Project Time Sheet</a></h4>
</body>
</html>