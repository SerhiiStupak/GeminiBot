<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n.login" />
    <title><fmt:message key="title_message" /></title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
       <form >
            <select id="language" name="language" onchange="submit()">
                <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="uk_UA" ${language == 'uk_UA' ? 'selected' : ''}>Ukrainian</option>
            </select>
        </form>

<h2><fmt:message key="login_massage" /></h2>

<form action="login" method="POST">
    <label for="loginEmail"><fmt:message key="email_massage" /></label>
    <input name="email" type="email" class="form-control" id="loginEmail" placeholder="Enter Email">
    <label for="loginPassword"><fmt:message key="password_massage" /></label>
    <input name="password" type="password" class="form-control" id="loginPassword" placeholder="Password">

    <input type="submit" value="Login">

</form>
</body>
</html>
