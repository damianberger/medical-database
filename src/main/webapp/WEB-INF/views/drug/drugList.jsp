<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Drug list</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<%@ include file = "../header.jsp" %>
<table class="tableOne">
    <tr>
        <th>Product number</th>
        <th>Name</th>
        <th>Active ingredient</th>
        <th>Side effects</th>
    </tr>
    <c:forEach items="${drugs}" var="drug">
        <tr>
            <td>${drug.productNumber}</td>
            <td>${drug.name}</td>
            <td>${drug.activeIngredient}</td>
            <td>${drug.sideEffects}</td>
            <sec:authorize access="hasRole('ADMIN') or hasRole('DOCTOR')">
                <td>
                    <a href="/drug/edit/${drug.id}">Edit</a>
                    <a href="/drug/delete/${drug.id}/">Remove</a>
                </td>
            </sec:authorize>
        </tr>
        <tr></tr>
    </c:forEach>
    <sec:authorize access="hasRole('ADMIN') or hasRole('DOCTOR')">
    <table>
    <a href="/drug/add/" class="nav-link">Add new</a>
    </table>
    </sec:authorize>
</table>
</body>
</html>