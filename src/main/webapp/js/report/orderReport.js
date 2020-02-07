$(function () {
    var myChart = echarts.init(document.getElementById('report'));

    alert(0)
    $.ajax({
        url: $('#basePath').val() + '/reports/getParam',
        type: 'GET',
        success: function (data) {
            var option = {
                title: {
                    text: '商户类别订单数'
                },
                tooltip: {
                    trigger: 'axis'
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                toolbox: {
                    feature: {
                        //开启保存图片选项
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false
                },
                yAxis: {
                    type: 'value'
                }
            };
            $.extend(true, option, data);   //深拷贝合并数据
            console.log(option);
            myChart.setOption(option);
        }
    });
});