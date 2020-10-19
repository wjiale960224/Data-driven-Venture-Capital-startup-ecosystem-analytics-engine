window.onload = function (){
    ///Add button
    $("#add_row").click(function(){
        var tb_deal = document.getElementById("tb_deal"); // table
        var tbody = document.getElementsByTagName("tbody")[0]; // tbody
        var th_deal = document.getElementsByTagName("th"); // table heads
        var tr = document.createElement("tr");
        tbody.appendChild(tr);
        for (var i = 0; i < th_deal.length; i++){
            var td = document.createElement("td");
            td.tabIndex = (tb_deal.rows.length-1)*(th_deal.length-1)+i;
            if (i===0){
                td.className = "tes";
                var div = document.createElement("div");
                div.className = "cellno";
                var span1 = document.createElement("span");
                span1.className = "rmspan";
                span1.innerHTML = "&#128683"; // &#128683,&#128686,&#9924,&#10062,&#9746,&#10062
                var span2 = document.createElement("span");
                span2.className = "no";
                span2.innerHTML = String(tb_deal.rows.length-1);
                td.contentEditable = "false";

                div.appendChild(span1);
                div.appendChild(span2);
                td.appendChild(div);
            }else {
                var tx = document.createTextNode("");
                td.appendChild(tx);
            }
            tr.appendChild(td);

            update_rm();
        }
    });


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


    // submit button
    var btn_submit = document.getElementById("submit");
    btn_submit.onclick = function (){
        alert("TBD")
    }

}




