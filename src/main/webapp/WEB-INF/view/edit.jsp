<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 23.06.2021
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Save Customer</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>QuestionPortal</h2>
    </div>
</div>
<div id="container">
    <h3>Save Customer</h3>
    <form:form action="main" modelAttribute="customer" method="POST">
        <form:hidden path="id" />

        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName" /></td>
            </tr>

            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName" /></td>
            </tr>

            <tr>
                <td><label>Email:</label></td>
                <td><form:input path="email" /></td>
            </tr>

            <tr>
                <td><label>Phonenumber:</label></td>
                <td><form:input path="phonenumber" /></td>
            </tr>

            <tr>
                <td><label>Password:</label></td>
                <td><form:input path="password" /></td>
            </tr>

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
</div>
</body>
</html>
