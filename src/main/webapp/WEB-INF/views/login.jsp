<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<%@ include file = "header.jsp" %>


<div class="loginBox">
    <form method="post" action="/login">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password :   <input type="password" name="password"/> </label></div>
        <div><input class="nav-link" type="submit" value="Sign In"/></div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</div>

</body>
</html>
