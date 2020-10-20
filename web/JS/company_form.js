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
                    $tds += "<td><select class='td_input dropdownchoice'><option>Exponential Machines</option><option>Feeding 10B People</option>" +
                        "<option>Humanity Scale Healthcare</option><option>New Society</option>" +
                        "<option>Space & Transport</option></select></td>"
                }else if (i === 2){
                    $tds += "<td><input class='td_input' type='number' placeholder='2008'></td>";
                }else if (i === 3){
                    $tds += "<td><input class='td_input' type='date'></td>";
                }else if (i === 4){
                    $tds += "<td><input class='td_input date_input' type='date'></td>";
                }else if (i === 5){
                    $tds += "<td><input class='td_input' type='number' placeholder='24'></td>";
                }else if ((i>=8 && i<=10) || (i>=12 && i<=13) || i===6){
                    $tds += "<td><input class='td_input' type='number'></td>";
                }else if (i === 7){
                    $tds += "<td><input class='td_input' type='number' placeholder='150'></td>";
                } else {
                    $tds += $td;
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
                    var cont = $tr[i].cells[j].childNodes[0].value;
                    if (cont===""){
                        check_empty++;
                    }else {
                        var col_head = $("table")[0].tHead.rows[0].cells[j].innerHTML.replace(/\s/g,"_");
                        if (col_head === "Theme"){
                            company[col_head] = cont.replace(/s+/g,"_");
                        }else {
                            company[col_head] = cont;
                        }
                    }
                }
                if (check_empty === $tr[i].cells.length-1){
                    continue;
                }
                companyList[i] = company;
            }
            return companyList;
        }
        function collect_capital(){
            var capital = {};
            capital["total_capital"] = document.getElementById("total_capital").value;
            capital["management_fee"] =document.getElementById("management_fee").value;
            capital["total_capital_raised"] =document.getElementById("total_capital_raised").value;

            return capital;
        }

        // submit button
        $("#submit").click(function(){
            var company = JSON.stringify(collect_info());
            var capital = JSON.stringify(collect_capital());
            alert("Submitting Data");

            $.ajax({
                type: "POST",
                url: "/workspace_Intellj_war_exploded/company_form",
                data: {
                    company: capital+"totalCapital&manageFee"+company,
                },
                success:function(msg){
                    alert("Submit successfully");
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
                url: "/workspace_Intellj_war_exploded/company_form",  // Here to change back end receive url.
                data: {
                    refresh: "[]",
                },
                success:function(company_info){
                    console.log("yes,refreshed.");
                    var infos = company_info.split("totalCapital&manageFee");
                    var capitalAFee = JSON.parse(infos[1]);
                    document.getElementById("total_capital").value = capitalAFee["total_capital"];
                    document.getElementById("management_fee").value = capitalAFee["management_fee"];
                    document.getElementById("total_capital_raised").value = capitalAFee["total_capital_raised"];

                    company_info = infos[0];
                    if (company_info === "[]"){

                    }else {
                        var companies = company_info.substring(1,company_info.length-1).split("},{"); // Get rid of "[]" in "[{},{}]", and split deals
                        for (i = 0; i < companies.length; i++){ // Get rid of [] and split each item up.
                            if (i === 0) {
                                companies[i] += "}";
                            }else if (i === companies.length-1){
                                companies[i] = "{" + companies[i];
                            }else {
                                companies[i] = "{" + companies[i] + "}";
                            }
                        }
                        for (i = 0; i < companies.length; i++){ // Refresh table according to data in database
                            var $company = JSON.parse(companies[i]); // Reconstruct string format to object format
                            $('#add_row').click();
                            var $trs = $("tbody>tr");
                            for (var j = 1; j < $trs[$trs.length-1].cells.length; j++){ // Update table
                                var attr = $("table")[0].tHead.rows[0].cells[j].innerHTML.replace(/\s/g,"_");
                                if ($company[attr]){
                                    if (typeof $company[attr] === "string"){
                                        if (attr === "Theme" && $company[attr].replace(/_/g," ") === "Space Transport"){
                                            $trs[$trs.length-1].cells[j].childNodes[0].value = "Space & Transport";
                                        }else {
                                            $trs[$trs.length-1].cells[j].childNodes[0].value = $company[attr].replace(/_/g," ");
                                        }
                                    }else if (typeof $company[attr] === "number"){
                                        $trs[$trs.length-1].cells[j].childNodes[0].value = $company[attr].toFixed(6);
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
                $("tbody").undelegate("input", "DOMSubtreeModified");

            });
            // $(".date_input").on("change", function(){console.log("here")});
            $("body").delegate(".date_input","change",function(){
                // var d_start = new Date($(this).parent().prev().children(0).val());
                var d_start = new Date();
                var d_end = new Date(this.value);
                var months = (d_end.getFullYear() - d_start.getFullYear())*12;
                months += (d_end.getMonth() - d_start.getMonth());
                if (d_end.getDate() < d_start.getDate()){
                    months -= 1;
                }
                if(isNaN(months)){

                }else {
                    $(this).parent().next().children(0).val(months);
                }
            });
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





