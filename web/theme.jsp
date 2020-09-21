<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/9/21
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <link rel="shortcut icon" href="#" />
    <link rel="stylesheet" href="CSS/theme.css" type="text/css">
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class = "mainbox">
    <div class = "column">
        <nav>
            <ul class="nav">
                <li id = "EM"><span class="tet">Exponential Machines</span>
                </li>
                <li><span class="tet">Feeding 10B People</span>
                </li>
                <li><span class="tet">Humanity Scale Healthcare</span>
                </li>
                <li><span class="tet">New Society</span>
                </li>
                <li><span class="tet">Space & Transport</span>
                </li>
            </ul>
        </nav>
    </div>
    <div class = "column">
        <div class = "top_box">
            <div class = "top_column">
            </div>
            <div class = "top_column" id = "valuation">
            </div>
        </div>
        <div class = "bot_box">
            <div class = "bot_column" id = "MSEQ_investment"></div>
            <div class = "bot_column" ></div>
            <div class = "bot_column" id = "bar_chart"></div>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/theme.js"></script>

</body>
</html>
