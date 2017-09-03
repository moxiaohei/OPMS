<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/jquery-ui-1.10.3.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/default.css" rel="stylesheet"></head>
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
                    <a href="user_index.html">
                        <i class="fa fa-home"></i>
                        <span>我的主页</span>
                    </a>
                </li>
                <li class="">
                    <a href="project_manage.html">
                        <i class="fa fa-book"></i>
                        <span>项目管理</span>
                    </a>
                </li>
                <li>
                    <a href="checkwork_index.html">
                        <i class="fa fa-tasks"></i>
                        <span>考勤管理</span>
                    </a>
                </li>
                <li>
                    <a href="approval_index.html">
                        <i class="fa fa-suitcase"></i>
                        <span>审批管理</span>
                    </a>
                </li>
                <li>
                    <a href="knowledge_manage.html">
                        <i class="fa fa-tasks"></i>
                        <span>知识分享</span>
                    </a>
                </li>
                <li>
                    <a href="album_manage.html">
                        <i class="fa fa-plane"></i>
                        <span>员工相册</span>
                    </a>
                </li>
                <li>
                    <a href="resume_manage.html">
                        <i class="fa fa-laptop"></i>
                        <span>简历管理</span>
                    </a>
                </li>
                <li>
                    <a href="user_manage.html">
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
                            <img src="<%=request.getContextPath()%>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
                            libai
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
                                <a href="profile_pwd.html">
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
                                <a href="login.html">
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
            <h3> 版本管理 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="user_index.html">OPMS</a> </li>
                <li> <a href="project_detail.html">testkin1</a> </li>
                <li class="active"> 版本 </li>
            </ul>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">  </header>
                        <div class="panel-body">
                        <c:forEach items="${list }" var="pmsProjectsVersion">
                            <form onsubmit="sub();" id="version-form02" action="updatePmsProjectsVersion" method="post" enctype="multipart/form-data" class="form-horizontal adminex-form" novalidate="novalidate">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>版本名称</label>
                                    <div class="col-sm-10">
                                        <input id="title" name="title" value="${pmsProjectsVersion.title }" class="form-control" placeholder="请输入版本名称" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>打包日期</label>
                                    <div class="col-sm-10">
                                        <input class="form-control dpd1 hasDatepicker" data-date="${pmsProjectsVersion.versioned }" data-date-format="yyyy-mm-dd" id="versioned" name="versioned" placeholder="打包日期" 
                                        value='<fmt:formatDate pattern="yyyy/MM/dd" value="${pmsProjectsVersion.versioned }" type="date"/>' id="dp1499937003162" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">源代码地址</label>
                                    <div class="col-sm-10">
                                        <input name="sourceurl" value="${pmsProjectsVersion.sourceurl }" class="form-control" placeholder="http://" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">下载地址</label>
                                    <div class="col-sm-10">
                                        <input name="downurl" value="${pmsProjectsVersion.downurl }" class="form-control" placeholder="http://" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">上传发行包</label>
                                    <div class="col-sm-10">
                                        <input name="files" id="files" type="file">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">描述</label>
                                    <div class="col-sm-10">
                                        <textarea name="content" placeholder="请填写正文" style="height: 300px;" class="form-control">${pmsProjectsVersion.content }</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-10">
                                        <input name="projectid" id="projectid" value="${pmsProjectsVersion.projectid }" type="hidden">
                                        <input name="versionid" value="${pmsProjectsVersion.versionid }" type="hidden">
                                        <input name="userid" value="${pmsProjectsVersion.userid }" type="hidden">
                                        <input name="created" value="${pmsProjectsVersion.created }" type="hidden">
                                        <input type="submit" value="提交保存" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
                            </c:forEach>
                        </div>
                    </section>
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
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/kindeditor-min.js"></script>
<script src="<%=request.getContextPath()%>/js/zh-CN.js"></script>
<script>
    $(function(){
        var editor = KindEditor.create('textarea[name="content"]', {
            uploadJson: "/kindeditor/upload",
            allowFileManager: true,
            filterMode : false,
            afterBlur: function(){this.sync();}
        });
        $('.dpd1').datepicker('option', $.datepicker.regional['zh-CN']);
        $('.dpd1').datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            yearRange:'-60:+0'
        });
    });
</script>
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
<script type="text/javascript">
$('#version-form02').validate({
    ignore:'',
	rules : {
		title:{required: true},
		versioned: {required: true}			
    },
    messages : {
		title:{required: '请填写版本名称'},
		versioned:{required: '请选择打包日期'}
    }
});
</script>
<script type="text/javascript">
function sub(){
	var title = document.getElementById('title');
	var versioned = document.getElementById('versioned');
	if(title!=null && versioned!=null){
		dialogInfo("修改成功");
		setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 3000);
		return true;
	}else{
		return false;
	}
};
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
</body>
</html>
