<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="CSS/form_general.css">
    <script src="${pageContext.request.contextPath}/JS/jquery-3.5.1.js"></script>
    <script src="${pageContext.request.contextPath}/JS/deal_form.js"></script>
    <title>Create Form</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="mainbox">
    <jsp:include page="left_guide.jsp"></jsp:include>
    <div class="table_whole_div">
        <div class="table_caption">
            <div><h2>Deals</h2></div>
            <div class="edit_box">
                <label for="edit">Edit</label>
                <input type='checkbox' value='edit' id="edit">
            </div>
        </div>
        
        <div class="table_div">
            <table class="table" id="tb_deal" contenteditable="true">
                <thead>
                <tr  contenteditable="false">
                    <th scope="col">No.</th>
                    <th>Company_Name</th>
                    <th>Deal_Date</th>
                    <th>Deal_Size</th>
                    <th>Deal_Status</th>
                    <th>Series</th>
                    <th>MSEQ_Invest_amount</th>
                    <th>Post_Valuation</th>
                    <th>Invest_Vehicle</th>
                    <th>Co_Investor</th>
                    <th>Fund_Percent</th>
                    <th>Own_Percent</th>
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