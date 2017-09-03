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
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link href="css/table-responsive.css" rel="stylesheet">
    <link href="css/lightbox.min.css" media="all" rel="stylesheet" type="text/css">
</head>
<body class="sticky-header">
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
    <div class="wrapper">
        <div class="row">
            <div class="col-lg-12">
                <section class="panel">
                    <header class="panel-heading"> 精彩相片
                        <div class="pull-right">
                            <a href="listAlbumsByUserid" class="btn btn-success">我的相片</a>&nbsp;
                            <a href="listAlbums" class="btn btn-success">全部相片</a>&nbsp;
                            <a href="toUpload" class="btn btn-success">+上传相片</a>
                        </div>
                    </header>
                    <div class="panel-body">
                        <div id="gallery" class="media-gal">
                        	<c:forEach items="${list }" var="pmsAlbums">
                        		<div class="images item ">
	                                <a href="uploadImg/${pmsAlbums.picture }" data-lightbox="example-set" data-title="${pmsAlbums.summary }">
	                                    <img src="uploadImg/${pmsAlbums.picture }" alt="${pmsAlbums.albumid }">
	                                </a>
	                                <p>
		                                <a href="getAlbums${pmsAlbums.albumid }">
		                                	${pmsAlbums.keywords }
		                                </a> 
	                                </p>
	                                <p>${pmsAlbums.summary }</p>
	                                <p>
	                              	  大哥
	                                <fmt:formatDate pattern="yyyy-MM-dd" value="${pmsAlbums.created }" type="date"/>
	                               	上传
	                                </p><!-- 这里需要获取session中保存的name -->
	                                <!-- 这里需要传Action -->
	                                <c:if test="${message!=null}">
		                                <p>
		                                	<a href="javascript:;" title="编辑" class="js-album-edit" data-id="${pmsAlbums.albumid }" data-title="${pmsAlbums.title }" data-summary="${pmsAlbums.summary }" data-status="${pmsAlbums.status }">
			                                	<i class="fa fa-edit">
			                                	</i>
		                                	</a>
		                               		<a href="javascript:;" onclick="deletes(${pmsAlbums.albumid},this)" class="js-album-delete" data-id="${pmsAlbums.albumid}" title="删除">
		                               			<i class="fa fa-trash-o"></i>
		                               		</a>
                                     </p>  
                                 </c:if>                     
                            	</div>
                        	</c:forEach>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </section>
                <div class="row">
			            <nav aria-lable="Page navigation">
			                <ul class="pagination pull-right">
			                	<c:if test="${pageInfo.pageNum==1 }">
			                		<li class="disabled"><a href="listAlbums?pageNum=1" >首页</a></li>
			                		<c:if test="${pageInfo.hasPreviousPage  }">
			                        <li>
			                            <a href="listAlbums?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
			                                <span aria-hidden="true">&laquo;</span>
			                            </a>
			                        </li>
				                    </c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listAlbums?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listAlbums?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listAlbums?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
				                    <li><a href="listAlbums?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                	<c:if test="${pageInfo.pageNum!=1 }">
			                		<li><a href="listAlbums?pageNum=1" >首页</a></li>
			                    	<c:if test="${pageInfo.hasPreviousPage  }">
				                        <li>
				                            <a href="listAlbums?pageNum=${pageInfo.pageNum-1}" aria-label="Previous">
				                                <span aria-hidden="true">&laquo;</span>
				                            </a>
				                        </li>
			                    	</c:if>
				                    <c:forEach items="${pageInfo.navigatepageNums  }" var="page">
				                        <c:if test="${page==pageInfo.pageNum }">
				                            <li class="active"><a href="listAlbums?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                        <c:if test="${page!=pageInfo.pageNum }">
				                            <li><a href="listAlbums?pageNum=${page}">${page}</a></li>
				                        </c:if>
				                    </c:forEach>
				                    <c:if test="${pageInfo.hasNextPage }">
				                        <li>
				                            <a href="listAlbums?pageNum=${pageInfo.pageNum+1 }" aria-label="Next">
				                                <span aria-hidden="true">&raquo;</span>
				                            </a>
				                        </li>
				                    </c:if>
			                    	<li><a href="listAlbums?pageNum=${pageInfo.pages}">尾页</a></li>
			                	</c:if>
			                </ul>
			            </nav>
			        </div>
            </div>
        </div>
    </div>
    <footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a> · <a href="">OPMS手册</a></footer>
</div>
<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.nicescroll.js"></script>
<script src="<%=request.getContextPath()%>/js/scripts.js"></script>
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
<script src="js/lightbox.min.js" type="text/javascript"></script>
<script type="text/javascript">
	//删除部分的Ajax实现
	function deletes(id,obj){
		$.post("deleteAlbums",{albumid:id},function(result){
			if(result.flag=="1"){
				dialogInfo(result.message);
				if(result.message=="删除成功"){
					 setTimeout(function(){window.location.href='listAlbumsByUserid';}, 2000);
				}else{
				     setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
				}	            
	            //$(this).parents("div").remove();
			}
		},"json");
	}
</script>
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
<div id="lightboxOverlay" class="lightboxOverlay" style="width: 1366px; height: 1000px; display: none;"></div>
<div id="lightbox" class="lightbox" style="display: none; top: 50px; left: 0px;">
    <div class="lb-outerContainer" style="width: 911px; height: 516px;">
        <div class="lb-container">
            <img class="lb-image" src="img/9df9361eae2098109c75cf32a965f1fe.jpg" style="display: block; width: 903px; height: 508px;"><div class="lb-nav" style="display: block;">
            <a class="lb-prev" href="#" style="display: block;"></a>
            <a class="lb-next" href="#" style="display: block;"></a>
        </div>
            <div class="lb-loader" style="display: none; opacity: 0.00175357;">
                <a class="lb-cancel"></a>
            </div>
        </div>
    </div>
    <div class="lb-dataContainer" style="display: block; width: 911px;">
        <div class="lb-data">
            <div class="lb-details">
                <span class="lb-caption" style="display: inline;">我想知道相片背后的故事</span>
                <span class="lb-number">Image 2 of 6</span>
            </div>
            <div class="lb-closeContainer">
                <a class="lb-close"></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
