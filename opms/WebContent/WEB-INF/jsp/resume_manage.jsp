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
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/table-responsive.css" rel="stylesheet">
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
            <form class="searchform" action="searchResumes" method="post">
                <select name="status" class="form-control" id="status">
                    <option value="0">状态</option>
                    <option value="1">入档</option>
                    <option value="2">通知面试</option>
                    <option value="3">违约</option>
                    <option value="4">录用</option>
                    <option value="5">不录用</option>
                </select>
                <input id="realname" class="form-control" name="realname" placeholder="请输入姓名" value="${pr.realname }" type="text">
                <button type="button" class="btn btn-primary" onclick="submit()">搜索</button>
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
                                    <a href="#">查看更多</a>
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
            <h3> 简历管理 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="#">OPMS</a> </li>
                <li> <a href="listResumes">简历管理</a> </li>
                <li class="active"> 简历 </li>
            </ul>
            <div class="pull-right"><a href="toAddResumes" class="btn btn-success">+添加新简历</a></div>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading"> 简历管理 / 总数：${count }<span class="tools pull-right"><a href="javascript:;" class="fa fa-chevron-down"></a>

              </span> </header>
                        <div class="panel-body">
                            <section id="unseen">
                                <form id="resume-form-list">
                                    <table id="tbData" class="table table-bordered table-striped table-condensed">
                                        <thead>
                                        <tr>
                                            <th>姓名</th>
                                            <th>性别</th>
                                            <th>手机</th>
                                            <th>生日</th>
                                            <th>学历</th>
                                            <th>经验</th>
                                            <th>简历</th>
                                            <th>状态</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listResumes }" var="resumes">
                                        <tr>
                                            <td>${resumes.realname }</td>
                                            <td>
                                            	<c:if test="${resumes.sex==1 }">
                                            		男
                                            	</c:if>
                                            	<c:if test="${resumes.sex==2 }">
                                            		女
                                            	</c:if>
                                            </td>
                                            <td>${resumes.phone }</td>
                                            <td>
	                                           <fmt:formatDate pattern="yyyy-MM-dd" value="${resumes.birth }" type="date"/>
                                           	</td>
                                           	<c:set value="<%=com.opms.entity.PmsResumesEducation.values() %>" var="list"></c:set>
                                           	<c:if test="${resumes.edu==0}">
                                           		<td></td>
                                           	</c:if>
                                           	<c:if test="${resumes.edu!=0}">
	                                           	<c:forEach items="${list }" var="pmsResumesEducation">
	                                           		<c:if test="${resumes.edu == pmsResumesEducation.pmsResumesEducationindex}">
	                                           			<td> ${pmsResumesEducation.pmsResumesEducationname } </td>
	                                           		</c:if>
	                                           	</c:forEach>
                                           	</c:if>
                                           	<c:set value="<%=com.opms.entity.PmsResumesWork.values() %>" var="list"></c:set>
                                           	<c:if test="${resumes.work==0}">
                                           		<td></td>
                                           	</c:if>
                                           <c:if test="${resumes.work!=0}">
	                                           	<c:forEach items="${list }" var="pmsResumesWork">
	                                           		<c:if test="${resumes.work == pmsResumesWork.pmsResumesWorkindex}">
	                                           			<td> ${pmsResumesWork.pmsResumesWorkname } </td>
	                                           		</c:if>
	                                           	</c:forEach>
                                           	</c:if>
                                            <td>
                                            	<c:if test="${resumes.attachment=='暂无' }">
                                            		暂无
                                            	</c:if>
                                            	<c:if test="${resumes.attachment!='暂无' }">
                                            		<a href="${resumes.attachment}" target="_blank">查看预览</a>
                                            	</c:if>
                                            </td>
                                            <c:set value="<%=com.opms.entity.PmsResumesState.values() %>" var="list"></c:set>
                                           	<c:forEach items="${list }" var="pmsResumesState">
                                           		<c:if test="${resumes.status == pmsResumesState.pmsResumesStateindex}">
                                           			<td id="${resumes.resumeid }"> ${pmsResumesState.pmsResumesStatename } </td>
                                           		</c:if>
                                           	</c:forEach>
                                            <td><div class="btn-group">
                                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 操作<span class="caret"></span> </button>
                                                <ul class="dropdown-menu">
                                                    <li><a href="getResumes${resumes.resumeid }">编辑</a></li>
                                                    <li role="separator" class="divider"></li>
                                                    <c:if test="${resumes.status==1 }">
                                                    	<li>
                                                    	<!-- onclick="updateStatus(${resumes.resumeid },2) -->
                                            			<a id="${resumes.resumeid }" onclick="updateState();" href="updateStateById?resumeid=${resumes.resumeid }&status=2"" >通知面试</a>
                                            			</li>
                                            			<li role="separator" class="divider"></li>
                                            		</c:if>
                                            		<c:if test="${resumes.status==2 }">
                                            			<li>
	                                            			<a id="${resumes.resumeid }" onclick="updateState();" href="updateStateById?resumeid=${resumes.resumeid }&status=3">违约</a>
	                                            			<a id="${resumes.resumeid }" onclick="updateState();" href="updateStateById?resumeid=${resumes.resumeid }&status=4">录用</a>
	                                            			<a id="${resumes.resumeid }" onclick="updateState();" href="updateStateById?resumeid=${resumes.resumeid }&status=5">不录用</a>
                                            			</li>
                                            			<li role="separator" class="divider"></li>
                                            		</c:if><!-- href="deleteResumes${resumes.resumeid }" -->
<%--                                                     <li><a  id="delete" onclick="deletes(${resumes.resumeid},this)" class="js-resumes-delete" data-id="${resumes.resumeid}">删除</a></li> --%>
                                                		<li><a  id="delete" onclick="del();" href="deleteResumes?resumeid=${resumes.resumeid }" class="js-resumes-delete" data-id="${resumes.resumeid}">删除</a></li>
                                                </ul>
                                            </div></td>
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
			                		<li class="disabled"><a href="listResumes?pageNum=1" >首页</a></li>
			                		<c:if test="${pageInfo.hasPreviousPage  }">
			                        <li>
			                            <a href="listResumes?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
			                                <span aria-hidden="true">&laquo;</span>
			                            </a>
			                        </li>
				                    </c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listResumes?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listResumes?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listResumes?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
				                    <li><a href="listResumes?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                	<c:if test="${pageInfo.pageNum!=1 }">
			                		<li><a href="listResumes?pageNum=1" >首页</a></li>
			                    	<c:if test="${pageInfo.hasPreviousPage  }">
				                        <li>
				                            <a href="listResumes?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
				                                <span aria-hidden="true">&laquo;</span>
				                            </a>
				                        </li>
			                    	</c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listResumes?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listResumes?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listResumes?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
			                    	<li><a href="listResumes?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                </ul>
			            </nav>
			        </div>
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

<script type="text/javascript">
	function del(){
		dialogInfo("删除成功");
		setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
	};
	function updateState(){
		dialogInfo("状态更新成功");
		setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
	};
</script>

<!-- <script type="text/javascript">
	/*//模糊查询的函数实现
		function submit(){
		alert("HELLO");
		var status = $("#status").val();
		var realname = $("#realname").val();

		$("#status").html(status);
		$("#realname").html(realname);
		return true;
	} */
	/* //删除部分的Ajax实现
	function deletes(id,obj){
		$.post("deleteResumes",{resumeid:id},function(result){
			if(result.flag=="1"){
				dialogInfo(result.message);
	            setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
	            delrow(obj);
			}
		},"json");
	}
	
	function delrow(element){
		while(element.tagName!="TR"){//一直查找获取到为TR的对象
			element = element.parentNode;
		}
		var tbody = element.parentNode;//取得表格对象
		tbody.removeChild(element);
	} */

	/* //更新状态的Ajax实现
    function updateStatus(resumeid,status_id){
		$.ajax({
			url:'updateStateById',
			type:'post',
			data:{
				status: status_id ,
				resumeid: resumeid ,
				time:new Date().getTime(),   //使用新的url，不使用缓存
				cache:false   //表示不会从浏览器中加载缓存信息
			},
			async: true,
			dataType:"text",   //表示从服务端返回的数据为纯文本类型
			success:function(){   //表示请求成功后调用的函数
				var state;
				if(status_id==2){
					state="通知面试";
				}else if(status_id==3){
					state="违约";
				}else if(status_id==4){
					state="录用";
				}else if(status_id==5){
					state="不录用";
				}
				$("#"+resumeid).html(state);
				dialogInfo("项目状态修改成功");
				setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
			},
			error:function(){
				dialogInfo("项目状态修改失败");
			}
		});
	} */
	
	/* function updateStates(id,status){
		$.post("updateStateById",{resumeid:id,status:status},function(result){
			if(result.flag=="1"){
				dialogInfo(result.message);
	            setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
	            updateColumn(status);
			}
		},"json");
	}

	function updateColumn(status){
		$("#tbData tbody").find("tr").each(function () {
			var object = $(this).find("td:eq(7)");
			object.html(status);
		});
	} */
	
</script> -->

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
<div class="modal fade" id="dialogInfo" tabindex="-1" role="dialog" aria-labelledby="dialogInfoTitle" style="display: none;" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="dialogInfoTitle">OPMS提示</h4>
            </div>
            <div class="modal-body">
                <p>删除成功</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
