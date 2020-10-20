
var date = new Date();
var nowMonth = date.getMonth() + 1;
var strDate = date.getDate();
var seperator = "-";
if (nowMonth >= 1 && nowMonth <= 9) {
    nowMonth = "0" + nowMonth;
}
if (strDate >= 0 && strDate <= 9) {
    strDate = "0" + strDate;
}

var nowDate = date.getFullYear() + seperator + nowMonth + seperator + strDate;

$(function () {




    (function refresh(){
        var company_name = [];
        var fund = [];
        var mydata_company = [];
        var mydata_theme = [];
        var drawn = 0;
        var undrawn = 0;
        var bar_data = [];
        var tvpidata = [];
        var tvpidate = [];
        var initial_A = 0;
        var initial_B = 0;
        var initial_C = 0;
        var initial_Pre = 0;
        var initial_Seed = 0;
        var initial_null = 0;
        var Current_A = 0;
        var Current_B = 0;
        var Current_C = 0;
        var Current_Pre = 0;
        var Current_Seed = 0;
        var Current_null = 0;
        var initial_date = "";
        var double_pie = echarts.init(document.querySelector("#double_pie"));
        var pie = echarts.init(document.querySelector("#pie"));
        var mseq_bar = echarts.init(document.querySelector("#mseq_bar"));
        var TVPI_curve = echarts.init(document.querySelector("#TVPI_curve"));
        var two_pie = echarts.init(document.querySelector("#two_pie"));
        two_pie.showLoading({
            text: 'loading',
            color: '#c23531',
            textColor: '#000',
            maskColor: 'rgba(255, 255, 255, 0.2)',
            zlevel: 0,
        });
        TVPI_curve.showLoading({
            text: 'loading',
            color: '#c23531',
            textColor: '#000',
            maskColor: 'rgba(255, 255, 255, 0.2)',
            zlevel: 0,
        });
        double_pie.showLoading({
            text: 'loading',
            color: '#c23531',
            textColor: '#000',
            maskColor: 'rgba(255, 255, 255, 0.2)',
            zlevel: 0,
        });
        pie.showLoading({
            text: 'loading',
            color: '#c23531',
            textColor: '#000',
            maskColor: 'rgba(255, 255, 255, 0.2)',
            zlevel: 0,
        });
        mseq_bar.showLoading({
            text: 'loading',
            color: '#c23531',
            textColor: '#000',
            maskColor: 'rgba(255, 255, 255, 0.2)',
            zlevel: 0,
        });
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/mainpagedata",  // Here to change back end receive url.
            data: {
                refresh: "[]",
            },
            success:function(mainpage_info){
                console.log("yes,refreshed.");
                console.log(mainpage_info);

                var symbols = new Array();
                symbols.push("PerOfFun");
                symbols.push("OvInfo");
                symbols.push("ThemeOfFund");
                symbols.push("Tvpi");
                symbols.push("SeriesData");
                var map = get_infos(symbols,mainpage_info);
                var per_of_funds = split_string(map.get("PerOfFun"));
                var over_infos = split_string(map.get("OvInfo"));
                var theme_of_fund = split_string(map.get("ThemeOfFund"));
                var tvpi = split_string(map.get("Tvpi"));
                var series = split_string(map.get("SeriesData"));

                var obj_initial = JSON.parse(series[0]);
                initial_A = obj_initial["No_Series_A"];
                initial_B = obj_initial["No_Series_B"];
                initial_C = obj_initial["No_Series_C"];
                initial_Pre = obj_initial["No_Series_Pre"];
                initial_Seed = obj_initial["No_Series_Seed"];
                initial_null = obj_initial["No_Series_null_value"];
                initial_date = obj_initial["update_date"];
                if (series.length>1) {
                    for (var i = 0; i < series.length; i++) {
                        var obj_current = JSON.parse(series[i]);
                        Current_A += obj_current["No_Series_A"];
                        Current_B += obj_current["No_Series_B"];
                        Current_C += obj_current["No_Series_C"];
                        Current_Pre += obj_current["No_Series_Pre"];
                        Current_Seed += obj_current["No_Series_Seed"];
                        Current_null += obj_current["No_Series_null_value"];
                    }
                }
                else{
                    Current_A = initial_A;
                    Current_B = initial_B;
                    Current_C = initial_C;
                    Current_Pre = initial_Pre;
                    Current_Seed = initial_Seed;
                    Current_null = initial_null;
                }

                for(var i = 0 ; i<tvpi.length;i++){
                    var obj = JSON.parse(tvpi[i]);
                    tvpidate.push(obj["date"]);
                    if (tvpidate.length > 15){
                        tvpidate.unshift();
                    }
                    tvpidata.push(obj["tvpi"]);
                    if (tvpidata.length>15){
                        tvpidata.unshift();
                    }
                }
                for (var i = 0; i < per_of_funds.length; i++){ // Reconstruct string format to object format
                    var obj = JSON.parse(per_of_funds[i]);
                    company_name.push(obj["company_name"]);
                    fund.push(obj["fund"]);
                    mydata_company[i] = {value: fund[i], name: company_name[i]};
                }
                for (i = 0; i < over_infos.length; i++){ // Reconstruct string format to object format
                    var obj2 = JSON.parse(over_infos[i]);
                    drawn = obj2["Drawn_Capital"];
                    undrawn = obj2["Undrawn_Capital"];
                    document.getElementById("total_fund_size").innerHTML = "A$" + obj2["Total_Fund_Size"] + "M";
                    document.getElementById("undrawn_capital").innerHTML = "A$" + obj2["Undrawn_Capital"] + "M";
                    document.getElementById("No_deals").innerHTML = obj2["Total_Deals"];
                    document.getElementById("drawn_capital").innerHTML = "A$" + obj2["Drawn_Capital"] + "M";
                    document.getElementById("per_deal").innerHTML ="A$" + obj2["Per_Deal"] + "M";
                    document.getElementById("No_company").innerHTML =obj2["Total_Companies"];
                    document.getElementById("management_fee").innerHTML = "A$" + obj2["Management_Fee"] + "M";
                    document.getElementById("remaining_to_invest").innerHTML = "A$" + obj2["Remaining_to_invest"] + "M";
                    document.getElementById("total_capital_raised").innerHTML = "A$" + obj2["Total_capital_raised"] + "M";
                    bar_data = [obj2["Mseq_investment_amount"], obj2["Total_capital_raised"]];

                }

                for (i = 0; i < theme_of_fund.length; i++){
                    var obj3 = JSON.parse(theme_of_fund[i]);
                    mydata_theme[i] = {value: obj3["fund"], name:obj3["theme"]};
                    console.log(obj3);
                }
                var two_pie_option = {
                    title: [
                        {
                            text: nowDate,
                            left: '50%',
                            textAlign: 'center',
                        },

                        {
                            text: initial_date,
                            left: '50%',
                            top: '52.5%',
                            textAlign: 'center'
                        }
                    ],
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    series: [
                        {
                            name: nowDate,
                            type: 'pie',
                            radius: '35%',
                            center: ['50%', '30%'],
                            data: [{value: Current_A, name: "Series A"},
                                {value: Current_B, name: "Series B"},
                                {value: Current_C, name: "Series C"},
                                {value: Current_Pre, name: "Series Preseed"},
                                {value: Current_Seed, name: "Series Seed"},
                                {value: Current_null, name: "null value"},],
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        },

                        {
                            name: initial_date,
                            type: 'pie',
                            radius: '35%',
                            center: ['50%', '80%'],
                            data: [{value: initial_A, name: "Series A"},
                                {value: initial_B, name: "Series B"},
                                {value: initial_C, name: "Series C"},
                                {value: initial_Pre, name: "Series Preseed"},
                                {value: initial_Seed, name: "Series Seed"},
                                {value: initial_null, name: "null value"},],
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

                two_pie.setOption(two_pie_option);
                two_pie.hideLoading();

                var TVPI_curve_option = {
                    title: {
                        text: 'TVPI curve',
                        left: '50%',
                        textAlign: 'center',
                    },
                    tooltip: {
                        trigger: 'axis',
                    },
                    grid: {
                        left: '3%',
                        right: "20px",
                        bottom: '3%',
                        width: "730px",
                        // height: "100%",
                        containLabel: true,
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },

                    xAxis: {
                        type: 'category',
                        data: tvpidate,
                        boundaryGap: false,
                        axisLabel:{
                            interval: 0,
                            rotate: -60,
                        },
                    },
                    yAxis: {
                        type: 'value',
                    },
                    series: [{
                        data: tvpidata,
                        type: 'line',
                    }]
                };
                TVPI_curve.setOption(TVPI_curve_option);
                TVPI_curve.hideLoading();

                var double_pie_option = {
                    title: {
                        text: 'Overview % of Fund',
                        left:'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b}: {c} ({d}%)'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    series: [
                        {
                            name: 'theme',
                            type: 'pie',
                            radius: [0, '70%'],
                            label: {
                                show:false
                            },
                            labelLine: {
                                show: false
                            },
                            data: mydata_theme,
                        },
                        {
                            name: 'MSEQ_overview',
                            type: 'pie',
                            radius: ['80%', '95%'],
                            label: {
                                show:false
                            },
                            labelLine: {
                                show:false
                            },
                            data: mydata_company,
                            itemStyle:{
                                normal:{
                                    color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
                                }
                            },
                        }
                    ]
                };
                double_pie.setOption(double_pie_option);
                double_pie.hideLoading();
                var pie_option = {
                    title: {
                        text: 'Drawn & Undrawn Capital',
                        left: '50%',
                        textAlign: 'center',
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    legend: {
                        top: '10%',
                        orient: 'vertical',
                        left: 10,
                        data: ['Drawn', 'Undrawn',],
                    },
                    series: [
                        {
                            name: 'Total Fund',
                            type: 'pie',
                            radius: '55%',
                            center: ['50%', '60%'],
                            label:{show:false},
                            data: [
                                {value: drawn, name: 'Drawn'},
                                {value: undrawn, name: 'Undrawn'},
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
                pie.setOption(pie_option);
                pie.hideLoading();
                var mseq_bar_option = {
                    title: {
                        text: 'Invested and Raised',
                        left:'50%',
                        textAlign:'center',
                    },
                    tooltip:{

                    },
                    toolbox: {
                        feature: {
                            saveAsImage: {}
                        }
                    },
                    xAxis: {
                        data: ["MSEQ Invested","Total Capital Raised",],
                    },
                    yAxis: {},
                    series: [{
                        name: 'Value',
                        type: 'bar',
                        barWidth:40,
                        data: bar_data,
                        itemStyle:{
                            normal:{
                                color: function(params) {
                                    var colorList = ['rgb(173,139,46)', 'rgb(0, 49, 60)'];
                                    return colorList[params.dataIndex]
                                }
                            }
                        },
                    }]
                };
                mseq_bar.setOption(mseq_bar_option);
                mseq_bar.hideLoading();


            },
            error: function(){
                console.log("No,something wrong.");
            }
        });
    }());


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

})