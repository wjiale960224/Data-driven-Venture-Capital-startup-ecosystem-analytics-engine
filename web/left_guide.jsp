<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/9/16
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <link rel="shortcut icon" href="#" />
    <link rel="stylesheet" href="CSS/left.css" type="text/css">
</head>
<body>
<div class = "left">
    <nav>
        <ul class = "nav">
            <li id = "Overview">Overview</li>
            <li><a href="${pageContext.request.contextPath}/company_page.jsp">Company</a></li>
            <li><span class="tet">Theme</span>
                <ul class="sub">
                    <li id = "EM">Exponential Machines</li>
                    <li id = "FP">Feeding 10B People</li>
                    <li id = "HCH">Humanity Scale Healthcare</li>
                    <li id = "NS">New Society</li>
                    <li id = "ST">Space & Transport</li>
                </ul>
            </li>
            <li><a href="">last 5 deals</a></li>
        </ul>
    </nav>
</div>
<script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/JS/dropdown.js"></script>
</body>
</html>
