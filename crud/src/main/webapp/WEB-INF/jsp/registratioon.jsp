<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta charset="ISO-8859-1">
<title>- Employee Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">  
<style>  
form div {  
  margin-bottom: 10px;  
}  
.error {  
  color: red;  
  margin-left: 5px;  
}  
h2 {  
  font-weight: bold;  
  margin-bottom: 2.5rem;  
  color: #fff;  
  align: center;  
  font-size: 30px;  
  margin-top: 2.5rem;  
}  
[type="submit"] {  
    display: inline-block;  
    padding: 0.35em 1.2em;  
    border: 0.1em solid #3494e6;  
    margin: 0 0.3em 0.3em 0;  
    border-radius: 0.12em;  
    box-sizing: border-box;  
    text-decoration: none;  
    font-family: 'Roboto',sans-serif;  
    font-size: 1rem;  
    text-align: center;  
    transition: all 0.2s;  
    }  
    [type="submit"]:hover {  
    color: #FFFFFF;  
    background-color: #3494e6;  
}  
label.error {  
  display: inline;  
}  
body {  
align: center;  
  font-family: "Poiret One", cursive;  
  background: #3494e6; /* fallback for old browsers */  
  background: -webkit-linear-gradient(  
    to right,  
    #ec6ead,  
    #3494e6  
  ); /* Chrome 10-25, Safari 5.1-6 */  
  background: linear-gradient(  
    to right,  
    #ec6ead,  
    #3494e6  
  ); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */  
}  
  
</style>  
<link href="https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">  
      <script src="https://code.jquery.com/jquery-1.10.2.js"></script>  
      <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script> 
<script>
	$(function() {

		$("#dateOfBirth").datepicker({
			dateFormat : "dd-MM-yy "
		});
	});
</script>

</head>


<body style="background-color: #FFFFE0;">
	<div style="margin-top: 50px; margin-left: 250px; height: 50px;">
		<h2>
			Employee
			<c:out value="${employee.id != null ? 'Update' : 'Registration' }" />
			
			
		</h2>
	</div>
	<form:form method="POST" modelAttribute="employee" action="/home"
		name="employee">
		<table style="vertical-align: center; margin-left: 20%;">

			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstName" id="fname" required="required" /></td>
			
				 <%-- Show errors for firstName field --%>
                <td>
                    <form:errors path="firstName" />
                </td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastName" id="lname" required="required" /></td>
				  <%-- Show errors for lastName field --%>
                <td>
                    <form:errors path="lastName" />
                </td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><form:input path="dateOfBirth" id="dateOfBirth" required="required" /></td>
					  <%-- Show errors for dateOfBirth field --%>
                <td>
                    <form:errors path="dateOfBirth" />
                </td>
			</tr>
			<tr>
				<td>Mobile Number:</td>
				<td><form:input path="mobile" id="mobile" reuired="required" /></td>
			<%-- Show errors for mobile field --%>
                <td>
                    <form:errors path="mobile" />
                </td>
			</tr>
			<tr>
				<td>Address1:</td>
				<td><form:input path="address1" id="address1" required="required" /></td>
				<%-- Show errors for address1 field --%>
                <td>
                    <form:errors path="address1" />
                </td>
			</tr>
			<tr>
				<td>Address2:</td>
				<td><form:input path="address2" id="address2" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" id="age" required="required" /></td>
				<%-- Show errors for age field --%>
                <td>
                    <form:errors path="age" />
                </td>
			</tr>
			<tr>
    <td>Gender:</td>
    <td>
        MALE:
        <form:radiobutton path="gender" value="MALE" />  FEMALE:
        <form:radiobutton path="gender" value="FEMALE" />
    </td>
    
</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" id="email" required="required" /></td>
				<%-- Show errors for email field --%>
                <td>
                    <form:errors path="email" />
                </td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<c:out value="${employee.id != null ? 'Update' : 'Register' }" />"
					onclick="return validate();">&nbsp;&nbsp; <c:if test="${employee.id ne null}">
						
					</c:if></td>
			</tr>
		</table>
	</form:form>

</body>
</html>