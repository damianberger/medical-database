<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Disease List</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<%@ include file = "../header.jsp" %>
<table class="tableOne">
    <tr>
        <th>Name</th>
        <th>ICD-10</th>
        <th>Subtype</th>
    </tr>
    <c:forEach items="${diseases}" var="disease">
        <tr>
            <td>${disease.name}</td>
            <td>${disease.icd}</td>
            <td>${disease.subtype}</td>
            <sec:authorize access="hasRole('ADMIN')">
                <td>
                    <a href="/disease/edit/${disease.id}">Edit</a>
                    <a href="/disease/delete/${disease.id}/">Remove</a>
                </td>
            </sec:authorize>
        </tr>
        <tr></tr>
    </c:forEach>
    <sec:authorize access="hasRole('ADMIN') or hasRole('DOCTOR')">
    <table>
    <a href="/disease/add/" class="nav-link">Add new</a>
    </table>
    </sec:authorize>
</table>
</body>
</html>