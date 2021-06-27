<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 24.06.2021
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Answer page</title>
</head>
<body>
<table>
    <tr>
        <th>ToCustomer</th>
        <th>QuestionText</th>
        <th>AnswerType</th>
        <th>answer</th>
    </tr>
    <c:forEach var="question" items="${questions}">
        <tr>
            <td>${question.toCustomerEmail}</td>
            <td>${question.question}</td>
            <td>${question.answerType}</td>
            <td>${question.answer}</td>
        </tr>
        <c:url var="toAnswer" value="/customer/toanswer">
            <c:param name="questionIdQ" value="${question.idQ}" />
            <c:param name="customerId" value="${customer.id}" />
        </c:url>
        <a href="${toAnswer}">to answer</a>
    </c:forEach>
</table>
<c:url var="toMain" value="/customer/mainpage">
    <c:param name="customerId" value="${customer.id}" />
</c:url>
<a href="${toMain}">to main</a>
</body>
</html>
