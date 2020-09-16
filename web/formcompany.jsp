<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/form_general.css">
    <link rel="stylesheet" type="text/css" href="CSS/form_company.css">
    <script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JS/company_form.js"></script>
    <title>Create Form</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="mainbox">
    <jsp:include page="left_guide.jsp"></jsp:include>
    <div class="box-table">
        <div class="box-caption">
            <h2>Companies</h2>
            <img src="">
        </div>
        <div class="box-form">
            <table class="form" id="tb_deal"  contenteditable="true">
                <thead>
                <tr  contenteditable="false">
                    <th>No.</th>
                    <th>Company_Name</th>
                    <th>Stage</th>
                    <th>1st Inv Date</th>
                    <th>Initial amount</th>
                    <th>Follow On Date</th>
                    <th>Follow On amount</th>
                    <th>Future</th>
                    <th>Total</th>
                    <th>% of Fund</th>
                    <th>Invested Cumulative</th>
                    <th>Inv & Reserves Cumulative</th>
                    <th>% own</th>
                    <th>Runway end date</th>
                    <th>Current Valuation</th>
                    <th>Company Valuation to return</th>
                    <th>Fund Return</th>
                    <th>Fund Return</th>
                </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>

        <div id="box-add">
            <form id="submit-form" action=/workspace_Intellj_war_exploded/form" method="post">
                <input id="content" name="deals" type="button" value="Submit">
            </form>
            <button id="add_row">Add</button>
        </div>
    </div>
</section>

</body>
</html>


