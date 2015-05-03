<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/productEnter.css">
    <title>Add product</title>
</head>
<body>
<c:url var="saveUrl" value= "/product/add" />
<form:form modelAttribute="product" method="POST" action="${saveUrl}">
    <table>
        <tr>
            <td><form:label path="name">Title:</form:label></td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td><form:label path="quantity">Quantity</form:label></td>
            <td><form:input path="quantity"/></td>
        </tr>

        <tr>
            <td><form:label path="barcode">Barcode:</form:label></td>
            <td><form:input path="barcode"/></td>
        </tr>

        <tr>
            <td><form:label path="type">Type</form:label></td>
            <td><form:input path="type"/></td>
        </tr>

        <tr>
            <td><form:label path="price">Price:</form:label></td>
            <td><form:input path="price"/></td>
        </tr>

    </table>

   <input type="submit" value="Submit"/>
</form:form>

</body>
</html>