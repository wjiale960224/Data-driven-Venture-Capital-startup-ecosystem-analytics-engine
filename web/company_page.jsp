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
                <li>Exponential Machines
                    <span class="dropdown"></span>
                    <ul class="sub">
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                    </ul>
                </li>
                <li>Feeding 10B People
                    <ul class="sub">
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                    </ul>
                </li>
                <li>Humanity Scale Healthcare
                    <ul class="sub">
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                    </ul>
                </li>
                <li>New Society
                    <ul class="sub">
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                    </ul>
                </li>
                <li>Space & Transport
                    <ul class="sub">
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                        <li>Company1</li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <div class = "column">
        <div class = "panel_first">
            <div class = "row1">
            <div class = "company">Company_theme</div>
            <div class = "C_value"><span>Current_Valuation: </span>4M</div>
            <div class = "RED"><span>R-E-D: </span>25/2/2021</div>
            <div class = "own"><span>Own: </span>20%</div>
            <div class = "R2"><span>R2Date: </span>35.29</div>
            </div>
            <div class = "row2">
                <div class = "MSEQ"><span>MSEQ inves: </span>8.2</div>
                <div class = "Stage"><span>Stage: </span>Growth</div>
                <div class = "Acq"><span>Acq: </span>34.7%</div>
                <div class = "Return"><span>Return: </span>1250</div>
            </div>
        </div>
            <section class="sub_box">
                    <div class="column_2">
                        <div class = "change"></div>
                    </div>
                    <div class = "column_2">
                        <div class = "bar"></div>
                    </div>
                    <div class = "column_2">
                        <div class = "line"></div>
                    </div>
                </section>
        </div>
    </div>

</section>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/JS/index_company.js"></script>
<script src="${pageContext.request.contextPath}/JS/dropdown.js"></script>

</body>
</html>
