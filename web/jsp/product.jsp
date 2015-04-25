<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Product</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/product.css">
<body>

<b>PRODUCT PAGE</b>
<br>
<br><b>Product title: </b>${product.name}
<br><b>Product type: </b>${product.type}
<br><b>Product price: $</b>${product.price}
<br>
<br>
<a href="./productAdd.do?id=${product.id}">
    <button class="btn">Add this product to bucket</button>
</a>

<a href="${pageContext.request.contextPath}/productAll">
    <button class="btn2">To all products</button>
</a>
<a href="${pageContext.request.contextPath}/jsp/menuUser.jsp">
    <button class="btn2">To main menu</button>
</a>
</br>

<hr>
<h2>Products in bucket</h2>

<c:forEach var="productInBucket" items="${productsInBucket}">
    <li>
        <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>:
        = ${productInBucket.value}
    </li>
</c:forEach>

<hr>
<h2>Total price</h2>
$${total}
</body>

</html>
