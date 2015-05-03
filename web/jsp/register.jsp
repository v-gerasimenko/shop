<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <title>Hello</title>
</head>
<body>

<h1>Create New User</h1>
<c:url var="saveUrl" value= "/register" />
<form:form modelAttribute="user" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="login">Login:</form:label></td>
            <td><form:input path="login"/></td>
        </tr>

        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>

    </table>

    <input type="submit" value="Register" />
</form:form>

</body>
</html>