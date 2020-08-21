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
    <title>Login</title>
</head>
<body>
<div style = "text-align: center">
    <form action = "/workspace_Intellj_war_exploded/login" method = "post" id = "loginForm">
        Account:  <input type = "text" name = "uname" value = "${messageModel.object.user_name}"> <br>
        Password: <input type = "password" name = "upwd" value = "${messageModel.object.user_pwd}"><br>
        <span id = "msg" style = "font-size: 12px ; color: red">${messageModel.msg}<br></span>
        <input type = "submit" value = login>

    </form>

</div>

</body>
</html>
