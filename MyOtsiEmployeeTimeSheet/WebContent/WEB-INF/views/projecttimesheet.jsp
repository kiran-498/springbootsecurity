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

	<h2 align="center">Project Time Sheet Registration Form</h2> 
	<form:form action="projecttimesheet" method="POST" modelAttribute="projecttimesheet" >
		<table align="center">
		  
		<tr>
				<td><label for="project_id">Project Id: </label> </td>
				<td><form:input path="project_id" id="project_id"/></td>
				<%-- <td><form:errors path="lname" cssClass="error"/></td> --%>
		    </tr>
		    
		   <tr>
				<td><label for="emp_id">Emp Id: </label> </td>
				<td><form:input path="emp_id" id="emp_id"/></td>
				<%-- <td><form:errors path="lname" cssClass="error"/></td> --%>
		    </tr>
		    <tr>
				<td><label for="task_id">Task Id: </label> </td>
				<td><form:input path="task_id" id="task_id"/></td>
				<%-- <td><form:errors path="lname" cssClass="error"/></td> --%>
		    </tr>
		    
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update"/>
						</c:when> 
						<c:otherwise>
							<input type="submit" value="Register"/>&emsp;
							<input type="reset" value="Reset"/>
						</c:otherwise>
					</c:choose>
				</td>
		</table>
	</form:form>
	
	
	<h4 align="center">Go back to <a href="<c:url value='/list' />">List of All Employees</a></h4>
</body>
</html>