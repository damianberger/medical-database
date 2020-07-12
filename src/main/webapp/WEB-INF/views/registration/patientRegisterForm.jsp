<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new patient</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<%@ include file = "../header.jsp" %>
<form:form class="nav-link" method="post" modelAttribute="user" action="/registerNewPatient">
    <form:hidden path="id"/>
    <div>
        <label>
            <form:input class="nav-link2" path="firstName" placeholder="First Name"/>
        </label><form:errors path="firstName"/>
    </div>
    <div>
        <label>
            <form:input class="nav-link2" path="lastName" placeholder="Last Name"/>
        </label><form:errors path="lastName"/>
    </div>
    <div>
        <label>
            <form:input class="nav-link2" path="password" placeholder="Password" type="password"/>
        </label><form:errors path="password"/>
    </div>
    <div>
        <label>
            <form:input class="nav-link2" path="email" placeholder="Email"/>
        </label><form:errors path="email"/>
    </div>
    <input class="nav-link2" type="submit" value="Register">
</form:form>
</body>
</html>
