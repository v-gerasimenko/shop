<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Main menu</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">

<ul class="nav">

    <li class="main-menu">
        <a href="${pageContext.request.contextPath}/jsp/productEnter.jsp">Enter new product</a>
    </li>

    <li class="main-menu">
        <a href="${pageContext.request.contextPath}/jsp/supplierEnter.jsp">Enter new supplier</a></li>

</ul>

<form name="logout" method="get" action="${pageContext.request.contextPath}/logout">
    <div class="btn"><input type="submit" value="Log Out" class="button"/></div>
</form>

