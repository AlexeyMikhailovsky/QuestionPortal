<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Question</title>
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
                    <a class="nav-link" href="${answerLink}">Answer the question</a>
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
                            <a class="dropdown-item" href="${updateLink}">Edit Profile</a></li>
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


<div class="text-center mt-5" style="max-width:300px; margin: auto">
    <form:form action="saveQuestion" modelAttribute="thequestion" method="POST">

        <!-- need to associate this data with customer id -->
        <form:hidden path="idQ" />

        <table>
            <tbody>
            <tr>
                <td><label>For User:</label></td>
                <td><form:input path="toCustomerEmail" class="form-control" placeholder="Email" type="email"/></td>
            </tr>

            <tr>
                <td><label>Question:</label></td>
                <td><form:input path="question" class="form-control" placeholder="Text"/></td>
            </tr>

            <tr>
                <td><label>Answer type:</label></td>
                <td><form:input path="answerType" class="form-control" placeholder="Answer type"/></td>
            </tr>

            <form:hidden path="idCustomer" value="${customer.id}"/>
            <form:hidden path="answer" value="${thequestion.answer = null}"/>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save" /></td>
            </tr>


            </tbody>
        </table>


    </form:form>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>


