<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<title>Products</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/allProducts.css">
<h3>All products</h3>

<body>
<div class="tbl">
    <table width="59%" border="1">
        <th>Name</th>
        <th>Quantity</th>
        <th>Barcode</th>
        <th>Type</th>
        <th>Price</th>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><a href="./product.do?id=${product.id}">
                        ${product.name}</a></td>
                <td>${product.quantity}</td>
                <td>${product.barcode}</td>
                <td>${product.type}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</HTML>