<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 23.06.2021
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<table>
    <tr>
        <th>ToCustomer</th>
        <th>QuestionText</th>
        <th>AnswerType</th>
        <th>CustomerId</th>
        <th>answer</th>
    </tr>
    <c:forEach var="tempQuestion" items="${questions}">
            <tr>
                <td>${tempQuestion.toCustomerEmail}</td>
                <td>${tempQuestion.question}</td>
                <td>${tempQuestion.answerType}</td>
                <td>${tempQuestion.idCustomer}</td>
                <td>${tempQuestion.answer}</td>
            </tr>

        <c:url var="deleteQ" value="/customer/questionDelete">
            <c:param name="questionId" value="${tempQuestion.idQ}" />
            <c:param name="customerId" value="${customer.id}" />
        </c:url>

        <a href="${deleteQ}"
           onclick="if (!(confirm('Are you sure you want to delete this question?'))) return false">Delete question</a>

    </c:forEach>
</table>

<c:set var="tempCustomer" value="${customer}"/>

<input type="button" value="Add Question"
       onclick="window.location.href='showQuestionForm'; return false;"
       class="add-button" />



IddfdfdffD:${customer.id}
IddfdfdffD:${customer.password}
IddfdfdffD:${customer.email}
<p>


    <c:url var="updateLink" value="/customer/edit">
        <c:param name="customerId" value="${tempCustomer.id}" />
    </c:url>
    <a href="${updateLink}">Update</a>
</p>

<p>
    <c:url var="deleteLink" value="/customer/delete">
        <c:param name="customerId" value="${tempCustomer.id}" />
    </c:url>
    <a href="${deleteLink}">Delete</a>
</p>

<p>
    <c:url var="answerLink" value="/customer/answerpage">
        <c:param name="customerId" value="${tempCustomer.id}" />
    </c:url>
    <a href="${answerLink}">Answer</a>
</p>
</body>
</html>
