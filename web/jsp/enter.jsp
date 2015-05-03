<html>
<head>
    <title>get and set properties Example</title>
</head>
<body>

<jsp:useBean id="Product"
             class="shop.entity.Product">
    <jsp:setProperty name="students" property="firstName"
                     value="Zara"/>
    <jsp:setProperty name="students" property="lastName"
                     value="Ali"/>
    <jsp:setProperty name="students" property="age"
                     value="10"/>
</jsp:useBean>
