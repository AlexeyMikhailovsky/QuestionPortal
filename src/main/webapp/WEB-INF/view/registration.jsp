<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Registration</title>
</head>
<body>
<div class="text-center mt-5" style="max-width:300px; margin: auto">
<form:form action="saveCustomer" modelAttribute="customer" method="POST">
    <fieldset>
        <h1 class="h3 mb-3 font-weight-normal">Sign Up</h1>
    <form:hidden path="id" />

        <div class="form-group">
            <div class="col-lg-10">
                <td><form:input path="firstName" class="form-control" placeholder="First Name"/></td>
            </div>
        </div>

            <div class="form-group">
                <div class="col-lg-10">
                    <td><form:input path="lastName" class="form-control" placeholder="Last Name"/></td>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10">
                    <td><form:input path="email" class="form-control" placeholder="Email" type="email"/></td>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10">
                    <td><form:input path="phonenumber" class="form-control" placeholder="Phone number"/></td>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-10">
                    <td><form:input path="password" class="form-control" placeholder="Password"/></td>
                </div>
            </div>



            <div class="mt-3">
                <button class="btn btn-primary" type="submit" id="register">SIGN UP</button>
            </div>


    </fieldset>
</form:form>

    <div class="mt-3">
        Already have account?
        <a href="login">Log In</a>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>