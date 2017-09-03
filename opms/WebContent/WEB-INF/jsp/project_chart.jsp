<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
    <style>
        /* Code tidied up by ScrapBook */
        .pie-chart { width: 620px; height: 400px; }
        @media screen and (max-width: 768px) {
            .pie-chart { width: 384px; height: 430px; }
        }
    </style>
</head>
<body class="sticky-header">
<section>
          <div class="left-side sticky-left-side" style="overflow: hidden;" tabindex="5000">
        <div class="logo">
            <a href="#">
                <img src="<%=request.getContextPath()%>/img/logo-left.png" alt="OPMS管理系统">
            </a>
        </div>
        <div class="logo-icon text-center">
            <a href="#">
                <img src="<%=request.getContextPath()%>/img/logo_icon.png" style="width: 40px;" alt="OPMS管理系统">
            </a>
        </div>
        <div class="left-side-inner">
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="libai" src="<%=request.getContextPath()%>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" class="media-object">
                    <div class="media-body">
                        <h4>
                            <a href="">${sessionScope.user.username}</a>
                        </h4>
                        <span>OPMS系统</span>
                    </div>
                </div>
                <h5 class="left-nav-title">控制台</h5>
                <ul class="nav nav-pills nav-stacked custom-nav">
                    <li>
                        <a href="">
                            <i class="fa fa-user"></i>
                            <span>个人设置</span>
                        </a>
                    </li>
                    <li>
                        <a href="tologout">
                            <i class="fa fa-sign-out"></i>
                            <span>退出</span></a>
                    </li>
                </ul>
            </div>

            <ul class="nav nav-pills nav-stacked custom-nav js-left-nav">
                <li class="">
                    <a href="#">
                        <i class="fa fa-home"></i>
                        <span>我的主页</span>
                    </a>
                </li>
                <li class="">
                    <a href="listProjectInfo">
                        <i class="fa fa-book"></i>
                        <span>项目管理</span>
                    </a>
                </li>
                <li>
                    <a href="listCheckworkbyuserid">
                        <i class="fa fa-tasks"></i>
                        <span>考勤管理</span>
                    </a>
                </li>
                <li>
                    <a href="approvalindex">
                        <i class="fa fa-suitcase"></i>
                        <span>审批管理</span>
                    </a>
                </li>
                <li>
                    <a href="all_knowledge_manage">
                        <i class="fa fa-tasks"></i>
                        <span>知识分享</span>
                    </a>
                </li>
                <li>
                    <a href="listAlbums">
                        <i class="fa fa-plane"></i>
                        <span>员工相册</span>
                    </a>
                </li>
                <li>
                    <a href="listResumes">
                        <i class="fa fa-laptop"></i>
                        <span>简历管理</span>
                    </a>
                </li>
                <li>
                    <a href="listPmsUsersProfile">
                        <i class="fa fa-user"></i>
                        <span>组织管理</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-content">
        <div class="header-section">
            <a class="toggle-btn"><i class="fa fa-bars"></i></a>
            <div class="menu-right">
                <ul class="notification-menu">
                    <li>
                        <a href="#" class="btn btn-default dropdown-toggle info-number" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-head pull-right">
                            <h5 class="title">你有 0 最新信息</h5>
                            <ul class="dropdown-list normal-list">
                                <li class="text-center">目前还没有最新消息</li>
                                <li class="new">
                                    <a href="">查看更多</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="<%=request.getContextPath()%>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
                            ${user.username}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li>
                                <a href="">
                                    <i class="fa fa-user"></i>
                                    个人主页
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="fa fa-cog"></i>
                                    基本资料
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="fa fa-camera"></i>
                                    更换头像
                                </a>
                            </li>
                            <li>
                                <a href="profilePwd">
                                    <i class="fa fa-cog"></i>
                                    更换密码
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <i class="fa fa-th-list"></i>
                                    我的任务</a>
                            </li>
                            <li>
                                <a href="tologout">
                                    <i class="fa fa-sign-out"></i>
                                    退出
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <div class="page-heading">
            <h3> 项目管理 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="">OPMS</a> </li>
                <li> <a href="">testkin1</a> </li>
                <li class="active"> 报表 </li>
            </ul>
            <div class="pull-right">
                <a href="" class="btn btn-success">团队</a>
                <a href="" class="btn btn-success">需求</a>
                <a href="" class="btn btn-success">任务</a>
                <a href="" class="btn btn-success">Bug</a>
                <a href="#" class="btn btn-warning">报表</a>
            </div>
        </div>
        <div class="clearfix"></div>


        <div class="wrapper">
            <div class="row">
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目成员职称比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTeam" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796318"><div style="position: relative; overflow: hidden; width: 620px; height: 400px; cursor: default;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div style="position: absolute; display: none; border-style: solid; white-space: nowrap; z-index: 9999999; transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s, top 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s; background-color: rgba(50, 50, 50, 0.7); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); font: 14px/21px Microsoft YaHei; padding: 5px; left: 371px; top: 246.5px;">职称比例 <br>主管 : 1 (50%)</div></div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目需求接受人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartNeedsAccept" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796319"><div style="position: relative; overflow: hidden; width: 620px; height: 400px; cursor: default;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目需求创建人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartNeedsUser" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796320"><div style="position: relative; overflow: hidden; width: 620px; height: 400px; cursor: default;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>

                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目需求来源比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartNeedsSource" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796321"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>

                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目任务接受人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTasksAccept" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796322"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目任务创建人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTasksUser" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796323"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>

                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目任务完成人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTasksComplete" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796324"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>

                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目任务类型比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTasksSource" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796325"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>


                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目Bug接受人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTestsAccept" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796326"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目Bug创建人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTestsUser" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796327"><div style="position: relative; overflow: hidden; width: 620px; height: 400px;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>

                <div class="col-sm-6">
                    <section class="panel">
                        <header class="panel-heading">
                            项目Bug完成人比例
                            <span class="tools pull-right">
                            <a href="javascript:;" class="fa fa-chevron-down"></a>
                            <a href="javascript:;" class="fa fa-times"></a>
                         </span>
                        </header>
                        <div class="panel-body">
                            <div id="chartTestsComplete" class="pie-chart" style="-moz-user-select: none; position: relative; background: transparent none repeat scroll 0% 0%;" _echarts_instance_="ec_1499939796328"><div style="position: relative; overflow: hidden; width: 620px; height: 400px; cursor: default;"><canvas style="position: absolute; left: 0px; top: 0px; width: 620px; height: 400px; -moz-user-select: none;" width="620" height="400" data-zr-dom-id="zr_0"></canvas></div><div></div></div>
                        </div>
                    </section>
                </div>


            </div>
        </div>


        <footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="http://opms.milu365.cn/">OPMS官网</a> · <a href="http://opms.docs.milu365.cn/">OPMS手册</a></footer>

    </div>

</section>

<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.nicescroll.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
<div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;">
    <div style="position: relative; top: 0px; float: right; width: 6px; height: 404px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; height: 6px; width: 1366px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; left: 137px; height: 636px; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; top: 633px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px; left: 0px;"></div>
</div>
<script src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/js/opms.js"></script>
<script src="<%=request.getContextPath()%>/js/echarts.common.min.js"></script>
<script>
    $(function(){
        var workday = workDay("2017-07-11","2017-07-11");
        var json = <%=request.getAttribute("jsonString") %>
        
        $('.js-workday').text(workday+'天');
        option = {
            title : {
                text: '项目团队人员',
                subtext: '职称比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [
                    "主管",
                    "部门经理",
                    "组长" 
                ]
            },
            series : [
                {
                    name: '职称比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value: 3 , name:"主管"},
                        {value: 2 , name:"部门经理"},
                        {value: 2 , name:"组长"}
                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTeam = echarts.init(document.getElementById('chartTeam'));
        chartTeam.setOption(option);
        /* option.legend.data = .legendData
        option.series[0].data = 你的.seriseData; */


        option = {
            title : {
                text: '项目需求指派人',
                subtext: '需求指派比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                    

                ]
            },
            series : [
                {
                    name: '需求指派比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 1, name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartNeedsAccept = echarts.init(document.getElementById('chartNeedsAccept'));
        chartNeedsAccept.setOption(option);

        option = {
            title : {
                text: '项目需求创建人',
                subtext: '需求创建人比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                ]
            },
            series : [
                {
                    name: '需求创建人比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 1 , name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartNeedsUser = echarts.init(document.getElementById('chartNeedsUser'));
        chartNeedsUser.setOption(option);

        option = {
            title : {
                text: '项目需求来源',
                subtext: '需求来源比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "客户"

                ]
            },
            series : [
                {
                    name: '需求来源比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 1 , name:"客户"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartNeedsSource = echarts.init(document.getElementById('chartNeedsSource'));
        chartNeedsSource.setOption(option);


        option = {
            title : {
                text: '项目任务指派人',
                subtext: '任务指派比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                ]
            },
            series : [
                {
                    name: '任务指派比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 2 , name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTasksAccept = echarts.init(document.getElementById('chartTasksAccept'));
        chartTasksAccept.setOption(option);

        option = {
            title : {
                text: '项目任务创建人',
                subtext: '任务创建人比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                ]
            },
            series : [
                {
                    name: '任务创建人比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 2 , name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTasksUser = echarts.init(document.getElementById('chartTasksUser'));
        chartTasksUser.setOption(option);

        option = {
            title : {
                text: '项目任务完成人',
                subtext: '任务完成人比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                ]
            },
            series : [
                {
                    name: '任务完成人比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTasksComplete = echarts.init(document.getElementById('chartTasksComplete'));
        chartTasksComplete.setOption(option);

        option = {
            title : {
                text: '项目任务类型',
                subtext: '任务类型比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "开发"

                ]
            },
            series : [
                {
                    name: '任务类型比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 2 , name:"开发"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTasksSource = echarts.init(document.getElementById('chartTasksSource'));
        chartTasksSource.setOption(option);


        option = {
            title : {
                text: '项目Bug指派人',
                subtext: 'Bug指派比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                ]
            },
            series : [
                {
                    name: 'Bug指派比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 1 , name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTestsAccept = echarts.init(document.getElementById('chartTestsAccept'));
        chartTestsAccept.setOption(option);

        option = {
            title : {
                text: '项目Bug创建人',
                subtext: 'Bug创建人比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                    "李白"

                ]
            },
            series : [
                {
                    name: 'Bug创建人比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                        {value: 1 , name:"李白"}

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTestsUser = echarts.init(document.getElementById('chartTestsUser'));
        chartTestsUser.setOption(option);

        option = {
            title : {
                text: '项目Bug完成人',
                subtext: 'Bug完成人比例',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: [

                ]
            },
            series : [
                {
                    name: 'Bug完成人比例',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[

                    ],
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        var chartTestsComplete = echarts.init(document.getElementById('chartTestsComplete'));
        chartTestsComplete.setOption(option);

    });
</script>


</body>
</html>
    