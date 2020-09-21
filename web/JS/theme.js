$(function() {
    $("#EM").click(function () {
        var myChart_invest = echarts.init(document.querySelector("#MSEQ_investment"));
        var option_invest = {
            title: {
                text: 'MSEQ Investment',
                left: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: '{a} <br/>{b} : {c} ({d}%)'
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: ['company1', 'company2', 'company3', 'company4', 'company5']
            },
            series: [
                {
                    name: 'total investment',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    label:{show:false},
                    data: [
                        {value: 1.4, name: 'company1'},
                        {value: 2.1, name: 'company2'},
                        {value: 1.6, name: 'company3'},
                        {value: 0.5, name: 'company4'},
                        {value: 0.7, name: 'company5'}
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
        myChart_invest.setOption(option_invest);
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
                data: ['company1', 'company2', 'company3', 'company4', 'company5']
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
                data: ['date1','date2','date3','date4','date5','date6']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    name: 'company1',
                    type: 'line',
                    data: [1.2, 1.5, 1.8, 2.1, 2.2, 2.4]
                },
                {
                    name: 'company2',
                    type: 'line',
                    data: [0.7, 1.3, 1.5, 2.1, 1.6, 1.3]
                },
                {
                    name: 'company3',
                    type: 'line',
                    data: [1.0, 1.3, 1.8, 2.0, 2.6, 3.4]
                },
                {
                    name: 'company4',
                    type: 'line',
                    data: [1.0, 1.6, 2.8, 3.1, 3.2, 3.6]
                },
                {
                    name: 'company5',
                    type: 'line',
                    data: [1.2, 1.3, 1.4, 2.3, 2.6, 2.4]
                }
            ]
        };
        myChart_post.setOption(option_valuation);

        var myChart_bar = echarts.init(document.querySelector("#bar_chart"));
        var option_bar = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow'
                }
            },
            legend: {
                data: ['deal1', 'deal2', 'deal3', 'deal4', 'future']
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
                data: ['company1', 'company2', 'company3', 'company4', 'company5',]
            },
            series: [
                {
                    name: 'deal1',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'insideRight'
                    },
                    data: [1.3, 2.1, 1.4,1.7,1.2]
                },
                {
                    name: 'deal2',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'insideRight'
                    },
                    data: [2.1, 1.2, 1.4]
                },
                {
                    name: 'deal3',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'insideRight'
                    },
                    data: [2.4,1.5,1.0]
                },
                {
                    name: 'deal4',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'insideRight'
                    },
                    data: [1.6,1.7]
                },
                {
                    name: 'future',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        show: true,
                        position: 'insideRight'
                    },
                    data: [1.1, 0.8, 1.4, 1.4, 2.4]
                }
            ]
        };
        myChart_bar.setOption(option_bar);
    })
})