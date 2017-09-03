<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
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
    <link href="css/demo_table.css" rel="stylesheet">
    <link href="css/DT_bootstrap.css" rel="stylesheet">
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

            <form class="searchform" action="listTaskBySearch" method="post">
                <select name="taskStatus" class="form-control">
                    <option value="">状态</option>
                    <option value="1">未开始</option>
                    <option value="2">进行中</option>
                    <option value="3">已完成</option>
                    <option value="4">已暂停</option>
                    <option value="5">已取消</option>
                    <option value="6">已关闭</option>
                </select>
                <select name="taskType" class="form-control">
                    <option value="">类型</option>
                    <option value="1">设计</option>
                    <option value="2">开发</option>
                    <option value="3">测试</option>
                    <option value="4">研究</option>
                    <option value="5">讨论</option>
                    <option value="6">界面</option>
                    <option value="7">事务</option>
                    <option value="8">其他</option>
                </select>
                <select name="taskAcceptid" class="form-control">
                    <option value="">指派给</option>
                    <c:forEach items="${listTeamMesg }" var="team">
						<option value="${team.getUserid() }">${team.getUsername() }</option>
					</c:forEach>
                </select>
                <input class="form-control" name="keywords" placeholder="请输入名称" value="" type="text">
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
                                    <a href="">查看更多</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="${user.username}">
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
                <li> <a href="getProjectInfo?projectid=${projectid }">testkin1</a> </li>
                <li class="active"> 任务 </li>
            </ul>
            <div class="pull-right">
                <a href="toProjectTask?projectid=${projectid }" class="btn btn-default active">全部</a>
                <a href="acceptTome" class="hidden-xs btn btn-default " style="padding: 6px;">指派给我</a>
                <a href="createByme" class="hidden-xs btn btn-default " style="padding: 6px;">由我创建</a>
                <a href="solveByme" class="hidden-xs btn btn-default " style="padding: 6px;">由我解决</a>
                <a href="closeByme" class="hidden-xs btn btn-default " style="padding: 6px;">由我关闭</a>
                <a href="displayByme" class="hidden-xs btn btn-default " style="padding: 6px;">由我取消</a>
                <a href="toInsertTask" class="btn btn-success">+新任务</a>
                <a href="toInsertTaskbatch" class="btn btn-warning">+批量添加</a>

            </div>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading"> 任务 / 总数：${listProjectTask.size() }<span class="tools pull-right"><a href="javascript:;" class="fa fa-chevron-down"></a>

              </span> </header>
                        <div class="panel-body">
                            <section id="unseen">
                                <form id="project-form-list">
                                    <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row-fluid"><div class="span6"></div><div class="span6"></div></div><table class="table table-bordered table-striped table-condensed dataTable" id="dynamic-table">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 75px;" aria-label="级别: activate to sort column ascending">级别</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 75px;" aria-label="名称: activate to sort column ascending">名称</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 83px;" aria-label="状态: activate to sort column ascending">状态</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 153px;" aria-label="截止日期: activate to sort column ascending">截止日期</th>
                                            <th class="sorting_desc" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 103px;" aria-sort="descending" aria-label="指派给: activate to sort column ascending">指派给</th>
                                            <th class="hidden-xs sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 103px;" aria-label="完成者: activate to sort column ascending">完成者</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 103px;" aria-label="预工时: activate to sort column ascending">预工时</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 75px;" aria-label="需求: activate to sort column ascending">需求</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 207px;" aria-label="操作: activate to sort column ascending">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
                                        <c:forEach items="${listProjectTask }" var="task">
                                        	<tr class="odd">
	                                            <td class=" "><span class="label label-danger">${task.getLevel() }级</span></td>
	                                            <td class=" "><a href="toTaskDetail${task.getTaskid() }">${task.getName() }</a></td>
	                                            <td class=" ">${task.getTaskStatus() }</td>
	                                            <td class=" ">${task.getEndDate() }</td>
	                                            <td class="  sorting_1"><a href="">${task.getAcceptName() }</a></td>
	                                            <td class="hidden-xs "><a href="">${task.getFinishName() }</a></td>
	                                            <td class=" ">${task.getTasktime() }</td>
	                                            <td class=" ">
	                                            	<a href="toNeedDetail${task.getNeedsid() }">
	                                            		<c:forEach items="${listProjectNeed }" var="need">
	                                            			<c:if test="${need.getNeedsid() == task.getNeedsid() }">
	                                            				${need.getName() }
	                                            			</c:if>
	                                            		</c:forEach>
	                                            	</a></td>
	                                            <td class=" ">
	                                                <a href="#acceptModal" data-toggle="modal" data-id="105027809126125568" title="指派" class="btn btn-warning btn-xs"><i class="fa fa-hand-o-right"></i></a>
	                                                <a href="#" data-id="${task.getTaskid() }" class="js-task-status btn btn-success btn-xs" data-status="2" title="开始"><i class="fa fa-chevron-circle-right"></i></a>
	                                                <a href="#" data-id="${task.getTaskid() }" class="js-task-status btn btn-info btn-xs" data-status="3" title="完成"><i class="fa fa-check-square"></i></a>
	                                                <a href="toEditTask${task.getTaskid() }" title="编辑" class="btn btn-danger btn-xs"><i class="fa fa-pencil-square-o"></i></a>
	                                            </td>
                                        	</tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                        <div class="row-fluid">
                                            <div class="span6"></div>
                                            <div class="span6"></div>
                                        </div>
                                    </div>
                                </form>

                            </section>
                        </div>
                    </section>
                </div>
            </div>
        </div>

        <div aria-hidden="true" aria-labelledby="acceptModalLabel" role="dialog" tabindex="-1" id="acceptModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">任务指派给?</h4>
                    </div>
                    <div class="modal-body">
                        <select id="acceptid" class="form-control">
                            <option value="">请选择指派给</option>
                            <c:forEach items="${listTeamMesg }" var="team">
								<option value="${team.getUserid() }">${team.getUsername() }</option>
							</c:forEach>
                        </select>
                        <p></p>
                        <textarea id="note" placeholder="备注说明" style="height: 90px;" class="form-control"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input id="taskid" type="hidden">
                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        <button class="btn btn-primary js-dialog-taskaccept" type="button">提交</button>
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
<script type="text/javascript" src="js/jquery.dataTables.js"></script>
<script type="text/javascript" src="js/DT_bootstrap.js"></script>
<script src="js/dynamic_table_init.js"></script>
<script>
    $(function(){
        $('#acceptModal').on('show.bs.modal', function (e) {
            $('#taskid').val($(e.relatedTarget).attr('data-id'))
        })

    })
</script>
</body>
</html>
