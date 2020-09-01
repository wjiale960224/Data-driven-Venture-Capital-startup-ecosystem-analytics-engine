(function (){
    var myChart = echarts.init(document.querySelector(".change"));
    var option = {
        title: {
            text: 'CompanyA current valuation change'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            type: 'category',
            data: ['deal1', 'deal2', 'deal3', 'deal4', 'deal5',]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [1.0, 2.2, 2.1, 1.8, 2.3,],
            type: 'line',
            smooth: true
        }]
    };
    myChart.setOption(option);
})();

(function (){
    var myChart = echarts.init(document.querySelector(".bar"));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['pre-value', 'post-value', 'pre-value'],
            left: 10,
        },
        xAxis: [
            {
                type: 'category',
                data: ['deal1', 'deal2', 'deal3', 'deal4',],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: 'value',
                min: 0,
                max: 8,
                interval: 1,
                axisLabel: {
                    formatter: '{value} M'
                }
            },
            {
                type: 'value',
                name: 'value',
                min: 0,
                max: 8,
                interval: 1,
                axisLabel: {
                    formatter: '{value} M'
                }
            }
        ],
        series: [
            {
                name: 'pre-value',
                type: 'bar',
                data: [1.2, 1.5, 1.8, 2.4, 2,]
            },
            {
                name: 'post-value',
                type: 'bar',
                data: [2.1, 2.0, 3.4, 4.1, 5.7]
            },
            {
                name: 'current-value',
                type: 'line',
                yAxisIndex: 1,
                data: [2.0, 2.2, 3.3, 4.5, 6.3,]
            }
        ]
    };
    myChart.setOption(option);
})();

(function (){
    var myChart = echarts.init(document.querySelector(".line"));
    var option = {
        title: {
            text: 'MSVC Investment',
            left: 'center',
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 10,
            data: ['MSVC', 'Other',]
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
                    {value: 8, name: 'MSVC'},
                    {value: 21, name: 'Other'},
                ]
            }
        ]
    };

    myChart.setOption(option);
})();
