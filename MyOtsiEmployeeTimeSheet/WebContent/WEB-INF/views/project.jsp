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

	<h2 align="center">Project Registration Form</h2> 
	<form:form action="project" method="POST" modelAttribute="project" >
		<table align="center">
		  
		<tr>
				<td><label for="name">Firstname: </label> </td>
				<td><form:input path="name" id="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
		    </tr>
		    
		    <tr>
		    <td><label for="status">Status: </label> </td>
		  <td> <form:select path="status" items="${address}" id="status" /></td>
		   </tr>
		      <tr>
			
             <td><label for="start_date">Start Date: </label> </td>
           <td> <form:input  path="start_date"  id="start_date"/></td>
           <td><form:errors path="start_date" cssClass="error"/></td>
        
     </tr>
     
     <tr>
			
             <td><label for="end_date">End Date: </label> </td>
           <td> <form:input  path="end_date"  id="end_date"/></td>
            <td><form:errors path="end_date" cssClass="error"/></td>
        
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