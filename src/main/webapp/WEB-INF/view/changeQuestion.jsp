<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 25.06.2021
  Time: 1:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>for add editing questions</title>
</head>
<body>
<h3>Add Question</h3>

<form:form action="saveQuestion" modelAttribute="question" method="POST">
    <form:hidden path="idQ" />
    <table>
        <tbody>
        <tr>
            <td><label>To WHo:</label></td>
            <td><form:input path="toCustomerEmail" /></td>
        </tr>

        <tr>
            <td><label>Question:</label></td>
            <td><form:input path="question" /></td>
        </tr>

        <tr>
            <td><label>AnswerType:</label></td>
            <td><form:input path="answerType" /></td>
        </tr>
        <form:hidden path="idCustomer" value="${customer.id}"/>
        <form:hidden path="answer" value="${question.answer = null}"/>
        <tr>
            <td><input type="submit" value="Save" class="save" /></td>
        </tr>
        </tbody>
    </table>
</form:form>
<div style="clear: both;"></div>
<c:url var="toMain" value="/customer/mainpage">
    <c:param name="customerId" value="${customer.id}" />
</c:url>
<a href="${toMain}">to main</a>
</body>
</html>
