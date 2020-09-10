<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/form_general.css">
    <link rel="stylesheet" type="text/css" href="CSS/form_deal.css">
    <script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JS/deal_form.js"></script>
    <title>Create Form</title>
</head>

<body>
<header class="hea">
    <div class="box-header">
        <ul class="nav">
            <li id="icon"><a href="${pageContext.request.contextPath}/mainpage.jsp"><img src="${pageContext.request.contextPath}/Pic/MSEQ_icon.png" alt="MSEQ"></a></li>
            <li id="deal-form"><a href="${pageContext.request.contextPath}/formdeal.jsp">Deal Form</a></li>
            <li id="com-form"><a href="${pageContext.request.contextPath}/formcompany.jsp">Company Form</a> </li>
        </ul>
    </div>
</header>

<section class="sec">
    <div class="box-table">

    <div class="box-caption">
        <h2>Deals</h2>
        <img src="">
    </div>
        
    <div class="box-form">
        <table class="form" id="tb_deal"  contenteditable="true">
            <thead>
            <tr  contenteditable="false">
                <th scope="col">No.</th>
                <th>Company Name</th>
                <th>Deal No.</th>
                <th>Deal Date</th>
                <th>MSEQ investment amout</th>
                <th>Deal Size</th>
                <th>Deal Size Status</th>
                <th>Pre-money Value</th>
                <th>Post Valuation</th>
                <th>Post Valuation Status</th>
                <th>%Acquired</th>
                <th>Raised to Date</th>
                <th>MSEQ total investment to date</th>
                <th>investment return multiple to date</th>
                <th>Investment vehicle</th>
                <th>Series</th>
                <th>Deal Status</th>
                <th>co-Investors name(option)</th>
                <th>New Investors(optional)</th>
                <th>Follow-on Investors(optional)</th>
                <th>Native Currency of Deal(TBD)</th>
                <th>Year Founded</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <div id="box-add">
        <button id="content" name="deals">Submit</button>
        <button id="add_row">Add</button>
    </div>
    </div>
</section>

</body>
</html>