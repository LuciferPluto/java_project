
function showCharts1() {

    var barChart1 = echarts.init(document.getElementById("echarts-bar-chart1"));
    var baroption1 = {
        title : {
            text: '车辆数量统计'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['汽油车','纯电动','天然气','混合动力' , '其它']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['2020-04','2020-05','2020-06','2020-07','2020-08','2020-09']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            //data:['汽油车','纯电动','天然气','混合动力' , '其它']
            {
                name:'汽油车',
                type:'bar',
                data:[160065, 160065, 160065,157790,157659,157616]
            },
            {
                name:'纯电动',
                type:'bar',
                data:[1048, 1048, 1048,1048,1051,1051]
            },
            {
                name:'天然气',
                type:'bar',
                data:[2, 2, 2,2,2,2]
            },
            {
                name:'混合动力',
                type:'bar',
                data:[859, 859, 859,822,835,843]
            },
            {
                name:'混合动力',
                type:'bar',
                data:[57981, 57981, 57981,58607,60365,60926]
            },
        ]
    };
    barChart1.setOption(baroption1);
    window.onresize = barChart1.resize;

}

function showCharts2() {

    var barChart = echarts.init(document.getElementById("echarts-bar-chart2"));
    var baroption = {
        title : {
            text: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['数量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['大众','丰田','宝莱' ,'速腾','本田' , '雅阁','迈腾','现代', '其它']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            //                data : ['大众','丰田','新捷达',本田' , '雅阁','迈腾','现代', '其它']
            {
                name:'数量',
                type:'bar',
                data:[9990, 9975, 7063,4235,3598,3537,3513,3504,164718]
            }
        ]
    };
    barChart.setOption(baroption);
    window.onresize = barChart.resize;
}

function showCharts3() {
    var barChart = echarts.init(document.getElementById("echarts-bar-chart3"));
    var baroption = {
        title : {
            text: ''
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['数量']
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                data : ['1年以下','1-2年','2-3年','3-4年' ,'4年以上']
            }
        ],
        yAxis : [
            {
                type : 'value'
            }
        ],
        series : [
            //                data : ['大众','丰田','新捷达','宝莱' ,'速腾','本田' , '雅阁','迈腾','现代', '其它']
            {
                name:'数量',
                type:'bar',
                data:[2636, 5858, 40115,142316,29388]
            }
        ]
    };
    barChart.setOption(baroption);
    window.onresize = barChart.resize;
}

$(function () {
    $.getJSON('/echarts/pie',function(lineoption){
        var lineChart = echarts.init(document.getElementById("echarts-line-chart"));
        lineChart.setOption(lineoption);
        $(window).resize(lineChart.resize);
    })
    showCharts1();
    showCharts2();
    showCharts3();
});

