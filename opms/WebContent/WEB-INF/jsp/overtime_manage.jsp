<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow: hidden;" lang="en">
<head>
<meta charset="UTF-8">
<title>OPMS管理系统</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
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
			<form class="searchform" action="searchOvertimeInfo" method="post">
				<select name="status" class="form-control">
					<option value="">状态</option>
					<option value="1">草稿</option>
					<option value="2">正常</option>
				</select> <select name="result" class="form-control">
					<option value="">结果</option>
					<option value="1">同意</option>
					<option value="2">拒绝</option>
				</select>
				<button type="submit" class="btn btn-primary">搜索</button>
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
								<li class="new"><a href="message_manage.html">查看更多</a></li>
							</ul>
						</div></li>
					<li><a href="javascript:;"
						class="btn btn-default dropdown-toggle" data-toggle="dropdown">
							<img src="img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg"
							alt="libai"> ${user.username } <span class="caret"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-usermenu pull-right">
							<li><a href="user_index.html"> <i class="fa fa-user"></i>
									个人主页
							</a></li>
							<li><a href="user_form.html"> <i class="fa fa-cog"></i>
									基本资料
							</a></li>
							<li><a href="avatar.html"> <i class="fa fa-camera"></i>
									更换头像
							</a></li>
							<li><a href="profilePwd"> <i class="fa fa-cog"></i>
									更换密码
							</a></li>
							<li><a href="task.html"> <i class="fa fa-th-list"></i>
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
			<h3>
				审批管理 <span> <a href="leavemanage">请假</a> <a
					href="overtimemanage">加班</a> <a href="expensemanage">报销</a> <a
					href="businesstripmanage">出差</a> <a href="gooutmanage">外出</a>
					<a href="oagood_manage">物品</a>
				</span>
			</h3>
			<ul class="breadcrumb pull-left">
				<li><a href="user_index.html">OPMS</a></li>
				<li><a href="approvalindex">审批管理</a></li>
				<li class="active">加班</li>
			</ul>
			<div class="pull-right">
				<a href="#" class="btn btn-default hidden-xs">全部</a> <a href="approvalovertime"
					class="btn btn-warning" style="padding: 4px;">待审批</a> <a
					href="addovertimemanage" class="btn btn-success">+我要加班</a>
			</div>
		</div>
		<div class="wrapper">
			<div class="row">
				<div class="col-sm-12">
					<section class="panel"> <header class="panel-heading">
					加班 / 总数：${listOvertime.size() }<span class="tools pull-right"><a
						href="javascript:;" class="fa fa-chevron-down"></a> </span> </header>
					<div class="panel-body">
						<table class="table table-hover general-table">
							<thead>
								<tr>
									<th>时长</th>
									<th class="hidden-phone hidden-xs">加班日期</th>
									<th>方式</th>
									<th>状态</th>
									<th>结果</th>
									<th>进度</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<c:if test="${listOvertime.size()==0 }">
                                <tr>
                                    <td colspan="7">暂无此类型出差单</td>
                                </tr>
                                </c:if>
                               <c:if test="${listOvertime.size()>0 }"> 
								<c:forEach items="${ listOvertime}" var="otime">
									<tr>
										<td>${otime.longtime}</td>
										<td class="hidden-phone hidden-xs">
										  ${otime.started }至${otime.ended }

												</td> 
										<td><c:if test="${otime.way==1 }">调休</c:if>
											<c:if test="${otime.way==2 }">加班</c:if></td>
										<td><span class="label label-warning label-mini"><c:if
													test="${otime.status==1 }">草稿</c:if>
												<c:if test="${otime.status==2 }">正常</c:if></span></td>
										<td><span class="label label-warning label-mini">等待中</span>
										</td>
										<td><div class="js-selectuserbox">
												<a href="javascript:;" title="李浩"><img class="gray"
													src="img/1.jpg" alt="李浩">未处</a>
											</div></td>
										<c:if test="${otime.status==1}"><td>
												<div class="btn-group">
													<button type="button"
														class="btn btn-primary dropdown-toggle"
														data-toggle="dropdown" aria-haspopup="true"
														aria-expanded="false">
														操作<span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a href="editovertimemanage?overtimeid=${otime.overtimeid }">编辑</a></li>
														<li role="separator" class="divider"></li>
														<li><a href="deleteOvertimeInfo?overtimeid=${otime.overtimeid }" class="js-overtime-delete"
															data-op="delete" >删除</a></li>
														<li role="separator" class="divider"></li>
														<li><a href="updateOvertimeStatus?overtimeid=${otime.overtimeid }" class="js-overtime-status"
															data-op="status" >正常</a></li>
													</ul>
												</div></td>
										</c:if> <c:if test="${otime.status==2}">
												<td><a href="overtimedetail?overtimeid=${otime.overtimeid }"> 查看 </a></td>
											</c:if>
									</tr>
								</c:forEach>
						</c:if>
						</table>
					</div>
					</section>
				</div>
			</div>
		</div>
		<footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a>
		· <a href="">OPMS手册</a></footer>
	</div>
	</section>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<div id="ascrail2000" class="nicescroll-rails"
		style="width: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;">
		<div
			style="position: relative; top: 0px; float: right; width: 6px; height: 308px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2000-hr" class="nicescroll-rails"
		style="height: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; height: 6px; width: 1215px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2001" class="nicescroll-rails"
		style="width: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; left: 137px; height: 555px; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
	</div>
	<div id="ascrail2001-hr" class="nicescroll-rails"
		style="height: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; top: 552px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;">
		<div
			style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px; left: 0px;"></div>
	</div>
	<script src="js/jquery.validate.js"></script>
	<script src="js/opms.js"></script>
</body>
</html>
