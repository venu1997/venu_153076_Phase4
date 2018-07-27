<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Customers Details</h2>
<h2>Customers Details</h2>
<table style="background: activeborder;">
<c:forEach items="${list}" var="item">
<tr>
<td><c:out value="${item.mobileNo}" /></td>
<td><c:out value="${item.name}" /></td>
<td><c:out value="${item.wallet.balance}" /></td>
</tr>
</c:forEach>
</table>
</table>
</body>
</html>