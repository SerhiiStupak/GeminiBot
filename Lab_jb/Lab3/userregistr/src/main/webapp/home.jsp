<!DOCTYPE html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tag/hello.tld" prefix="custom" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Main Page</title>
</head>
<body>
<h2>Hello <c:out value="${user.name}" default="user"/>!</h2>

<custom:hello name="${user.name}" />

<!-- Using scriptlet:-->
<p>Today: <%= java.util.Calendar.getInstance().getTime() %>   </p>
<h3> Go to Registration </h3>
<form action="register" method="GET">
    <input type="submit" value="Go to Registration Page" >
</form>

<h3> Go to Login </h3>
<form action="login" method="GET">
    <input type="submit" value="Go to Login Page" >
</form>
</body>
</html>
