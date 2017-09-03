<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow: hidden;" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <style>
        /* Code tidied up by ScrapBook */
        .panel-body .table tbody > tr > td { text-align: left; padding: 12px; }
    </style>
</head>
<body class="sticky-header">
<section>
         <div class="left-side sticky-left-side" style="overflow: hidden;" tabindex="5000">
        <div class="logo">
            <a href="#">
                <img src="img/logo-left.png" alt="OPMS管理系统">
            </a>
        </div>
        <div class="logo-icon text-center">
            <a href="#">
                <img src="img/logo_icon.png" style="width: 40px;" alt="OPMS管理系统">
            </a>
        </div>
        <div class="left-side-inner">
            <div class="visible-xs hidden-sm hidden-md hidden-lg">
                <div class="media logged-user">
                    <img alt="libai" src="img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" class="media-object">
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
                                    <a href="message_manage.html">查看更多</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
                            ${user.username }
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li>
                                <a href="user_index.html">
                                    <i class="fa fa-user"></i>
                                    个人主页
                                </a>
                            </li>
                            <li>
                                <a href="user_form.html">
                                    <i class="fa fa-cog"></i>
                                    基本资料
                                </a>
                            </li>
                            <li>
                                <a href="avatar.html">
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
                                <a href="task.html">
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
            <h3> 审批管理
                <span>
                    <a href="leavemanage">请假</a>
                    <a href="overtimemanage">加班</a>
                    <a href="expensemanage">报销</a>
                    <a href="businesstripmanage">出差</a>
                    <a href="gooutmanage">外出</a>
                    <a href="oagood_manage">物品</a>
                </span>
            </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="user_index.html">OPMS</a> </li>
                <li> <a href="approvalindex">审批管理</a> </li>
                <li class="active"> 加班单详情 </li>
            </ul>
            <div class="pull-right">
                <a href="javascript:history.back();" class="btn btn-default">返回</a>
                <a href="approvalovertime" class="hidden-xs btn btn-default" style="padding: 4px;">待审批</a>
                <a href="addovertimemanage" class="btn btn-success">+我要加班</a> </div>
        </div>
        <div class="clearfix"></div>


        <div class="wrapper">
            <div class="row">
                <div class="col-md-8">
                    <div class="blog">
                        <div class="single-blog">
                            <div class="panel">
                                <div class="panel-body">
                                    <h1 class="text-center mtop35"><a href="#">加班单</a>
                                        <button onclick="myPrint(document.getElementById('print'))" class="pull-right btn">打 印</button>
                                    </h1>
                                    <p class="text-center auth-row"> By <a href="http://opms.demo.milu365.cn/user/show/1461312703628858832">李白</a> |<fmt:formatDate value="${oneOvertime.created }" type="Date" pattern="yyyy-MM-dd hh:mm" /> 2017-07-09 20:30</p>
                                    <div id="print">
                                        <table class="table table-bordered" border="1">
                                            <tbody><tr class="hide">
                                                <th colspan="6" class="text-center">加班单</th>
                                            </tr>
                                            <tr>
                                                <td width="72">姓名</td>
                                                <td width="62">李白</td>
                                                <td width="70">部门</td>
                                                <td width="77">行政部</td>
                                                <td width="80">职位</td>
                                                <td width="93">部门经理</td>
                                            </tr>
                                            <tr>
                                                <td>核算方式</td>
                                                <td colspan="5"><c:if test="${oneOvertime.way==1 }">调休</c:if>
											<c:if test="${oneOvertime.way==2 }">加班</c:if></td>
                                            </tr>
                                            <tr>
                                                <td>法定假日</td>
                                                <td colspan="5"><c:if test="${oneOvertime.holiday==1 }">是</c:if> <c:if test="${oneOvertime.holiday==2}">否</c:if></td>
                                            </tr>
                                            <tr>
                                                <td>事由</td>
                                                <td colspan="5">${oneOvertime.reason }</td>
                                            </tr>
                                            <tr>
                                                <td>加班日期</td>
                                                <td colspan="5"> ${oneOvertime.started }至${oneOvertime.ended }
<%--                                                 <fmt:formatDate --%>
<%-- 												value="${oneOvertime.started }" type="Date" --%>
<%-- 												pattern="yyyy-MM-dd hh:mm" /> 至<fmt:formatDate --%>
<%-- 												value="${oneOvertime.ended }" type="Date" --%>
<%-- 												pattern="yyyy-MM-dd hh:mm" /> --%>
												</td>
                                            </tr>
                                            <tr>
                                                <td>时长</td>
                                                <td colspan="5">${oneOvertime.longtime }小时</td>
                                            </tr>
                                            <tr class="hide">
                                                <td>审核人</td>
                                                <td colspan="5">&nbsp;</td>
                                            </tr>



                                            </tbody></table>
                                    </div>
                                    <a class="btn btn-xs btn-warning" style="margin-bottom: 6px;">审批人进度</a>
                                    <div class="js-selectuserbox"> <a href="javascript:;" title="李四"><img class="gray" src="img/2.jpg" alt="李四">未处</a> </div>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-body">
                                    <h1 class="text-center cmnt-head">审批人</h1>


                                    <p class="text-center fade-txt">第
                                        <script>document.write( 0 +1)</script>1
                                        位审批人还没有审批此加班条!</p>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a> · <a href="">OPMS手册</a></footer>

    </div>

</section>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
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
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>


</body>
</html>
