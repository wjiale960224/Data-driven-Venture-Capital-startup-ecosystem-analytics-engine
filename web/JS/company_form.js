window.onload = function (){
    ///Add button
    var btn_add = document.getElementById("add_row"); // add button
    btn_add.onclick = function () {
        var tb_deal = document.getElementById("tb_deal"); // table
        var tbody = document.getElementsByTagName("tbody")[0]; // tbody
        var th_deal = $("thead>tr>th"); // table heads
        var tr = document.createElement("tr");
        tbody.appendChild(tr);
        for (var i = 0; i < th_deal.length; i++){
            if (i===0){
                var th = document.createElement("th");
                th.tabIndex = (tb_deal.rows.length-1)*(th_deal.length-1)+i;
                th.className = "tes";
                var div = document.createElement("div");
                div.className = "cellno";
                var span1 = document.createElement("span");
                span1.className = "rmspan";
                span1.innerHTML = "&#128683"; // &#128683,&#128686,&#9924,&#10062,&#9746,&#10062
                var span2 = document.createElement("span");
                span2.className = "no";
                span2.innerHTML = String(tb_deal.rows.length-1);
                th.contentEditable = "false";

                div.appendChild(span1);
                div.appendChild(span2);
                th.appendChild(div);
                tr.appendChild(th);
            }else {
                var td = document.createElement("td");
                td.tabIndex = (tb_deal.rows.length-1)*(th_deal.length-1)+i;
                // td.headers="company";
                var tx = document.createTextNode("");
                td.appendChild(tx);
                tr.appendChild(td);
            }

            update_rm();
        }
    }


    /// update number
    function update_rm(){
        var rm = document.getElementsByClassName("rmspan");
        var no = document.getElementsByClassName("no");

        for (var i = 0; i < rm.length; i++){
            rm[i].onclick = function(){
                var tbody = this.parentElement.parentElement.parentElement.parentElement;
                var tr1 = this.parentElement.parentElement.parentElement;
                tbody.removeChild(tr1);

                for (var i = 0; i < no.length; i++){
                    no[i].innerHTML = String(i+1);
                }
            }
        }
    }

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
    var btn_submit = document.getElementById("content");
    btn_submit.onclick = function (){
        var company = JSON.stringify(collect_info());
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/company_form",
            data: {
                company: company,
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

    // Initialize form
    for (var i = 0; i < 3; i++){
        btn_add.click();
    }

}





