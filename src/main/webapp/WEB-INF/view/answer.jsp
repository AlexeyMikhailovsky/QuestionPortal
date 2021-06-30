<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Answer</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <c:url var="toMain" value="/customer/main">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>
                    <a class="nav-link " href="${toMain}">Your Question's</a>
                </li>
                <li class="nav-item">
                    <c:url var="answerLink" value="/customer/answerpage">
                        <c:param name="customerId" value="${customer.id}" />
                    </c:url>
                    <a class="nav-link disabled" href="${answerLink}">Answer the question</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle " id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${customer.email}
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li>
                            <c:url var="updateLink" value="/customer/edit">
                                <c:param name="customerId" value="${customer.id}" />
                            </c:url>
                            <a class="dropdown-item " href="${updateLink}">Edit Profile</a></li>
                        <li>
                            <c:url var="deleteLink" value="/customer/delete">
                                <c:param name="customerId" value="${customer.id}" />
                            </c:url>
                            <a class="dropdown-item" href="${deleteLink}">Delete Profile</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="login">Log Out</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

<table class="table table-bordered text-center" style="max-width: 800px">
    <thead class="table-light">
    Answer the question
    <tr>
        <th>From user</th>
        <th>Question</th>
        <th>Answer</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="question" items="${questions}">
        <tr>
            <td>${question.toCustomerEmail}</td>
            <td>${question.question}</td>
            <td>${question.answer}</td>
            <td>
        <c:url var="toAnswer" value="/customer/toanswer">
            <c:param name="questionIdQ" value="${question.idQ}" />
            <c:param name="customerId" value="${customer.id}" />
        </c:url>
                <a href="${toAnswer}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                </svg></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
