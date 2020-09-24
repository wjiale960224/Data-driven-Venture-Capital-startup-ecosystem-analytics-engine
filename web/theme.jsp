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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class = "mainbox">
    <div class = "column">
        <nav>
            <ul class="nav">
                <li id = "EM"><span class="tet">Exponential Machines</span>
                </li>
                <li id = "FP"><span class="tet">Feeding 10B People</span>
                </li>
                <li id = "HSH"><span class="tet">Humanity Scale Healthcare</span>
                </li>
                <li id = "NS"><span class="tet">New Society</span>
                </li>
                <li id = "ST"><span class="tet">Space & Transport</span>
                </li>
            </ul>
        </nav>
    </div>
    <div class = "column">
        <div class = "top_box">
            <div class = "top_column">
                <div id="total_company_div">
                    <div class="text_info"><span id="total_company">10</span><br><span>Total company in this theme</span></div>
                    <div id = "total_company_pie"></div>
                </div>
                <div id="total_amount_div">
                    <div class="text_info"><span id="total_amount">23 M</span><br><span>Total Inv amount in this theme</span></div>
                    <div id = "total_inv_pie"></div>
                </div>
            </div>
            <div class = "top_column" id = "valuation">
            </div>
        </div>
        <div class = "bot_box">
            <div class = "bot_column" id ="MSEQ_investment"></div>
            <div class = "bot_column" id="div_table">
                <table class="table">
                    <thead>
                    <th>Company</th>
                    <th>Investment Date</th>
                    <th>Cost<br>(AUD M\)</th>
                    <th>% Owned</th>
                    <th>Current Valuation<br>(AUD M\)</th>
                    <th>Investment Multiple</th>
                    <th>IRR</th>
                    </thead>
                    <tr style="background-color: rgb(173,139,46);">
                        <td id="theme_table_cell" colspan="7">Exponential Machines</td>
                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>
                    <tr>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>
                        <td>.</td>

                    </tr>


                </table>
            </div>
            <div class = "bot_column" id = "bar_chart"></div>
        </div>
    </div>
</section>
<script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
<script src="${pageContext.request.contextPath}/JS/echarts-en.js"></script>
<script src="${pageContext.request.contextPath}/JS/theme.js"></script>

</body>
</html>
