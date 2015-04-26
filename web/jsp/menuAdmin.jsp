<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Protected page</title>
</head>
<body>
<ul class="nav">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>Welcome : ${pageContext.request.userPrincipal.name}
            | <a href="<c:url value="/logout"/>" > Logout</a></h2>
    </c:if>

    <li class="main-menu">
        <a href="${pageContext.request.contextPath}/add">Enter new product</a>
    </li>

</ul>
</body>

</html>

<%--<form name="logout" method="get" action="${pageContext.request.contextPath}/logout">--%>
    <%--<div class="btn"><input type="submit" value="Log Out" class="button"/></div>--%>
<%--</form>--%>

