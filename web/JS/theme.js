$(function() {
    (function refresh(){
        var company_in_EM = [];
        var company_value_in_EM = [];
        var company_in_FP = [];
        var company_value_in_FP = [];
        var company_in_HSH = [];
        var company_value_in_HSH = [];
        var company_in_NS = [];
        var company_value_in_NS = [];
        var company_in_ST = [];
        var company_value_in_ST = [];
        var total_invest_EM = 0;
        var total_invest_FP = 0;
        var total_invest_HSH = 0;
        var total_invest_NS = 0;
        var total_invest_ST = 0;
        var total_EM = 0;
        var total_FP = 0;
        var total_HSH = 0;
        var total_NS = 0;
        var total_ST = 0;
        var total_company_no = 0;
        let deal_set_EM = new Set();
        let deal_set_FP = new Set();
        let deal_set_HSH = new Set();
        let deal_set_NS = new Set();
        let deal_set_ST = new Set();
        var post_valuation_data_EM = [];
        var post_valuation_data_FP = [];
        var post_valuation_data_HSH = [];
        var post_valuation_data_NS = [];
        var post_valuation_data_ST = [];
        var deal_cost_in_EM = [];
        var deal_cost_in_FP = [];
        var deal_cost_in_HSH = [];
        var deal_cost_in_NS = [];
        var deal_cost_in_ST = [];
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/themepagedata",  // Here to change back end receive url.
            data: {
                refresh: "[]",
            },
            success:function(themepage_info){

                var symbols = new Array();
                symbols.push("CompanyInFo");
                symbols.push("ThemeOfFund");
                symbols.push("CompanyTotal");
                var map = get_infos(symbols,themepage_info);
                var com_infos = split_string(map.get("CompanyInFo"));
                var theme_of_fund = split_string(map.get("ThemeOfFund"));
                var company_total = split_string(map.get("CompanyTotal"));
                var menu_themes = $(".tet");

                for (i = 0; i < theme_of_fund.length; i++){
                    var obj3 = JSON.parse(theme_of_fund[i]);
                    menu_themes[i].innerHTML = obj3["theme"].replace(/_/g," ");
                    if(isContains(obj3["theme"],"Expon")){
                        total_invest_EM = obj3["total_investment_amount"];
                        total_EM = obj3["overall_investment"] - total_invest_EM;
                        total_company_no = obj3["total_company_No"];
                    }
                    if (isContains(obj3["theme"],"Feed")){
                        total_invest_FP = obj3["total_investment_amount"];
                        total_FP = obj3["overall_investment"] - total_invest_FP;
                    }
                    if(isContains(obj3["theme"],"Human")){
                        total_invest_HSH = obj3["total_investment_amount"];
                        total_HSH = obj3["overall_investment"] - total_invest_HSH;
                    }
                    if (isContains(obj3["theme"],"New")){
                        total_invest_NS = obj3["total_investment_amount"];
                        total_NS = obj3["overall_investment"] - total_invest_NS;
                    }
                    if (isContains(obj3["theme"],"Space")){
                        total_invest_ST = obj3["total_investment_amount"];
                        total_ST = obj3["overall_investment"] - total_invest_ST;
                    }
                }
                for(i = 0; i< company_total.length;i++){
                    var obj4 = JSON.parse(company_total[i]);
                    if(isContains(obj4["theme"],"Expon")){
                        company_in_EM.push(obj4["company_name"]);
                        company_value_in_EM[i] = {value: obj4["total_investment"], name:obj4["company_name"]};
                    }
                    if (isContains(obj4["theme"],"Feed")){
                        company_in_FP.push(obj4["company_name"]);
                        company_value_in_FP[i] = {value: obj4["total_investment"], name:obj4["company_name"]};
                    }
                    if(isContains(obj4["theme"],"Human")){
                        company_in_HSH.push(obj4["company_name"]);
                        company_value_in_HSH[i] = {value: obj4["total_investment"], name:obj4["company_name"]};
                    }
                    if (isContains(obj4["theme"],"New")){
                        company_in_NS.push(obj4["company_name"]);
                        company_value_in_NS[i] = {value: obj4["total_investment"], name:obj4["company_name"]};
                    }
                    if (isContains(obj4["theme"],"Space")){
                        company_in_ST.push(obj4["company_name"]);
                        company_value_in_ST[i] = {value: obj4["total_investment"], name:obj4["company_name"]};
                    }

                }
                for(i=0; i < company_in_EM.length;i++){
                    var data_info = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        deal_set_EM.add(obj2["deal_no"]);
                        if(company_in_EM[i] == obj2["company_name"]){
                            data_info.push(obj2["post_valuation"]);
                        }
                    }

                    post_valuation_data_EM[i] = {name: company_in_EM[i], type: 'line', data: data_info};
                }
                for(i=0; i < company_in_FP.length;i++){
                    var data_info = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        deal_set_FP.add(obj2["deal_no"]);
                        if(company_in_FP[i] == obj2["company_name"]){
                            data_info.push(obj2["post_valuation"]);
                        }
                    }

                    post_valuation_data_FP[i] = {name: company_in_FP[i], type: 'line', data: data_info};
                }
                for(i=0; i < company_in_HSH.length;i++){
                    var data_info = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        deal_set_HSH.add(obj2["deal_no"]);
                        if(company_in_HSH[i] == obj2["company_name"]){
                            data_info.push(obj2["post_valuation"]);
                        }
                    }

                    post_valuation_data_HSH[i] = {name: company_in_HSH[i], type: 'line', data: data_info};
                }
                console.log(post_valuation_data_HSH);
                for(i=0; i < company_in_NS.length;i++){
                    var data_info = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        deal_set_NS.add(obj2["deal_no"]);
                        if(company_in_NS[i] == obj2["company_name"]){
                            data_info.push(obj2["post_valuation"]);
                        }
                    }

                    post_valuation_data_NS[i] = {name: company_in_NS[i], type: 'line', data: data_info};
                }
                for(i=0; i < company_in_ST.length;i++){
                    var data_info = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        deal_set_ST.add(obj2["deal_no"]);
                        if(company_in_ST[i] == obj2["company_name"]){
                            data_info.push(obj2["post_valuation"]);
                        }
                    }

                    post_valuation_data_ST[i] = {name: company_in_ST[i], type: 'line', data: data_info};
                }

                var deal_list_EM = Array.from(deal_set_EM);
                var deal_list_FP = Array.from(deal_set_FP);
                var deal_list_HSH = Array.from(deal_set_HSH);
                var deal_list_NS = Array.from(deal_set_NS);
                var deal_list_ST = Array.from(deal_set_ST);
                for (i = 0 ; i < deal_list_EM.length; i++){
                    var deal_data = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        if (isContains(obj2["theme"],"Expon")){
                            if (deal_list_EM[i] == obj2["deal_no"]){
                                deal_data.push(obj2["cost"]);
                            }
                        }
                    }
                    deal_cost_in_EM[i] = {
                        name: deal_list_EM[i],
                        type: 'bar',
                        stack: '总量',
                        label: {
                            show: true,
                            position: 'insideRight'
                        },
                        data: deal_data

                    }
                }
                for (i = 0 ; i < deal_list_FP.length; i++){
                    var deal_data = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        if (isContains(obj2["theme"],"Feed")){
                            if (deal_list_FP[i] == obj2["deal_no"]){
                                deal_data.push(obj2["cost"]);
                            }
                        }
                    }
                    deal_cost_in_FP[i] = {
                        name: deal_list_FP[i],
                        type: 'bar',
                        stack: '总量',
                        label: {
                            show: true,
                            position: 'insideRight'
                        },
                        data: deal_data

                    }
                }
                for (i = 0 ; i < deal_list_HSH.length; i++){
                    var deal_data = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        if (isContains(obj2["theme"],"Human")){
                            if (deal_list_HSH[i] == obj2["deal_no"]){
                                deal_data.push(obj2["cost"]);
                            }
                        }
                    }
                    deal_cost_in_HSH[i] = {
                        name: deal_list_HSH[i],
                        type: 'bar',
                        stack: '总量',
                        label: {
                            show: true,
                            position: 'insideRight'
                        },
                        data: deal_data

                    }
                }
                for (i = 0 ; i < deal_list_NS.length; i++){
                    var deal_data = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        if (isContains(obj2["theme"],"New")){
                            if (deal_list_NS[i] == obj2["deal_no"]){
                                deal_data.push(obj2["cost"]);
                            }
                        }
                    }
                    deal_cost_in_NS[i] = {
                        name: deal_list_NS[i],
                        type: 'bar',
                        stack: '总量',
                        label: {
                            show: true,
                            position: 'insideRight'
                        },
                        data: deal_data

                    }
                }
                for (i = 0 ; i < deal_list_ST.length; i++){
                    var deal_data = [];
                    for(j = 0; j < com_infos.length;j++){
                        var obj2 = JSON.parse(com_infos[j]);
                        if (isContains(obj2["theme"],"Space")){
                            if (deal_list_ST[i] == obj2["deal_no"]){
                                deal_data.push(obj2["cost"]);
                            }
                        }
                    }
                    deal_cost_in_ST[i] = {
                        name: deal_list_ST[i],
                        type: 'bar',
                        stack: '总量',
                        label: {
                            show: true,
                            position: 'insideRight'
                        },
                        data: deal_data

                    }
                }
                $("#EM").click(function () {
                        document.getElementById("total_company").innerHTML = "" + company_in_EM.length;
                        document.getElementById("total_amount").innerHTML = total_invest_EM;


                        var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
                        var option_invest = {
                            title: {
                                text: 'Inv Amount',
                                left: 'right'
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter: '{a} <br/>{b} : {c} ({d}%)'
                            },
                            legend: {
                                orient: 'vertical',
                                left: 'left',
                                data: company_in_EM,
                            },
                            series: [
                                {
                                    name: 'total investment',
                                    type: 'pie',
                                    radius: '55%',
                                    center: ['50%', '60%'],
                                    label:{show:false},
                                    data: company_value_in_EM,
                                    emphasis: {
                                        itemStyle: {
                                            shadowBlur: 10,
                                            shadowOffsetX: 0,
                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                        }
                                    }
                                }
                            ]
                        };
                        myChart_invest.setOption(option_invest,true);
                    var myChart_total = echarts.init(document.querySelector("#total_company_pie"));
                    var option_total = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_EM.length, name:'Exponential Machine'},
                                    {value: total_company_no - company_in_EM.length, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_total.setOption(option_total);

                    var myChart_amount = echarts.init(document.querySelector("#total_inv_pie"));
                    var option_amount = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: total_invest_EM, name:'Exponential Machine'},
                                    {value: total_EM, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_amount.setOption(option_amount,true);
                    var myChart_post = echarts.init(document.querySelector("#valuation"));
                    var option_valuation = {
                        title: {
                            text: 'Post Valuation',
                            left: 'left'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: company_in_EM
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: deal_list_EM,
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: post_valuation_data_EM,
                    };
                    myChart_post.setOption(option_valuation,true);

                    var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
                    var option_bar = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            data: deal_list_EM
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: {
                            type: 'value'
                        },
                        yAxis: {
                            type: 'category',
                            data: company_in_EM
                        },
                        series: deal_cost_in_EM
                    };
                    myChart_bar.setOption(option_bar,true);
                })
                $("#FP").click(function () {
                    document.getElementById("total_company").innerHTML = "" + company_in_FP.length;
                    document.getElementById("total_amount").innerHTML = total_invest_FP;
                    var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
                    var option_invest = {
                        title: {
                            text: 'Inv Amount',
                            left: 'right'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: company_in_FP
                        },
                        series: [
                            {
                                name: 'total investment',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label: {show: false},
                                data: company_value_in_FP,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_invest.setOption(option_invest);
                    var myChart_total = echarts.init(document.querySelector("#total_company_pie"));
                    var option_total = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_FP.length, name:'Feeding 10B People'},
                                    {value: (total_company_no - company_in_FP.length) , name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_total.setOption(option_total,true);

                    var myChart_amount = echarts.init(document.querySelector("#total_inv_pie"));
                    var option_amount = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: total_invest_FP, name:'Feeding 10B People'},
                                    {value: total_FP, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_amount.setOption(option_amount,true);
                    var myChart_post = echarts.init(document.querySelector("#valuation"));
                    var option_valuation = {
                        title: {
                            text: 'Post Valuation',
                            left: 'left'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: company_in_FP
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: deal_list_FP,
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: post_valuation_data_FP,
                    };
                    myChart_post.setOption(option_valuation,true);

                    var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
                    var option_bar = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            data: deal_list_FP
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: {
                            type: 'value'
                        },
                        yAxis: {
                            type: 'category',
                            data: company_in_FP
                        },
                        series: deal_cost_in_FP
                    };
                    myChart_bar.setOption(option_bar,true);
                })
                $("#HSH").click(function () {
                    document.getElementById("total_company").innerHTML = "" + company_in_HSH.length;
                    document.getElementById("total_amount").innerHTML = total_invest_HSH;
                        var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
                        var option_invest = {
                            title: {
                                text: 'Inv Amount',
                                left: 'right'
                            },
                            tooltip: {
                                trigger: 'item',
                                formatter: '{a} <br/>{b} : {c} ({d}%)'
                            },
                            legend: {
                                orient: 'vertical',
                                left: 'left',
                                data: company_in_HSH
                            },
                            series: [
                                {
                                    name: 'total investment',
                                    type: 'pie',
                                    radius: '55%',
                                    center: ['50%', '60%'],
                                    label:{show:false},
                                    data: company_value_in_HSH,
                                    emphasis: {
                                        itemStyle: {
                                            shadowBlur: 10,
                                            shadowOffsetX: 0,
                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                        }
                                    }
                                }
                            ]
                        };
                        myChart_invest.setOption(option_invest,true);
                    var myChart_total = echarts.init(document.querySelector("#total_company_pie"));
                    var option_total = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_HSH.length, name:'Humanity Scale Healthcare'},
                                    {value: total_company_no - company_in_HSH.length, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_total.setOption(option_total,true);

                    var myChart_amount = echarts.init(document.querySelector("#total_inv_pie"));
                    var option_amount = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: total_invest_HSH, name:'Humanity Scale Healthcare'},
                                    {value: total_HSH, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_amount.setOption(option_amount,true);
                        var myChart_post = echarts.init(document.querySelector("#valuation"));
                        var option_valuation = {
                            title: {
                                text: 'Post Valuation',
                                left: 'left'
                            },
                            tooltip: {
                                trigger: 'axis'
                            },
                            legend: {
                                data: company_in_HSH
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            toolbox: {
                                feature: {
                                    saveAsImage: {}
                                }
                            },
                            xAxis: {
                                type: 'category',
                                boundaryGap: false,
                                data: deal_list_HSH,
                            },
                            yAxis: {
                                type: 'value'
                            },
                            series: post_valuation_data_HSH
                        };
                        myChart_post.setOption(option_valuation,true);

                        var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
                        var option_bar = {
                            tooltip: {
                                trigger: 'axis',
                                axisPointer: {
                                    type: 'shadow'
                                }
                            },
                            legend: {
                                data: deal_list_HSH,
                            },
                            grid: {
                                left: '3%',
                                right: '4%',
                                bottom: '3%',
                                containLabel: true
                            },
                            xAxis: {
                                type: 'value'
                            },
                            yAxis: {
                                type: 'category',
                                data: company_in_HSH,
                            },
                            series: deal_cost_in_HSH,
                        };
                        myChart_bar.setOption(option_bar,true);
                })
                $("#NS").click(function () {
                    document.getElementById("total_company").innerHTML = company_in_NS.length + "";
                    document.getElementById("total_amount").innerHTML = total_invest_NS;


                    var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
                    var option_invest = {
                        title: {
                            text: 'Inv Amount',
                            left: 'right'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: company_in_NS,
                        },
                        series: [
                            {
                                name: 'total investment',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: company_value_in_NS,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_invest.setOption(option_invest,true);
                    var myChart_total = echarts.init(document.querySelector("#total_company_pie"));
                    var option_total = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_NS.length, name:'New Society'},
                                    {value: total_company_no - company_in_NS.length, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_total.setOption(option_total,true);

                    var myChart_amount = echarts.init(document.querySelector("#total_inv_pie"));
                    var option_amount = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_NS.length, name:'New Society'},
                                    {value: total_NS, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_amount.setOption(option_amount,true);
                    var myChart_post = echarts.init(document.querySelector("#valuation"));
                    var option_valuation = {
                        title: {
                            text: 'Post Valuation',
                            left: 'left'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: company_in_NS
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: deal_list_NS,
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: post_valuation_data_NS,
                    };
                    myChart_post.setOption(option_valuation,true);

                    var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
                    var option_bar = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            data: deal_list_NS
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: {
                            type: 'value'
                        },
                        yAxis: {
                            type: 'category',
                            data: company_in_NS
                        },
                        series: deal_cost_in_NS
                    };
                    myChart_bar.setOption(option_bar,true);
                })
                $("#ST").click(function () {
                    document.getElementById("total_company").innerHTML = "" + company_in_ST.length;
                    document.getElementById("total_amount").innerHTML = total_invest_ST;


                    var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
                    var option_invest = {
                        title: {
                            text: 'Inv Amount',
                            left: 'right'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: company_in_ST,
                        },
                        series: [
                            {
                                name: 'total investment',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: company_value_in_ST,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_invest.setOption(option_invest,true);
                    var myChart_total = echarts.init(document.querySelector("#total_company_pie"));
                    var option_total = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: company_in_ST.length, name:'Space Transport'},
                                    {value: total_company_no - company_in_ST.length, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_total.setOption(option_total,true);

                    var myChart_amount = echarts.init(document.querySelector("#total_inv_pie"));
                    var option_amount = {
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        series: [
                            {
                                name: 'total',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                label:{show:false},
                                data: [
                                    {value: total_invest_ST, name:'Space Transport'},
                                    {value: total_ST, name:'others'},
                                ],
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    myChart_amount.setOption(option_amount,true);
                    var myChart_post = echarts.init(document.querySelector("#valuation"));
                    var option_valuation = {
                        title: {
                            text: 'Post Valuation',
                            left: 'left'
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: company_in_ST
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        toolbox: {
                            feature: {
                                saveAsImage: {}
                            }
                        },
                        xAxis: {
                            type: 'category',
                            boundaryGap: false,
                            data: deal_list_ST,
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: post_valuation_data_ST,
                    };
                    myChart_post.setOption(option_valuation,true);

                    var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
                    var option_bar = {
                        tooltip: {
                            trigger: 'axis',
                            axisPointer: {
                                type: 'shadow'
                            }
                        },
                        legend: {
                            data: deal_list_ST
                        },
                        grid: {
                            left: '3%',
                            right: '4%',
                            bottom: '3%',
                            containLabel: true
                        },
                        xAxis: {
                            type: 'value'
                        },
                        yAxis: {
                            type: 'category',
                            data: company_in_ST
                        },
                        series: deal_cost_in_ST
                    };
                    myChart_bar.setOption(option_bar,true);
                })


            },
            error: function(){
                console.log("No,something wrong.");
            }
        });
    }());

    $("li").click(function (){
        $(this).addClass("selected").siblings().removeClass("selected");
    })

    function split_string(str){
        var strings = str.substring(1,str.length-1).split("},{");
        if (strings.length === 1){
            return strings
        }
        for (i = 0; i < strings.length; i++){ // Get rid of [] and split each item up.
            if (i === 0) {
                strings[i] += "}";
            }else if (i === strings.length-1){
                strings[i] = "{" + strings[i];
            }else {
                strings[i] = "{" + strings[i] + "}";
            }
        }
        return strings;
    }

    function get_infos(symbols, msg){
        var map = new Map;
        if (symbols.length === 1){
            map.put(symbols[0], msg.split(symbols[0])[1]);
            return map;
        }
        var rest = "";
        for (var i = 0; i < symbols.length; i++){
            if (i === 0){
                rest = msg.split(symbols[i])[1];
            }else if (i < symbols.length - 1){
                map.set(symbols[i-1],rest.split(symbols[i])[0]);
                rest = rest.split(symbols[i])[1];
            }else{
                map.set(symbols[i-1],rest.split(symbols[i])[0]);
                map.set(symbols[i],rest.split(symbols[i])[1]);
            }
        }
        return map;
    }

    function isContains(str, substr) {
        return new RegExp(substr).test(str);
    }
})