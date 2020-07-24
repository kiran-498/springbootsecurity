<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Employee Registration Form</title>
 
<style>
 

h1 {
color: white; background: teal; FONT-FAMILY: arial, helvetica, lucida-sans, sans-serif; FONT-SIZE: 18pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
h2 {
COLOR: #000000; FONT-FAMILY: verdana, helvetica, lucida-sans, sans-serif; FONT-SIZE: 14pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
h3 {
COLOR: #000000; FONT-FAMILY: lucida-sans, sans-serif; FONT-SIZE: 14pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
h4 {
COLOR: #000000; FONT-FAMILY: lucida-sans, sans-serif; FONT-SIZE: 12pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
h5 {
color: white; background: darkblue; FONT-FAMILY: lucida-sans, sans-serif; FONT-SIZE: 12pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
h6 {
color: yellow; background: green; FONT-FAMILY: lucida-sans, sans-serif; FONT-SIZE: 10pt; FONT-STYLE: normal; FONT-VARIANT: normal
}

body {
COLOR: #000000; FONT-FAMILY: lucida-sans, sans-serif; FONT-SIZE: 10pt; FONT-STYLE: normal; FONT-VARIANT: normal; background-image: url('bkgnd.gif') 
}
.localheader {
COLOR: #dddddd; FONT-FAMILY: geneva, arial, helvetica, lucida-sans, sans-serif; FONT-SIZE: 15px; TEXT-DECORATION: none
}
.locallink {
COLOR: #dddddd; FONT-FAMILY: geneva, arial, helvetica, lucida-sans, sans-serif; FONT-SIZE: 13px; FONT-WEIGHT: normal; TEXT-DECORATION: none
}
.localsublink {
COLOR: #dddddd; FONT-FAMILY: geneva, arial, helvetica, lucida-sans, sans-serif; FONT-SIZE: 11px; FONT-WEIGHT: normal; TEXT-DECORATION: none
}
.tm {
COLOR: #000000; FONT-FAMILY: geneva, arial, helvetica, lucida-sans, sans-serif; FONT-SIZE: 8pt; FONT-STYLE: normal; FONT-VARIANT: normal
}
A:link .nonu {
COLOR: #000000; TEXT-DECORATION: none
}
.nonuw {
COLOR: #ffffff; TEXT-DECORATION: none
}
A:visited .nonu {
TEXT-DECORATION: none
}
.linespace {
LINE-HEIGHT: 120%
}
.just {
TEXT-ALIGN: justify
}
CODE {
COLOR: #666666; FONT-FAMILY: courier, monaco, courier new; FONT-SIZE: 12pt
}
KBD {
COLOR: #666666; FONT-FAMILY: courier, monaco, courier new; FONT-SIZE: 12pt
}
	.error {
		color: #ff0000;
	}
</style>
<!-- <link rel="stylesheet" href="/style.css" type="text/css" media="screen"/>
 -->


</head>

<body>

	<h2 align="center">Registration Form</h2> 
	<form:form id="form1" method="POST" modelAttribute="employee" >
		<table align="center">
		  <tr>
				<td><label for="emp_id">Emp id: </label> </td>
				<td><form:input type="number" path="emp_id" id="emp_id" pattern="\d*"/>${exception}</td>
				<td><form:errors path="emp_id" cssClass="error"/></td>
		    </tr>
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
				<td><form:input type="email" path="email_id" id="email_id"/></td>
				<td><form:errors path="email_id" cssClass="error"/></td>
		    </tr>
		     <tr>
				<td><label for="date_of_join">Date Of Join: </label> </td>
				<td><form:input type="date" path="date_of_join" id="date_of_join"/></td>
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
						</c:when> 
						<c:otherwise>
							<input type="submit" value="Register"/>&emsp;<input type="reset" value="Reset"/>
						</c:otherwise>
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