
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registration</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Enroll Account Details Here</h2></div>
		<table>
			<form:form action="registerCustomer" method="post"
				modelAttribute="customer">
				
				<tr>
					<td>Name:</td>
					<td><form:input path="name" size="30" /></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Mobile Number:</td>
					<td><form:input path="mobileNo" size="10" />
					<form:errors path="mobileNo" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Balance:</td>
					<td><form:input path="wallet.balance" size="30" />
					<form:errors path="wallet.balance" cssClass="error" /></td>
				</tr>

<tr> <td> <input type="submit" name="submit" value="submit" /></td></tr>
			</form:form>
		</table>
	
</body>
</html>