<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 24.06.2021
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>AccountDeletePage</title>
</head>
<body>
<form:form action="processDelete" modelAttribute="customer" method="POST">
    <form:hidden path="id" />
    <br><br>
    Password: <form:password placeholder="password" path="password" />
    <br/><br/>
    <input type="submit" value="Submit" />
</form:form>
<c:url var="toMain" value="/customer/mainpage">
    <c:param name="customerId" value="${customer.id}" />
</c:url>
<a href="${toMain}">to main</a>
</body>
</html>
