<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 27.06.2021
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>answer</title>
</head>
<body>
<form:form action="saveAnswer" modelAttribute="question" method="POST">
    <form:hidden path="idQ" />
    <form:input path="toCustomerEmail" />
    <form:input path="question" />
    <form:hidden path="answerType" value="${question.answerType}"/>
    <form:hidden path="idCustomer" value="${question.idCustomer}"/>
    <form:input path="answer" />
    <input type="submit" value="Add Answer" class="save" />
</form:form>
</body>
</html>
