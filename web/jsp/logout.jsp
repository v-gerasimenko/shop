<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Goodbye</title>
<meta charset="utf-8"
      http-equiv="Refresh" content="1;url=${pageContext.request.contextPath}/jsp/startPage.jsp">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/logout.css">
<body>
<div class="main">
    <h3> Goodbye, ${name}! </h3>
</div>
</body>
</html>