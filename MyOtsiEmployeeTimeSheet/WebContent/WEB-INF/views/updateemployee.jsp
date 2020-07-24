<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>

	<h2 align="center">Update Employee Form</h2> 
	<form:form   method="POST" modelAttribute="employee" >
		<table align="center">
		<%--   <tr>
				<td><label for="emp_id">Emp id: </label> </td>
				<td><form:input path="emp_id" id="emp_id" value="${emp_id}" readonly="true"/></td>
				<td><form:errors path="email_id" cssClass="error"/></td>
		    </tr> --%>
		<tr>
				<td><label for="fname">Firstname: </label> </td>
				<td><form:input path="fname" id="fname"/></td>
				<td><form:errors path="fname" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="lname">Lastname: </label> </td>
				<td><form:input path="lname" id="lname"/></td>
				<td><form:errors path="lname" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="email_id">Email id: </label> </td>
				<td><form:input path="email_id" id="email_id"/></td>
				<td><form:errors path="email_id" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="date_of_join">Date Of Join: </label> </td>
				<td><form:input path="date_of_join" id="date_of_join"/></td>
				<td><form:errors path="date_of_join" cssClass="error"/></td>
		    </tr>
		    <tr>
		    <td><label for="status">Status: </label> </td>
		  <td> <form:select path="status" items="${address}" id="status" /></td>
		   </tr>
		     
		    
		    
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
							<input type="reset" value="Reset"/>
						</c:when> 
						<%-- <c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise> --%>
					</c:choose>
				</td>
		</table>
	</form:form>
	
	<br/>
	<hr></hr>
	<br/>
	<form action="/addreg" method="post">
	<table align="center">
	<tr><td>Location:</td><td><input type="text" name="location"></td></tr>
	<tr><td>City:</td><td><input type="text" name="city"></td></tr>
	<tr><td>Pincode:</td><td><input type="number" name="pincode"></td></tr>
	<tr><td>Phone number:</td><td><input type="number" name="phone_no"></td></tr></table>
 	</form>
	<h4 align="center">Go back to <a href="<c:url value='/list' />">List of All Employees</a></h4>
</body>
</html>