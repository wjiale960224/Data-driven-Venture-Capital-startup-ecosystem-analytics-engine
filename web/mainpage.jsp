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
        <div class = "top_box">
            <div class="top_column" id="overview_info">
                <ul >
                    <li><span>Total Fund Size</span><span id = "total_fund_size"></span>
                        <div id = "pie"></div>
                    </li>
                    <li><span>Drawn Capital</span><span id = "drawn_capital"></span></li>
                    <li><span>Undrawn Capital</span><span id = "undrawn_capital"></span></li>
                    <li><span>Management Fee</span><span id = "management_fee"></span></li>
                    <li><span>Total companies</span><span id = "No_company"></span></li>
                    <li><span>Total Deals</span><span id = "No_deals"></span></li>
                    <li><span>Per Deal</span><span id = "per_deal"></span></li>
                    <li><span>Remaining to Invest</span><span id = "remaining_to_invest"></span></li>
                    <li><span>Total Capital Raised</span><span id = "total_capital_raised"></span></li>
                </ul>
            </div>
            <div class="top_column" id="TVPI_curve"></div>
        </div>
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
