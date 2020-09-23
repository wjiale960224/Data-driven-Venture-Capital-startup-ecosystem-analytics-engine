var have_submit = true;
window.onload = function (){

    $(function(){

        // Add rows.
        $("#add_row").click(function(event){
            var $index = $(".table>tbody>tr").length+1;
            var $tbody = $(".table>tbody"); // table
            var $checked = $("#edit").is(":checked");
            var $td = "<td></td>";
            var $tds = "";
            for (var i = 0; i < $("thead th").length-1; i++){
                $tds += $td;
            }
            $tbody.append("<tr contenteditable = "+ $checked +"><th contenteditable='false'><div class='first_col_div'><div class='index'>" + $index + "</div>" +
                "<div class='delete'>&#128683</div></div></th>"+ $tds +"</tr>");
            event.stopPropagation();

        });

        // Delete a row.
        $(".table").delegate(".delete", "click", function(){
            if (confirm("Are you sure you want to delete this row?") === true){
                $(this).parent().parent().parent().remove();
                var $index = $(".index");
                for (var i = 0; i < $index.length; i++){
                    $index.eq(i).html(i+1);
                }
            }
        });

        // Change edit status.
        $("#edit").click(function(){
            var $toby = $("tbody");
            if ($(this).is(":checked") === true){
                $toby.children("tr").attr({contentEditable:true})
                $toby.children("th").attr({contentEditable:false})
            }else {
                $toby.children("tr").attr({contentEditable:false})
            }
        });


        // Collect a company's information
        function collect_info() {
            var $tr = $("tbody>tr");
            var companyList = [];
            for (var i = 0; i < $tr.length; i++) {
                var company = {};
                for (var j = 1; j < $tr[i].cells.length; j++) {
                    var cont = $tr[i].cells[j].innerHTML;
                    var col_head = $("table")[0].tHead.rows[0].cells[j].innerHTML;
                    company[col_head] = cont;
                }
                companyList[i] = company;
            }
            return companyList;
        }

        // submit button
        $("#submit").click(function(){
            var deal = JSON.stringify(collect_info());
            $.ajax({
                type: "POST",
                url: "/workspace_Intellj_war_exploded/deal_form",
                data: {
                    deal: deal,
                },
                success:function(msg){
                    have_submit = true; // Do not promp window if have submitted.
                    console.log("Submitted, have submit:" + have_submit);
                    console.log("yes,data delivered.");
                    console.log(msg);
                },
                error: function(e){
                    console.log("No,data not delivered.");
                }
            });
        });

        // Refresh table according to database info.
        (function refresh(){
            $.ajax({
                type: "GET",
                url: "/workspace_Intellj_war_exploded/deal_form",
                data: {
                    refresh: "22",
                },
                success:function(deal_info){
                    console.log("yes,refreshed.");
                    if (deal_info === "[]"){
                        for (var i = 0; i < 5; i++){
                            $("#add_row").click();
                        }
                    }else {
                        var deals = deal_info.substring(1,deal_info.length-1).split("},{"); // Get rid of "[]" in "[{},{}]", and split deals
                        for (i = 0; i < deals.length; i++){ // Get rid of [] and split each item up.
                            if (i === 0) {
                                deals[i] += "}";
                            }else if (i === deals.length-1){
                                deals[i] = "{" + deals[i];
                            }else {
                                deals[i] = "{" + deals[i] + "}";
                            }
                        }
                        for (i = 0; i < deals.length; i++){ // Reconstruct string format to object format
                            console.log(deals[i]);
                            var $deal = JSON.parse(deals[i]);
                            $('#add_row').click();
                            var $trs = $("tbody>tr");
                            for (var j = 1; j < $trs[$trs.length-1].cells.length; j++){
                                var attr = $("table")[0].tHead.rows[0].cells[j].innerHTML;
                                $trs[$trs.length-1].cells[j].innerHTML = $deal[attr];
                            }
                        }
                    }
                },
                error: function(){
                    console.log("No,something wrong.");
                }
            });
        }());

        // 1.5 minutes later add td onchange function.
        setTimeout(function (){
            $("tbody").delegate("td", "DOMSubtreeModified", function(event){
                have_submit = false;
                console.log("Td changed");
                event.stopPropagation();
                $("tbody").undelegate("td", "DOMSubtreeModified");

            });
        },1500);

        // -------Next function-----

    });
}


// Remind user save table
window.onbeforeunload = function(event){
    console.log("Close window, have submit:" + have_submit);
    if (!have_submit){
        event.returnValue = "You have not submit changes, exist？";
    }
}





