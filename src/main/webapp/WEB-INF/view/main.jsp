<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 23.06.2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>QuestionPortal</h2>
    </div>
</div>
<p>
    <a href="list">list</a>
</p>
<p>
    <c:set var="tempCustomer" value="${customer}"/>
    <c:url var="updateLink" value="/customer/edit">
        <c:param name="customerId" value="${tempCustomer.id}" />
    </c:url>
    <a href="${updateLink}">Update</a>
</p>
</body>
</html>
