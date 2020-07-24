<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Task Description</title>

<style>

	.error {
		color: #ff0000;
	}
</style>

</head>

<body>
<table align="center">
	<tr><td>EMPLOYEE TASK </td></tr>
	<form:form action="employeetask" method="post" modelAttribute="employeetask">
	<tr>
				<td><label for="emp_id">Emp id: </label> </td>
				<td><form:input type="number"  path="emp_id" id="emp_id"/></td>
				<td><form:errors path="emp_id" cssClass="error"/></td>
		    </tr>
		
		<tr>
				<td><label for="task_id">Task id: </label> </td>
				<td><form:input type="number"  path="task_id" id="task_id"/></td>
				<td><form:errors path="task_id" cssClass="error"/></td>
		    </tr>
		    
		   <tr>
			
             <td><label for="start_date">Start Date: </label> </td>
           <td> <form:input type="datetime"   path="start_date"  id="start_date"/></td>
           <td><form:errors path="start_date" cssClass="error"/></td>
        
     </tr>
     
     <tr>
			
             <td><label for="end_date">End Date: </label> </td>
           <td> <form:input type="datetime"  path="end_date"  id="end_date"/></td>
          <td><form:errors path="end_date" cssClass="error"/></td> 
        
     </tr>
     
		    <tr><td>
		    <input type="submit" value="Register"/>&emsp;   <input type="reset" value="Reset"/></td></tr>
		    </form:form>
		    </table>
</body>
</html>