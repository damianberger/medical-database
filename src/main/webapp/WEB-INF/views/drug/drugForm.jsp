<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new drug</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
</head>
<body>
<%@ include file = "../header.jsp" %>
<form:form class="nav-link" method="post" modelAttribute="drug" action="/drug/add">
    <form:hidden path="id"/>
    <div>
        <label>
            <form:input class="nav-link2" path="productNumber" placeholder="Product number" type="number"/>
        </label>
    </div>
    <div>
        <label>
             <form:input class="nav-link2" path="name" placeholder="Name"/>
        </label>
    </div>
    <div>
        <label>
             <form:input class="nav-link2" path="activeIngredient" placeholder="Active ingredient"/>
        </label>
    </div>
    <div>
        <label>
            <form:input class="nav-link2" path="sideEffects" placeholder="Side effects"/>
        </label>
    </div>
    <input class="nav-link2" type="submit" value="Add">
</form:form>
</body>
</html>
