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
	
	<form:form action="taskdescreg" method="post" modelAttribute="taskdescreg">
	
		<tr><td>TASK DESCRIPTION</td></tr>
		<tr>
				<td><label for="task_id">Task id: </label> </td>
				<td><form:input type="number"  path="task_id" id="task_id"/></td>
				<%-- <td><form:errors path="lname" cssClass="error"/></td> --%>
		    </tr>
		   <tr>
		          <td><label for="Phase">Phase: </label> </td>
		         <td> <select name="Phase" id="Phase">
    <option value="-1">Select Phases</option>
    <option value="APPLICATION SUPPORT">APPLICATION SUPPORT</option>
    <option value="DEVELOPMENT">DEVELOPMENT</option>
    <option value="SYSTEM ADMINISTRATOR">SYSTEM ADMINISTRATOR</option>
    <option value="NETWORKING">NETWORKING</option>
</select>
		   </td> 
		    </tr>
		    
		    <tr>
				<td><label for="description">Description: </label> </td>
				<td>
				<form:textarea path="description" row="5" col="40" id="description"></form:textarea></td>
				<td><form:errors path="description" cssClass="error"/></td>
		    </tr>
		    <tr><td>
		    <input type="submit" value="Register"/>&emsp;<input type="reset" value="Reset"/></tr></tr>
		    </form:form>
		    </table>
</body>
</html>