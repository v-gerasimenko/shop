<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Incorrect</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/general.css">
<body>
<div class="main"><h2>Something is incorrect! Try again </h2>

    <form action="${pageContext.request.contextPath}/product/add">
        <div class="btn"><input type="submit" value="Try again" class="button"></div>
    </form>
</div>
</body>
</html>