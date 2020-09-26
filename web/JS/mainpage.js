


$(function (){
    var TVPI_curve = echarts.init(document.querySelector("#TVPI_curve"));
    var TVPI_curve_option = {
        title: {
            text: 'TVPI curve',
            left: 'left'
        },
        tooltip: {
            trigger: 'axis'
        },
        grid: {
            left: '3%',
            right: "20px",
            bottom: '3%',
            width: "730px",
            // height: "100%",
            containLabel: true
        },
        xAxis: {
            type: 'category',
            data: ['0.0', '0.3', '0.6', '0.9', '1.2', '1.5', '1.8','2.1','6'],
            boundaryGap: false
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [0, 0.8, 1.5, 3.8, 6, 6.7, 6, 4, 0],
            type: 'line'
        }]
    };
    TVPI_curve.setOption(TVPI_curve_option);

    var double_pie = echarts.init(document.querySelector("#double_pie"));
    var double_pie_option = {
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        handleColors(){
            let color = '';
            let r=Math.floor(Math.random()*256);
            let g=Math.floor(Math.random()*256);
            let b=Math.floor(Math.random()*256);
            color = `rgb(${r},${g},${b})`;
            return color;
        },

        setEchartColor(){
            for (let i of this.data.data.series) {
                let color = this.actions.handleColors();
                console.log('color',color)
                console.log('i',i)
                i['itemStyle']={color:color}
            }
        },
        series: [
            {
                name: 'theme1',
                type: 'pie',
                selectedMode: 'single',
                radius: [0, '50%'],

                label: {
                    position: 'inner'
                },
                labelLine: {
                    show: false
                },
                data: [
                    {value: 335, name: 'theme1', selected: true},
                    {value: 679, name: 'theme2'},
                    {value: 1548, name: 'theme3'},
                    {value: 469, name: 'theme4'},
                    {value: 518, name: 'theme5'},
                ]
            },
            {
                name: 'MSEQ_overview',
                type: 'pie',
                radius: ['60%', '75%'],
                label: {
                    show:false
                },
                labelLine: {
                    show:false
                },
                data: [
                    {value: 135, name: 'company1'},
                    {value: 200, name: 'company2'},
                    {value: 310, name: 'company3'},
                    {value: 234, name: 'company4'},
                    {value: 135, name: 'company5'},
                    {value: 1048, name: 'company6'},
                    {value: 251, name: 'company7'},
                    {value: 147, name: 'company8'},
                    {value: 102, name: 'company9'},
                    {value: 469, name: 'company10'},
                    {value: 518, name: 'company11'},
                ]
            }
        ]
    };
    double_pie.setOption(double_pie_option);

    var mseq_bar = echarts.init(document.querySelector("#mseq_bar"));
    var mseq_bar_option = {
        title: {
            text: 'Investment and Raised'
        },
        color: ['rgb(173,139,46)'],
        legend: {
            data:['Value']
        },
        xAxis: {
            data: ["MSEQ Invested","Total Capital Raised",]
        },
        yAxis: {},
        series: [{
            name: 'Value',
            type: 'bar',
            barWidth:40,
            data: [5, 20,]
        }]
    };
    mseq_bar.setOption(mseq_bar_option);

    var two_pie = echarts.init(document.querySelector("#two_pie"));
    var two_pie_option  = {
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        series: [
            {
                name: 'Initial Date',
                type: 'pie',
                radius: '35%',
                center: ['50%', '20%'],
                data: [
                    {value: 335, name: 'Series A'},
                    {value: 310, name: 'Series B'},
                    {value: 234, name: 'Series B1'},
                    {value: 135, name: 'None'},
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            },

            {
                name: 'Current Date',
                type: 'pie',
                radius: '35%',
                center: ['50%', '80%'],
                data: [
                    {value: 135, name: 'Series A'},
                    {value: 410, name: 'Series B'},
                    {value: 334, name: 'Series B1'},
                    {value: 35, name: 'None'},
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

    two_pie.setOption(two_pie_option);

})