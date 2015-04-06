<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<title>Register</title>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
<body>
<div class="frm">
    <form name="registerform" method="post" action="${pageContext.request.contextPath}/register">
        Username: <input type="text" name="username"/> <br/>
        Password: <input type="text" name="password"/> <br/>
        <div class="btn"><input type="submit" value="Register" class="button"/></div>
    </form>

</div>
</body>
</html>