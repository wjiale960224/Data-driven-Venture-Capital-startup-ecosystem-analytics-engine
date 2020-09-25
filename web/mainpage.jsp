<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/8/26
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>-->
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <link rel="shortcut icon" href="#" />
    <link rel="stylesheet" href="CSS/mainpage.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class = "mainbox">
    <div class = "column"><jsp:include page="left_guide.jsp"></jsp:include></div>
    <div class = "column">
        <div class = "top_box"></div>
        <div class = "bot_box">
            <div class = "bot_column" id ="double_pie"></div>
            <div class = "bot_column" id="two_pie"></div>
            <div class = "bot_column" id ="mseq_bar"></div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/mainpage.js"></script>
</body>
</html>
