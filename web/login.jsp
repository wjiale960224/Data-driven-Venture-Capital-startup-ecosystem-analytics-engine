<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/8/21
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="CSS/stylesheet_login.css" type="text/css">
    <title>Login</title>
</head>
<body>
<header>
    <div class = "first">
        <a href="${pageContext.request.contextPath}/mainpage.jsp">
            <img src="${pageContext.request.contextPath}/Pic/MSV_CMYK.jpg" height="50px" width="280px"></a>
    </div>
</header>
<div class = "login_style">
    <form action = "/workspace_Intellj_war_exploded/login" method = "post" id = "loginForm">
        <p><label class="label_input">Account</label> <br>  <input class="text_field" type = "text" name = "user_name" value = "${messageModel.object.user_name}"> <br>
        <p><label class="label_input">Password</label> <br> <input class="text_field" type = "password" name = "user_pwd" value = "${messageModel.object.user_pwd}"><br>
        <span id = "msg" style = "font-size: 12px ; color: red">${messageModel.msg}<br></span>
        <input type = "submit" value = login>

    </form>

</div>

</body>
</html>
