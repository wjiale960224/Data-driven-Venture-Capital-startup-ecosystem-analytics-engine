$(function (){
    (function refresh(){
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/companypageinfo",  // Here to change back end receive url.
            data: {
                refresh: "[]",
            },
            success:function(companypage_info){
                console.log("yes,refreshed.");
                // console.log(companypage_info);
                var symbols = new Array();
                symbols.push("CompanyInfo");
                symbols.push("DealInfo");
                var map = get_infos(symbols,companypage_info);
                var com_infos = split_string(map.get("CompanyInfo"));
                var deal_infos = split_string(map.get("DealInfo"));

                var companies = [];
                for (var i = 0; i < com_infos.length; i++){
                    companies[i] = JSON.parse(com_infos[i]);
                }

                for (i = 0; i < companies.length; i++){
                    if (companies[i]["theme"] === "Exponential_Machines"){
                        $(".EMclass").append("<li>" + companies[i]["company_name"] + "</li>");

                    }else if (companies[i]["theme"] === "Feeding_10B_People"){
                        $(".FPclass").append("<li>" + companies[i]["company_name"] + "</li>");

                    }else if (companies[i]["theme"] === "Humanity_Scale_Healthcare"){
                        $(".HSHclass").append("<li>" + companies[i]["company_name"] + "</li>");

                    }else if (companies[i]["theme"] === "New_Society"){
                        $(".NSclass").append("<li>" + companies[i]["company_name"] + "</li>");

                    }else if (companies[i]["theme"] === "Space_Transport"){
                        $(".STclass").append("<li>" + companies[i]["company_name"] + "</li>");

                    }
                }

                var j = -1;
                for (i = 0; i < $(".EMclass>li").length; i++){
                    j = i+1;
                    $(".EMclass>li:nth-child(" + j + ")").click(function(e){

                        e.stopPropagation();
                    });
                }
                for (i = 0; i < $(".FPclass>li").length; i++){
                    j = i+1;
                    $(".FPclass>li:nth-child(" + j + ")").click(function(e){
                        e.stopPropagation();
                    });
                }
                for (i = 0; i < $(".HSHclass>li").length; i++){
                    j = i+1;
                    $(".HSHclass>li:nth-child(" + j + ")").click(function(e){
                        e.stopPropagation();
                    });
                }
                for (i = 0; i < $(".NSclass>li").length; i++){
                    j = i+1;
                    $(".NSclass>li:nth-child(" + j + ")").click(function(e){
                        e.stopPropagation();
                    });
                }
                for (i = 0; i < $(".STclass>li").length; i++){
                    j = i+1;
                    $(".STclass>li:nth-child(" + j + ")").click(function(e){
                        e.stopPropagation();
                    });
                }

/*
                var $subs = $(".sub>li");
                console.log($subs);
                for (i = 0; i < $subs.length; i++){
                    console.log($subs[i]);

                    $subs[i].click = function(e){
                        e.stopPropagation();
                    };
                }*/

            },
            error: function(){
                console.log("No,something wrong.");
            }
        });
    }());



    var bar_chart = echarts.init(document.querySelector("#bar_chart"));
    var bar_chart_option = {
        color: ['rgb(173,139,46)'],
        title: {
          left: 'center',
          text: 'Deal Size'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'line'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: [
            {
                type: 'category',
                data: ['Deal1', 'Deal2', 'Deal3', 'Deal4',],
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: 'Deal Size',
                type: 'bar',
                barWidth: '60%',
                data: [0.7, 1.1, 2.2, 1.3,]
            }
        ]
    };
    bar_chart.setOption(bar_chart_option);

    var line_chart = echarts.init(document.querySelector("#line_chart"));
    var line_chart_option = {
        title: {
            left: 'center',
            text: 'Post-Valuation Change'
        },
        tooltip: {
            trigger: 'axis',
        },
        xAxis: {
            type: 'category',
            data: ['deal1', 'deal2', 'deal3', 'deal4',]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            name: "Valuation",
            data: [1.1, 1.3, 1.6, 2.1,],
            type: 'line'
        }]
    };
    line_chart.setOption(line_chart_option);

    var pie_chart = echarts.init(document.querySelector("#pie_chart"));
    var pie_chart_option  = {
        title: {
            text: 'MSEQ Investment',
            left: 'center',
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 10,
            data: ['MSEQ', 'Other',]
        },
        series: [
            {
                name: 'Investment',
                type: 'pie',
                radius: ['30%', '50%'],
                avoidLabelOverlap: false,
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '15',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: [
                    {value: 8, name: 'MSEQ'},
                    {value: 21, name: 'Other'},
                ]
            }
        ]
    };
    pie_chart.setOption(pie_chart_option);

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