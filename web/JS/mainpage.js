


$(function (){
    var pie = echarts.init(document.querySelector("#pie"));
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
                    {value: 2.53, name: 'Drawn'},
                    {value: 10, name: 'Undrawn'},
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


    var TVPI_curve = echarts.init(document.querySelector("#TVPI_curve"));
    var TVPI_curve_option = {
        title: {
            text: 'TVPI curve',
            left: '50%',
            textAlign:'center',
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
        xAxis: {
            type: 'category',
            data: ['0.0', '0.3', '0.6', '0.9', '1.2', '1.5', '1.8','2.1'],
            boundaryGap: false,
        },
        yAxis: {
            type: 'value',
        },
        series: [{
            data: [0, 0.8, 1.5, 3.8, 6, 6.7, 6, 4],
            type: 'line',
        }]
    };
    TVPI_curve.setOption(TVPI_curve_option);

    var double_pie = echarts.init(document.querySelector("#double_pie"));
    var double_pie_option = {
        title: {
            text: 'Overview % of Fund',
            left:'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },
        series: [
            {
                name: 'theme',
                type: 'pie',
                radius: [0, '70%'],

                label: {
                    position: 'inner'
                },
                labelLine: {
                    show: false
                },
                data: [
                    {value: 335, name: 'theme1'},
                    {value: 679, name: 'theme2'},
                    {value: 1548, name: 'theme3'},
                    {value: 469, name: 'theme4'},
                    {value: 518, name: 'theme5'},
                ],
                itemStyle:{
                    normal:{
                        color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
                    }
                },
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
                ],
                itemStyle:{
                    normal:{
                        color:function(d){return "#"+Math.floor(Math.random()*(256*256*256-1)).toString(16);}
                    }
                },
            }
        ]
    };
    double_pie.setOption(double_pie_option);

    var mseq_bar = echarts.init(document.querySelector("#mseq_bar"));
    var mseq_bar_option = {
        title: {
            text: 'Invested and Raised',
            left:'50%',
            textAlign:'center',
        },
        tooltip:{

        },
        xAxis: {
            data: ["MSEQ Invested","Total Capital Raised",],
        },
        yAxis: {},
        series: [{
            name: 'Value',
            type: 'bar',
            barWidth:40,
            data: [5, 20,],
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





    (function refresh(){
        var company_name = [];
        var fund = [];
        $.ajax({
            type: "POST",
            url: "/workspace_Intellj_war_exploded/mainpagedata",  // Here to change back end receive url.
            data: {
                refresh: "[]",
            },
            success:function(mainpage_info){
                console.log("yes,refreshed.");
                console.log(mainpage_info);
                var mainpagedata = mainpage_info.substring(1,mainpage_info.length-1).split("},{");
                for (i = 0; i < mainpagedata.length; i++){ // Get rid of [] and split each item up.
                    if (i === 0) {
                        mainpagedata[i] += "}";
                    }else if (i === mainpagedata.length-1){
                        mainpagedata[i] = "{" + mainpagedata[i];
                    }else {
                        mainpagedata[i] = "{" + mainpagedata[i] + "}";
                    }
                }
                for (i = 0; i < mainpagedata.length; i++){ // Reconstruct string format to object format
                    console.log(mainpagedata[i]);
                    var $mainpagedata = JSON.parse(mainpagedata[i]);
                    company_name.push($mainpagedata["company_name"]);
                    fund.push($mainpagedata["fund"]);
                }
                var two_pie = echarts.init(document.querySelector("#two_pie"));
                var two_pie_option  = {
                    title:[
                        {
                            text: 'Current Date',
                            left:'50%',
                            textAlign:'center',
                        },

                        {
                            text: 'Initial Date',
                            left:'50%',
                            top: '52.5%',
                            textAlign:'center'
                        }
                    ],
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        data: company_name
                    },
                    series: [
                        {
                            name: 'Current Date',
                            type: 'pie',
                            radius: '35%',
                            center: ['50%', '30%'],
                            data: fund,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        },

                        {
                            name: 'Initial Date',
                            type: 'pie',
                            radius: '35%',
                            center: ['50%', '80%'],
                            data: [],
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
            },
            error: function(){
                console.log("No,something wrong.");
            }
        });
    }());

})