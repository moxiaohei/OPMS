<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <link href="css/table-responsive.css" rel="stylesheet">
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
            <form class="searchform" action="searchgooutinfo" method="post">
                <select name="status" class="form-control">
                    <option value="">状态</option>
                    <option value="1">草稿</option>
                    <option value="2">正常</option>
                </select>
                <select name="result" class="form-control">
                    <option value="">结果</option>
                    <option value="1">同意</option>
                    <option value="2">拒绝</option>
                </select>
                <button type="submit" class="btn btn-primary">搜索</button>
            </form>
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
                <li class="active"> 外出 </li>
            </ul>
            <div class="pull-right">
                <a href="" class="hidden-xs btn btn-default">全部</a>
                <a href="approval_goout.html" class="btn btn-warning" style="padding: 4px;">待审批</a>
                <a href="addgooutmanage" class="btn btn-success">+我要外出</a> </div>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading"> 外出 / 总数：${listGoout.size()}<span class="tools pull-right"><a href="javascript:;" class="fa fa-chevron-down"></a> </span> </header>
                        <div class="panel-body">
                            <table class="table table-hover general-table">
                                <thead>
                                <tr>
                                    <th class="hidden-phone hidden-xs">外出日期</th>
                                    <th>小时</th>
                                    <th>状态</th>
                                    <th>结果</th>
                                    <th>进度</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                
                                <c:if test="${listGoout.size()==0}">
                                 <tr>
                                    <td colspan="7">暂无此类型出差单</td>
                                </tr>
                                </c:if>
                                <c:if test="${listGoout.size()>0}">
                                  <c:forEach items="${listGoout }" var="lgoout">
                                   <tr>
                                    <td class="hidden-phone hidden-xs">${lgoout.started }至${lgoout.ended }
<%--                                     	<fmt:formatDate value="${lgoout.started }" pattern="yyyy-MM-dd HH:mm"/> 至<fmt:formatDate value="${lgoout.ended }" pattern="yyyy-MM-dd HH:mm"/> --%>
                                    </td>
                                    <td><fmt:formatNumber value="${lgoout.hours}" pattern="0"></fmt:formatNumber> </td>
                                    <td>  <span class="label label-warning label-mini"><c:if
													test="${lgoout.status==1}">草稿</c:if>
												<c:if test="${lgoout.status==2}">正常发布</c:if></span>  </td>
                                    <td> <span class="label label-warning label-mini"><c:if
													test="${lgoout.result==1}">同意</c:if>
												<c:if test="${lgoout.result==2}">拒绝</c:if> <c:if
													test="${lgoout.result==null}">等待中</c:if></span>  </td>
                                    <td><div class="js-selectuserbox"> <a href="javascript:;" title="朱笑天"><img class="gray" src="img/1.jpg" alt="朱笑天">未处</a> </div></td>
                                    <c:if test="${lgoout.status==1 }">
                                         <td>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 操作<span class="caret"></span> </button>
                                            <ul class="dropdown-menu">
                                                <li><a href="editgooutmanage?gooutid=${lgoout.gooutid}">编辑</a></li>
                                                <li role="separator" class="divider"></li>
                                                <li><a href="deletegooutinfo?gooutid=${lgoout.gooutid}" class="js-goout-delete" data-op="delete" data-id="104596699334316032">删除</a></li>
                                                <li role="separator" class="divider"></li>
                                                <li><a href="updategooutstatus?gooutid=${lgoout.gooutid}" class="js-goout-status" data-op="status" data-id="104596699334316032">正常</a></li>
                                            </ul>
                                        </div>
                                        </td></c:if>
                                        <c:if test="${lgoout.status==2 }">
                                        <td>
                                        <a href="gooutdetail?gooutid=${lgoout.gooutid}"> 查看 </a>
                                        </td>
                                        </c:if>
                                    
                                </tr>
                                
                                   </c:forEach>
                               </c:if>
                                
<!--                                 <tr> -->
<!--                                     <td class="hidden-phone hidden-xs"> 2017-07-12 10:50至2017-07-02 14:10</td> -->
<!--                                     <td >12 </td> -->
<!--                                     <td><span class="label label-warning label-mini">正常</span>  </td> -->
<!--                                     <td><span class="label label-warning label-mini">等待中</span>  </td> -->
<!--                                     <td><div class="js-selectuserbox"> <a href="javascript:;" title="李浩"><img class="gray" src="img/1.jpg" alt="李浩">未处</a> </div></td> -->
<!--                                     <td> -->
<!--                                         <a href="goout_show.html"> 查看 </a> -->
<!--                                     </td> -->
<!--                                 </tr> -->
                                </tbody>

                            </table>
                        </div>
                    </section>
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
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>
</body>
</html>