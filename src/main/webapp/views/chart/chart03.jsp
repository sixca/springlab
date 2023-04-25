<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--3번 데이터를 가져와서, 각각 데이터를 뿌려줘보자--%>
<style>
    #c1,#c2,#c3 {
        /*width:20%;*/
        /*height:300px;*/
        /*border:2px solid blue;*/
        /*margin: 0 10px;*/
    }
</style>

<script>
    let chart03 = {
        init:function (){
            this.getdata1();
            this.getdata2();
            this.getdata3();
        },
        getdata1:function (){
            $.ajax({
                url: '/chart0301',
                success: function(result){
                    chart03.display1(result);
                }
            })
        },
        getdata2:function (){
            $.ajax({
                url: '/chart0302',
                success: function(result){
                    chart03.display2(result);
                }
            })
        },
        getdata3:function (){
            $.ajax({
                url: '/chart0303',
                success: function(result){
                    chart03.display3(result);
                }
            })
        },
        display1:function (result){    //https://www.highcharts.com/demo/3d-pie-donut
            Highcharts.chart('c1', {
                chart: {
                    type: 'pie',
                    options3d: {
                        enabled: true,
                        alpha: 45
                    }
                },
                title: {
                    text: 'Beijing 2022 gold medals by country',
                    align: 'left'
                },
                subtitle: {
                    text: '3D donut in Highcharts',
                    align: 'left'
                },
                plotOptions: {
                    pie: {
                        innerSize: 100,
                        depth: 45
                    }
                },
                series: [{
                    name: 'Medals',
                    data: result
                }]
            });
        },
        display2:function (result){
            Highcharts.chart('c2', {
                chart: {
                    type: 'area',
                    options3d: {
                        enabled: true,
                        alpha: 15,
                        beta: 30,
                        depth: 200
                    }
                },
                title: {
                    text: 'Visual comparison of Mountains Panorama'
                },
                accessibility: {
                    description: 'The chart is showing the shapes of three mountain ranges as three area line series laid out in 3D behind each other.',
                    keyboardNavigation: {
                        seriesNavigation: {
                            mode: 'serialize'
                        }
                    }
                },
                lang: {
                    accessibility: {
                        axis: {
                            xAxisDescriptionPlural: 'The chart has 3 unlabelled X axes, one for each series.'
                        }
                    }
                },
                yAxis: {
                    title: {
                        text: 'Height Above Sea Level',
                        x: -40
                    },
                    labels: {
                        format: '{value:,.0f} MAMSL'
                    },
                    gridLineDashStyle: 'Dash'
                },
                xAxis: [{
                    visible: false
                }, {
                    visible: false
                }, {
                    visible: false
                }],
                plotOptions: {
                    area: {
                        depth: 100,
                        marker: {
                            enabled: false
                        },
                        states: {
                            inactive: {
                                enabled: false
                            }
                        }
                    }
                },
                tooltip: {
                    valueSuffix: ' MAMSL'
                },
                series: [{
                    name: 'Tatra Mountains visible from Rusinowa polana',
                    lineColor: 'rgb(180,90,50)',
                    color: 'rgb(200,110,50)',
                    fillColor: 'rgb(200,110,50)',
                    data: result[0]
                }, {
                    xAxis: 1,
                    lineColor: 'rgb(120,160,180)',
                    color: 'rgb(140,180,200)',
                    fillColor: 'rgb(140,180,200)',
                    name: 'Dachstein panorama seen from Krippenstein',
                    data: result[1]
                }, {
                    xAxis: 2,
                    lineColor: 'rgb(200, 190, 140)',
                    color: 'rgb(200, 190, 140)',
                    fillColor: 'rgb(230, 220, 180)',
                    name: 'Panorama from Col Des Mines',
                    data: result[2]
                }]
            });

        },
        display3:function (result){
            const chart = new Highcharts.Chart({
                chart: {
                    renderTo: 'c3',
                    type: 'column',
                    options3d: {
                        enabled: true,
                        alpha: 15,
                        beta: 15,
                        depth: 50,
                        viewDistance: 25
                    }
                },
                xAxis: {
                    categories: ['Toyota', 'BMW', 'Volvo', 'Audi', 'Peugeot', 'Mercedes-Benz',
                        'Volkswagen', 'Polestar', 'Kia', 'Nissan']
                },
                yAxis: {
                    title: {
                        enabled: false
                    }
                },
                tooltip: {
                    headerFormat: '<b>{point.key}</b><br>',
                    pointFormat: 'Cars sold: {point.y}'
                },
                title: {
                    text: 'Sold passenger cars in Norway by brand, January 2021',
                    align: 'left'
                },
                subtitle: {
                    text: 'Source: ' +
                        '<a href="https://ofv.no/registreringsstatistikk"' +
                        'target="_blank">OFV</a>',
                    align: 'left'
                },
                legend: {
                    enabled: false
                },
                plotOptions: {
                    column: {
                        depth: 25
                    }
                },
                series: [{
                    data: result.datas,
                    colorByPoint: true
                }]
            });

            function showValues() {
                document.getElementById('alpha-value').innerHTML = chart.options.chart.options3d.alpha;
                document.getElementById('beta-value').innerHTML = chart.options.chart.options3d.beta;
                document.getElementById('depth-value').innerHTML = chart.options.chart.options3d.depth;
            }

        // Activate the sliders
            document.querySelectorAll('#sliders input').forEach(input => input.addEventListener('input', e => {
                chart.options.chart.options3d[e.target.id] = parseFloat(e.target.value);
                showValues();
                chart.redraw(false);
            }));

            showValues();

        }
    };

    $(function (){
        chart03.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <h3>CHART03</h3>
        <div class="row">
            <div class="col-sm-4" id="c1"></div>
            <div class="col-sm-4" id="c2"></div>
            <div class="col-sm-4" id="c3"></div>
        </div>
    </div>
</div>
