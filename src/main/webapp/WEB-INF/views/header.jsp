<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<header class="header">
    <sec:authorize access="isAnonymous()">
        <nav class="navbar">
            <a class="navbar-brand">Welcome guest</a>
            <ul class="nav nounderline text-uppercase">
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/patientRegistration">Register new patient</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/doctorRegistration">Register new doctor</a>
                </li>
            </ul>
        </nav>
    </sec:authorize>

    <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_DOCTOR')">
        <nav class="navbar">
            <a class="navbar-brand"><b> Welcome </b> <c:out value="${principal.email}"/></a>
            <ul class="nav nounderline text-uppercase">
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/disease/list">Diseases</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/drug/list">Drugs</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/treatment/list">Treatments</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/prescription/list">Prescriptions</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/">Contact Patient :: TO DO</a>
                </li>
                <li class="nav-item ml-4">
                    <form action="<c:url value="/logout"/>" method="post">
                        <input type="submit" value="Wyloguj" class="nav-link right-side">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </ul>
        </nav>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_PATIENT')">
        <nav class="navbar">
            <a class="navbar-brand"><b> Welcome </b> <c:out value="${principal.email}"/></a>
            <ul class="nav nounderline text-uppercase">
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/profile">Patient profile</a>
                </li>
                <li class="nav-item ml-4">
                    <a class="nav-link" href="/">Contact Doctor :: TO DO</a>
                </li>
                <li class="nav-item ml-4">
                    <form action="<c:url value="/logout"/>" method="post">
                        <input type="submit" value="Wyloguj" class="nav-link right-side">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </ul>
        </nav>
    </sec:authorize>
</header>

