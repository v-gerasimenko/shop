<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Incorrect</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/wrong.css">
<head>

</head>
<body>
<div class="main"><h2>Login or password are incorrect. Please, try again!</h2>

    <form action="${pageContext.request.contextPath}/jsp/login.jsp">
        <div class="btn"><input type="submit" value="Try again" class="button"></div>

    </form>
</div>
</body>
</html>
