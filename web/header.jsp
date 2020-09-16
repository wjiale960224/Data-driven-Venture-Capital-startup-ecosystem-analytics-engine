<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/9/16
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <link rel="shortcut icon" href="#" />
    <link rel="stylesheet" href="CSS/header.css" type="text/css">
</head>
<body>
<header>
    <div class = "first">
        <a href="${pageContext.request.contextPath}/mainpage.jsp">
            <img src="${pageContext.request.contextPath}/Pic/MSV_CMYK.jpg" height="50px" width="280px"></a>
    </div>
    <div class = "second"><a href="${pageContext.request.contextPath}/formdeal.jsp">Deal Form</a></div>
    <div class = "third"><a href="${pageContext.request.contextPath}/formcompany.jsp">Company Form</a></div>
</header>

</body>
</html>
