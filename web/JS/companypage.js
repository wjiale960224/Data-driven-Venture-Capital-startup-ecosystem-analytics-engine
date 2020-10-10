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
                console.log(companypage_info);
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

})