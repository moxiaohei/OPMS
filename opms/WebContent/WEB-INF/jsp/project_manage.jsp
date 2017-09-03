<%@page import="com.opms.unti.StateMap"%>
<%@page import="com.opms.unti.ProjectState"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en">
<head>
<meta charset="UTF-8">
<title>OPMS管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="author" content="lock">
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/img/favicon.ico" type="image/png">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/style-responsive.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/table-responsive.css"
	rel="stylesheet">
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
				<form  action="searchProject" method="post" class="searchform">
					<select name="status" class="form-control">
						<option style="display:none" checked value="0">项目状态</option>
						<option value="1">挂起</option>
						<option value="2">延期</option>
						<option value="3">进行</option>
						<option value="4">结束</option>
					</select> <input class="form-control" name="name" placeholder="请输入名称"
						value="" type="text"></input>
					<input type="submit" class="btn btn-primary" value="搜索"></input>
				</form>
				<div class="menu-right">
					<ul class="notification-menu">
						<li><a href="#"
							class="btn btn-default dropdown-toggle info-number"
							data-toggle="dropdown"> <i class="fa fa-envelope-o"></i>
						</a>
							<div class="dropdown-menu dropdown-menu-head pull-right">
								<h5 class="title">你有 0 最新信息</h5>
								<ul class="dropdown-list normal-list">
									<li class="text-center">目前还没有最新消息</li>
									<li class="new"><a href="">查看更多</a></li>
								</ul>
							</div></li>
						<li><a href="javascript:;"
							class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<img
								src="<%=request.getContextPath()%>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg"
								alt="libai"> ${user.username} <span class="caret"></span>
						</a>
							<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
								<li><a href=""> <i class="fa fa-user"></i>
										个人主页
								</a></li>
								<li><a href=""> <i class="fa fa-cog"></i>
										基本资料
								</a></li>
								<li><a href=""> <i class="fa fa-camera"></i>
										更换头像
								</a></li>
								<li><a href="profilePwd"> <i class="fa fa-cog"></i>
										更换密码
								</a></li>
								<li><a href=""> <i class="fa fa-th-list"></i>
										我的任务
								</a></li>
								<li><a href="tologout"> <i class="fa fa-sign-out"></i>
										退出
								</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			<div class="page-heading">
				<h3>项目管理</h3>
				<ul class="breadcrumb pull-left">
					<li><a href="">OPMS</a></li>
					<li><a href="listProjectInfo">项目管理</a></li>
					<li class="active">项目</li>
				</ul>
				<div class="pull-right">
					<a href="dispatchPage" class="btn btn-success">+新项目</a>
				</div>
			</div>
			<div class="wrapper">
				<div class="row">
					<div class="col-sm-12">
						<section class="panel">
							<header class="panel-heading">
								项目 / 总数：${count}<span class="tools pull-right"><a
									href="javascript:;" class="fa fa-chevron-down"></a> </span>
							</header>
							<div class="panel-body">
								<section id="unseen">
									<form id="project-form-list">
										<table
											class="table table-bordered table-striped table-condensed">
											<thead>
												<tr>
													<th>名称</th>
													<th>别名</th>
													<th>创建人</th>
													<th>负责人</th>
													<th>结束时间</th>
													<th>状态</th>
													<th>操作</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${listProject}" var="project">
													<tr>
														<td><a href="getProjectInfo?projectid=${project.projectid}">${project.getName()}</a></td>
														<td>${project.aliasname }</td>
														<td><a href="">${project.getCreatePeople()}</a></td>
														<td><a href="">${project.getProductResponsePeople()}</a></td>
														<td>${project.getStringEndDate()}</td>
														<c:if test="${project.status==1}">
														    <td>挂起中</td>
														</c:if>
														<c:if test="${project.status==2}">
														    <td>延期</td>
														</c:if>
														<c:if test="${project.status==3}">
														    <td>进行</td>
														</c:if>
														<c:if test="${project.status==4}">
														    <td>结束</td>
														</c:if>
														<td><div class="btn-group">
																<button type="button"
																	class="btn btn-primary dropdown-toggle"
																	data-toggle="dropdown" aria-haspopup="true"
																	aria-expanded="false">
																	操作<span class="caret"></span>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="getEditProjectInfo?projectid=${project.projectid}">编辑</a></li>
																	<li role="separator" class="divider"></li>
																	<li><a href="updatePmsProjectsState?projectid=${project.projectid}&status=<%=ProjectState.HANGUP %>"
																		class="js-project-single" data-id="104706724144877568"
																		data-status="1">挂起</a></li>
																	<li><a href="updatePmsProjectsState?projectid=${project.projectid}&status=<%=ProjectState.DELAY %>"
																		class="js-project-single" data-id="104706724144877568"
																		data-status="2">延期</a></li>
																	<li role="separator" class="divider"></li>
																	<li><a href="updatePmsProjectsState?projectid=${project.projectid}&status=<%=ProjectState.DOING %>"
																		class="js-project-single" data-id="104706724144877568"
																		data-status="3">进行</a></li>
																	<li><a href="updatePmsProjectsState?projectid=${project.projectid}&status=<%=ProjectState.END %>"
																		class="js-project-single" data-id="104706724144877568"
																		data-status="4">结束</a></li>
																</ul>
															</div></td>
													</tr>
												</c:forEach>
											</tbody>

										</table>
									</form>

									<ul class="pagination pull-right">

										<li class="disabled"><a>首页</a></li>
										<li class="disabled"><a>«</a></li>

										<li class="active"><a href="">1</a></li>
										<li><a href="">2</a></li>


										<li><a href="">»</a></li>
										<li><a href="">尾页</a></li>

									</ul>

								</section>
							</div>
						</section>
					</div>
				</div>
			</div>


			<footer>
				2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a> · <a href="">OPMS手册</a>
			</footer>

		</div>

	</section>

	<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.nicescroll.js"></script>
	<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
	<div id="ascrail2000" class="nicescroll-rails"
		style="width: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;">
		<div
			style="position: relative; top: 0px; float: right; width: 6px; height: 404px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2000-hr" class="nicescroll-rails"
		style="height: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; height: 6px; width: 1366px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2001" class="nicescroll-rails"
		style="width: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; left: 137px; height: 636px; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2001-hr" class="nicescroll-rails"
		style="height: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; top: 633px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px; left: 0px;"></div>
	</div>
	<script src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
	<script src="<%=request.getContextPath()%>/js/opms.js"></script>
</body>
</html>
