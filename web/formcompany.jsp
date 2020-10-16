<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/form_general.css">
    <script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JS/company_form.js"></script>
    <title>Create Form</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="mainbox">
    <jsp:include page="left_guide.jsp"></jsp:include>
    <div class="table_whole_div">
        <div class="table_caption">
            <div><h2>Companies</h2></div>
            <form id="capitalFee">
                <label for="total_capital">Total capital</label>
                <input id="total_capital" type="number">
                <label for="total_capital_raised">Total Capital Raised</label>
                <input id="total_capital_raised" type="number">
                <label for="management_fee">Management fee</label>
                <input id="management_fee" type="number">
            </form>
            <div class="edit_box">
                <label for="edit">Edit</label>
                <input type='checkbox' value='edit' id="edit">
            </div>
        </div>
        <div class="table_div">
            <table class="table" id="table_id" contenteditable="true">
                <thead>
                    <tr  contenteditable="false">
                        <th>No.</th>
                        <th>Company Name</th>
                        <th style="width: 218px">Theme</th>
                        <th>Year Founded</th>
                        <th>Runway Start Date</th>
                        <th>Runway End Date</th>
                        <th>Runway Month</th>
                        <th>Raise to Date</th>
                        <th>Employee No</th>
                        <th>Revenue</th>
                        <th>IRR</th>
                        <th>Post Valuation</th>
                        <th>Valuation Change Reason</th>
                        <th>MSEQ Investment Cur Val</th>
                    </tr>
                </thead>
                <tbody></tbody>
            </table>
        </div>

        <div id="box-add">
            <button id="add_row">Add</button>
            <button id="submit" name="deals">Submit</button>
        </div>
    </div>
</section>

</body>
</html>


