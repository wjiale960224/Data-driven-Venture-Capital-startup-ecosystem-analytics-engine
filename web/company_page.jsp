<%--
  Created by IntelliJ IDEA.
  User: Jiale
  Date: 2020/9/1
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="kiben" content="no-cache">
    <link rel="shortcut icon" href="#" />
    <link rel="stylesheet" href="CSS/company.css" type="text/css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class = "mainbox">
    <div class = "column">
        <nav>
            <ul class="nav">
                <li class="theme"><span class="tet">Exponential Machines</span>
                    <span class="dropdown"></span>
                    <ul class="sub EMclass">

                    </ul>
                </li>
                <li class="theme"><span class="tet">Feeding 10B People</span>
                    <ul class="sub FPclass">

                    </ul>
                </li>
                <li class="theme"><span class="tet">Humanity Scale Healthcare</span>
                    <ul class="sub HSHclass">

                    </ul>
                </li>
                <li class="theme"><span class="tet">New Society</span>
                    <ul class="sub NSclass">

                    </ul>
                </li>
                <li class="theme"><span class="tet">Space & Transport</span>
                    <ul class="sub STclass">

                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <div class = "column">
        <div class = "top_box">
            <div class="top_column" id="company_info">
                <ul >
                    <li><span>Company Name</span><span id = "company_name">Alibaba</span></li>
                    <li><span>Company Theme</span><span>New Society</span></li>
                    <li><span>Total MSEQ Investment</span><span>A$10M</span></li>
                    <li><span>Total deals</span><span>3</span></li>
                    <li><span>Current Valuation(last update date: 21/09)</span><span>A$20M</span></li>
                    <li><span>Runaway Month</span><span>11</span></li>
                    <li><span>Stage</span><span>Growth</span></li>
                </ul>
            </div>
            <div class="top_column" id = "TBD">
                <ul >
                    <li><span>Round</span><span>Series A</span></li>
                    <li><span>Return</span><span>10M</span></li>
                    <li><span>Own</span><span>20%</span></li>
                    <li><span>Employee.No</span><span>231</span></li>
                    <li><span>Revenue</span><span>4M</span></li>
                </ul>
            </div>
        </div>
        <div class = "bot_box">
            <div class = "bot_column" id ="bar_chart"></div>
            <div class = "bot_column" id="line_chart"></div>
            <div class= "bot_column"  id="pie_chart"></div>
        </div>
    </div>

</section>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/JS/companypage.js"></script>
<script src="${pageContext.request.contextPath}/JS/dropdown.js"></script>

</body>
</html>
