<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 23.06.2021
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form:form action="processForm" modelAttribute="customer">
    Login: <form:input placeholder="login"  path="email" />
    <br><br>
    Password: <form:password placeholder="password" path="password" />
    <br/><br/>
    <input type="submit" value="Submit" />
</form:form>
<p>
    <a href="showFormForAdd">Registration</a>
</p>
</body>
</html>
