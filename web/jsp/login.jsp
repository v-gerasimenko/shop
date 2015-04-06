<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Log in</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<body>
<div class="frm">
    <form name="loginForm" method="post" action="${pageContext.request.contextPath}/login">
        Username: <input type="text" name="username"/> <br/>
        Password: <input type="password" name="password"/> <br/>

        <div class="btn"><input type="submit" value="Log in" class="button"/></div>
    </form>

</div>
</body>
</html>
