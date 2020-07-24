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

	<h2>Registration Form</h2>
	<table algin="center">
	<tr><td>
     <h1 align="center">message : ${success}</h1></td></tr>
    <tr><td>  <h1 align="center"> ${krish}</h1></td></tr>
	</table>
	<hr></hr>
	
	<form:form action="addreg" method="post" modelAttribute="addressdetails">
		<table align="center">
		    <tr>
				<td><label for="emp_id">Emp id: </label> </td>
				<td><form:input type="number"  value="${empid}" path="emp_id" id="emp_id"  readonly="true"/></td>
				<td><form:errors path="emp_id" cssClass="error"/></td>
		    </tr>
		<tr>
				<td><label for="location">Location: </label> </td>
				<td><form:input path="location" id="location"/></td>
				<td><form:errors path="location" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="city">City: </label> </td>
				<td><form:input path="city" id="city"/></td>
				<td><form:errors path="city" cssClass="error"/></td>
		     </tr>
		     <tr>
				<td><label for="pincode">Pincode: </label> </td>
				<td><form:input path="pincode" id="pincode"/></td>
				<td><form:errors path="pincode" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="phone_no">Phone no: </label> </td>
				<td><form:input path="phone_no" id="phone_no"/></td>
				<td><form:errors path="phone_no" cssClass="error"/></td>
		    </tr>
		     
		   <tr><td>
		    <input type="submit" value="Register"/></td>
		    <td> <input type="reset" value="Reset"/></td></tr>
				<%-- <td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when> 
						<c:otherwise>
							<input type="submit" value="Register"/>
						</c:otherwise>
					</c:choose>
				</td> --%>
		</table>
	</form:form>
	
	Go back to <a href="<c:url value='/list' />">List of All Employees</a>
</body>
</html>