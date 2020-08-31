(function (){
    var myChart = echarts.init(document.querySelector(".panel_second"));
    var option = {
        title: {
            text: 'Investment'
        },
        tooltip: {},
        legend: {
            data:['value']
        },
        xAxis: {
            data: ["deal 1","deal 2","deal 3","deal 4","deal 5","deal 6"]
        },
        yAxis: {},
        series: [{
            name: 'value',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };
    myChart.setOption(option);
})();

(function (){
    var myChart = echarts.init(document.querySelector(".column .panel_third"));
    var option = {
        title: {
            text: 'Timeline'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['Company1', 'Company1', 'Company2', 'Company3', 'Company4']
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
            data: ['01/08', '12/08', '04/09', '21/10', '01/11', '07/12', '30/12']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: 'Company1',
                type: 'line',
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: 'Company2',
                type: 'line',
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: 'Company3',
                type: 'line',
                data: [150, 232, 201, 154, 190, 330, 410]
            },
            {
                name: 'Company4',
                type: 'line',
                data: [320, 332, 301, 334, 390, 330, 320]
            },
            {
                name: 'Company5',
                type: 'line',
                data: [820, 932, 901, 934, 1290, 1330, 1320]
            }
        ]
    };
    myChart.setOption(option);
})();

(function (){
    var myChart = echarts.init(document.querySelector(".panel_pie2"));
    var option = {
        title: {
            text: 'Investment',
            left: 'center',
            top: 20,
        },

        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },

        visualMap: {
            show: false,
            min: 80,
            max: 600,
            inRange: {
                colorLightness: [0, 1]
            }
        },
        series: [
            {
                name: 'Value',
                type: 'pie',
                radius: '55%',
                center: ['50%', '50%'],
                data: [
                    {value: 335, name: 'Company1'},
                    {value: 310, name: 'Company2'},
                    {value: 274, name: 'Company3'},
                    {value: 235, name: 'Company4'},
                    {value: 400, name: 'Company5'}
                ].sort(function (a, b) { return a.value - b.value; }),
                roseType: 'radius',
                label: {
                    color: 'rgba(0, 0, 0, 0.3)'
                },
                labelLine: {
                    lineStyle: {
                        color: 'rgba(0, 0, 0, 0.3)'
                    },
                    smooth: 0.2,
                    length: 10,
                    length2: 20
                },
                itemStyle: {
                    color: '#c23531',
                    shadowBlur: 200,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                },

                animationType: 'scale',
                animationEasing: 'elasticOut',
                animationDelay: function (idx) {
                    return Math.random() * 200;
                }
            }
        ]
    };
    myChart.setOption(option);
})();

(function (){
    var myChart = echarts.init(document.querySelector(".panel_pie1"));
    var option = {
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 10,
            data: ['Company1', 'Company2', 'Company3', 'Company4', 'Company5']
        },
        series: [
            {
                name: 'Value',
                type: 'pie',
                radius: ['25%', '45%'],
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
                    {value: 335, name: 'Company1'},
                    {value: 310, name: 'Company2'},
                    {value: 234, name: 'Company3'},
                    {value: 135, name: 'Company4'},
                    {value: 1548, name: 'Company5'}
                ]
            }
        ]
    };
    myChart.setOption(option);
})();



