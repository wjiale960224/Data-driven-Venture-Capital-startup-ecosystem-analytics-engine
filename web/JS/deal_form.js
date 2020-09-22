window.onload = function (){
    $(function(){
        var $index = -1;
        $("#add_row").click(function(event){
            $index = $(".table>tbody>tr").length+1;
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

        $(".table").delegate(".delete", "click", function(){
            $(this).parent().parent().parent().remove();
            var $index = $(".index");
            for (var i = 0; i < $index.length; i++){
                $index.eq(i).html(i+1);
            }
        });

        $("#edit").click(function(){
            var $toby = $("tbody");
            if ($(this).is(":checked") === true){
                $toby.children("tr").attr({contentEditable:true})
                $toby.children("th").attr({contentEditable:false})
            }else {
                $toby.children("tr").attr({contentEditable:false})
            }
        });
    });


    // Collect a deal's information
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
    var btn_submit = document.getElementById("submit");
    btn_submit.onclick = function (){
        var deal = JSON.stringify(collect_info());
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/deal_form",
            data: {
                deal: deal,
            },
            success:function(msg){
                console.log("yes,data delivered.");
                console.log(msg);
            },
            error: function(e){
                console.log("No,data not delivered.");
            }
        });
    }

}





