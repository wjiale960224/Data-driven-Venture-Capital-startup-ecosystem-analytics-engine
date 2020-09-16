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
    <link rel="stylesheet" href="CSS/head_style.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class = "mainbox">
    <jsp:include page="left_guide.jsp"></jsp:include>
    <div class = "column">
        <div class = "panel_first">
            <div class = "company">
                <span>Total Company:</span>&nbsp 31
            </div>
            <div class = "deals"><span>Total Deals:</span>&nbsp 6</div>
            <div class = "invested"><span>Invested:</span>&nbsp 2.5M</div>
            <div class = "l"><span>Left:</span>&nbsp 1.2M</div>
        </div>
        <div class = "panel_second">
        </div>
    </div>
    <div class="column">
        <div class = "panel_third">
        </div>
        <section class = "sub_box">
            <div class = "column_2">
                <div class="panel_pie1">
                </div>
            </div>
            <div class = "column_2">
                <div class="panel_pie2"></div>
            </div>
        </section>
    </div>

</section>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/index.js"></script>
</body>
</html>
