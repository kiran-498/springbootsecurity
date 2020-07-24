<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Confirmation Page</title>
<style>
.error {
		color: #ff0000;
	}</style>
</head>
<body>
<br/>
	<br/><br/>
	<br/><br/>
	<br/>
	<table align="center">
<tr><td>
	MESSAGE :.error ${success}</td><td>
	
	Go back to <a href="<c:url value='/list' />">List of All Employees</a></td><td>
	
	<h4 align="center"><a href="<c:url value='/new' />">Add New Employee</a></h4></td></tr></table>
	
</body>

</html>