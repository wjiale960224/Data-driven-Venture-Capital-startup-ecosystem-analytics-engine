var have_submit = true;
window.onload = function (){

    $(function(){

        // Add rows.
        $("#add_row").click(function(event){
            var $index = $(".table>tbody>tr").length+1;
            var $tbody = $(".table>tbody"); // table
            var $checked = $("#edit").is(":checked");
            var $td = "<td><input class='td_input' type='text'></td>";
            var $tds = "";
            for (var i = 0; i < $("thead th").length-1; i++){
                if (i === 1){
                    $tds += "<td><input class='td_input' type='date'></td>";
                }else if (i === 3){
                    $tds += "<td><select class='td_input dropdownchoice'><option></option><option>Pre-seed</option><option>Seed</option>" +
                        "<option>Series A</option><option>Series B</option>" +
                        "<option>Series C</option></select></td>"
                }else if (i === 6){
                    $tds += "<td><select class='td_input dropdownchoice'><option></option><option>Equities</option><option>Notes</option>" +
                        "</select></td>"
                }else if (i === 7 || i===0){
                    $tds += "<td><input class='td_input' type='text'></td>";
                }else if (i === 4){
                    $tds += "<td><input class='td_input mseq_invest_amt' type='number'></td>";
                }else {
                    $tds += "<td><input class='td_input' type='number'></td>";
                }
            }

            $tbody.append("<tr contenteditable = "+ $checked +"><th contenteditable='false'><div class='first_col_div'><div class='index'>" + $index + "</div>" +
                "<div class='delete'>&#128683</div></div></th>"+ $tds +"</tr>");
            if ($index > 10){
                $(".table_div").addClass("scroll_table");
            }
            $("input").attr({readOnly:!$checked});
            $(".dropdownchoice").attr("disabled",!$checked);
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
            var $count = $(".table>tbody>tr").length;
            if ($count < 11){
                $(".table_div").removeClass("scroll_table");

            }
        });

        // Change edit status.
        $("#edit").click(function(){
            if ($(this).is(":checked") === true){
                $("input").attr({readOnly: false});
                $("select").attr("disabled",false);
            }else {
                $("input").attr({readOnly: true});
                $("select").attr("disabled",true);
            }
        });


        // Collect a company's information
        function collect_info() {
            var $tr = $("tbody>tr");
            var companyList = [];
            for (var i = 0; i < $tr.length; i++) {
                var company = {};
                var check_empty = 0;

                for (var j = 1; j < $tr[i].cells.length; j++) {
                    var cont = $tr[i].cells[j].childNodes[0].value; // use .value to correctly get string from dropdown selection
                    if (cont===""){
                        check_empty++;
                    }else {
                        var col_head = $("table")[0].tHead.rows[0].cells[j].innerHTML.replace(/\s/g,"_");
                        company[col_head] = cont;
                    }

                }
                if (check_empty === $tr[i].cells.length-1){
                    continue;
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
                type: "POST",
                url: "/workspace_Intellj_war_exploded/deal_form", // Here to change back end receive url.
                data: {
                    refresh: "[]",
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
                            var $deal = JSON.parse(deals[i]);
                            $('#add_row').click();
                            var $trs = $("tbody>tr");
                            for (var j = 1; j < $trs[$trs.length-1].cells.length; j++){
                                var attr = $("table")[0].tHead.rows[0].cells[j].innerHTML.replace(/\s/g,"_");
                                if ($deal[attr]){
                                    if (typeof $deal[attr] === "string"){
                                        $trs[$trs.length-1].cells[j].childNodes[0].value = $deal[attr].replace(/_/g," ");
                                    }else if (typeof $deal[attr] === "number"){
                                        $trs[$trs.length-1].cells[j].childNodes[0].value = $deal[attr];
                                    }
                                }
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
            $("body").delegate("input", "DOMSubtreeModified", function(event){
                have_submit = false;
                console.log("Input changed");
                event.stopPropagation();
                $("body").undelegate("input", "DOMSubtreeModified");
            });

            /*$("body").delegate(".mseq_invest_amt","change",function(){
                var deal_size = $(this).parent().prev().prev().children(0).val();
                var mseq_inv_amt = this.value;
                if (deal_size || mseq_inv_amt){
                    var own_percent = (mseq_inv_amt / deal_size * 100).toFixed(2);
                    var last = $(this).parent().siblings(":last");
                    last.children(0).val(own_percent);
                }
            });*/
        },3000);

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





