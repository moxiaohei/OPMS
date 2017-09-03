<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow: hidden;" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/table-responsive.css" rel="stylesheet">
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
                            <a href="">libai</a>
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
                        <a href="">
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
            <form class="searchform" action="searchPmsProjectsVersion" method="post">
                <input class="form-control" name="title" placeholder="请输入名称" value="" type="text">
<!--                 <input type="submit" value="搜索" class="btn btn-primary"> -->
					 <button type="button" class="btn btn-primary" onclick="submit();">搜索</button>
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
                            libai
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li>
                                <a href="#">
                                    <i class="fa fa-user"></i>
                                    个人主页
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-cog"></i>
                                    基本资料
                                </a>
                            </li>
                            <li>
                                <a href="#">
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
                                <a href="#">
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
                <li> <a href="user_index.html">OPMS</a> </li>
                <li> <a href="project_detail.html">testkin1</a> </li>
                <li class="active"> 版本 </li>
            </ul>
            <div class="pull-right"><a href="toAddPmsProjectsVersion" class="btn btn-success">+新版本</a></div>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading"> 版本 / 总数：${count }<span class="tools pull-right"><a href="javascript:;" class="fa fa-chevron-down"></a>

              </span> </header>
                        <div class="panel-body">
                            <section id="unseen">
                                <form id="project-form-list">
                                    <table class="table table-bordered table-striped table-condensed">
                                        <thead>
                                        <tr>
                                            <th>名称</th>
                                            <th>创建人</th>
                                            <th>打包日期</th>
                                            <th>创建日期</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${list }" var="pmsProjectsVersion">
	                                        <tr>
	                                            <td><a href="project_version_detail.html">${pmsProjectsVersion.title }</a></td>
	                                            <td><a href="#">${pmsProjectsVersion.username }</a></td>
	                                            <td>
	                                            	<fmt:formatDate pattern="yyyy-MM-dd" value="${pmsProjectsVersion.versioned }" type="date"/>
	                                            </td>
	                                            <td>
	                                            	<fmt:formatDate pattern="yyyy-MM-dd" value="${pmsProjectsVersion.created }" type="date"/>
	                                            </td>
	                                            <td>
		                                            <a href="getPmsProjectsVersionToModify${pmsProjectsVersion.versionid }" title="编辑" class="btn btn-danger btn-xs">
		                                            	<i class="fa fa-pencil-square-o"></i>
		                                            </a> 
		                                            <a href="getPmsProjectsVersion${pmsProjectsVersion.versionid }" title="查看" class="btn btn-success btn-xs">
		                                            	<i class="fa fa-eye"></i>
		                                            </a>
	                                             </td>
	                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </form>
                            </section>
                        </div>
                    </section>
                </div>
                <div class="row">
			            <nav aria-lable="Page navigation">
			                <ul class="pagination pull-right">
			                	<c:if test="${pageInfo.pageNum==1 }">
			                		<li class="disabled"><a href="listPmsProjectsVersion?pageNum=1" >首页</a></li>
			                		<c:if test="${pageInfo.hasPreviousPage  }">
			                        <li>
			                            <a href="listPmsProjectsVersion?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
			                                <span aria-hidden="true">&laquo;</span>
			                            </a>
			                        </li>
				                    </c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listPmsProjectsVersion?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listPmsProjectsVersion?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listPmsProjectsVersion?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
				                    <li><a href="listPmsProjectsVersion?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                	<c:if test="${pageInfo.pageNum!=1 }">
			                		<li><a href="listPmsProjectsVersion?pageNum=1" >首页</a></li>
			                    	<c:if test="${pageInfo.hasPreviousPage  }">
				                        <li>
				                            <a href="listPmsProjectsVersion?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
				                                <span aria-hidden="true">&laquo;</span>
				                            </a>
				                        </li>
			                    	</c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listPmsProjectsVersion?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listPmsProjectsVersion?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listPmsProjectsVersion?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
			                    	<li><a href="listPmsProjectsVersion?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                </ul>
			            </nav>
			        </div>
            </div>
        </div>
        <footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a> · <a href="">OPMS手册</a></footer>
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


</body>
</html>
