<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new disease</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<%@ include file = "../header.jsp" %>
<form:form class="nav-link" method="post" modelAttribute="disease" action="/disease/add/">
    <form:hidden path="id"/>
    <div>
        <label class="labelMed">
            <form:input class="nav-link2" path="name" placeholder="Name"/>
        </label>
    </div>
    <div>
        <label class="labelMed">
            <form:input class="nav-link2" path="icd" placeholder="ICD-10"/>
        </label>
    </div>
    <div>
        <label class="labelMed">
             <form:input class="nav-link2" path="subtype" placeholder="Subtype"/>
        </label>
    </div>
    <input class="nav-link2" type="submit" value="Add">
</form:form>
</body>
</html>
