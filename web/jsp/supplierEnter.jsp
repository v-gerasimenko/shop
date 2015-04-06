<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Enter good</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/productEnter.css">
<body>

<div class="frm">
    <form method="post" action="${pageContext.request.contextPath}/addSupplier">
        
        Supplier name: <input type="text" name="name"/> <br/>
        Product type: <input type="text" name="type"/> <br/>

        <div class="btn"><input type="submit" value="Submit" class="button"/></div>
    </form>

</div>
</body>
</html>
