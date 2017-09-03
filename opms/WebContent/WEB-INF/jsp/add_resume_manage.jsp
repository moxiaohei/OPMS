<%@page import="com.opms.unti.IntDate"%>
<%@page import="com.opms.entity.PmsResumesWork"%>
<%@page import="com.opms.entity.PmsResumesEducation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/style-responsive.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/default.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/css/datetimepicker-custom.css" rel="stylesheet">
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
                            <img src="<%=request.getContextPath()%>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
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
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">  </header>
                        <div class="panel-body">
                            <form onsubmit="return sub();" action="insertResumes" method="post" enctype="multipart/form-data" class="form-horizontal adminex-form" id="resume-form01" novalidate="novalidate">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>姓名</label>
                                    <div class="col-sm-10">
                                        <input onblur="checkRealname(this);" id="realname" name="realname" value="" class="form-control" placeholder="请输入姓名" type="text">
                                   		<span style="color:red"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>手机</label>
                                    <div class="col-sm-10">
                                        <input onblur="checkPhone(this);" id="phone" name="phone" value="" class="form-control" placeholder="请输入手机号" type="text">
                                    <span style="color:red"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">性别</label>
                                    <div class="col-sm-10">
                                        <label class="radio-inline">
                                            <input id="sex" name="sex" checked="checked" value="1" type="radio">
                                            男 </label>
                                        <label class="radio-inline">
                                            <input id="sex" name="sex" value="2" type="radio">
                                            女 </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>生日</label>
                                    <div class="col-sm-10">
                                        <input readonly="readonly" id="birth" onblur="checkBirth(this);" onchange="checkBirth(this);" name="birth" id="default-date-picker" value="" class="form-control hasDatepicker" placeholder="出生日期" type="text">
                                    	<span style="color:red"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">学历</label>
                                    <div class="col-sm-10">
                                        <select id="edu" name="edu" class="form-control">
<!--                                         		<option value="-1">请选择学历</option> -->
                                        		<c:set value="<%=com.opms.entity.PmsResumesEducation.values() %>" var="list"></c:set>
	                                           	<c:forEach items="${list }" var="pmsResumesEducation">
	                                           		<option value="${pmsResumesEducation.pmsResumesEducationindex}">${pmsResumesEducation.pmsResumesEducationname }</option>
	                                           	</c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">工作年限</label>
                                    <div class="col-sm-10">
                                        <select id="work" name="work" class="form-control">
<!--                                             <option value="0">请选择工作年限</option> -->
                                           	<c:set value="<%=com.opms.entity.PmsResumesWork.values() %>" var="list"></c:set>
                                           	<c:forEach items="${list }" var="pmsResumesWork">
                                           		<option value="${pmsResumesWork.pmsResumesWorkindex}">${pmsResumesWork.pmsResumesWorkname }</option>
                                           	</c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">备注</label>
                                    <div class="col-sm-10">
                                        <textarea id="note" name="note" placeholder="备注说明" style="height: 300px;" class="form-control"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">简历附件</label>
                                    <div class="col-sm-10">
                                        <input name="files" multiple="multiple" type="file">
<!--                                         <input name="attachment" type="hidden" value="C://upload"> -->
<!--                                         <input name="created" type="hidden" value="1996-12-08"> -->
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">状态</label>
                                    <div class="col-sm-10">
                                    	<c:set value="<%=com.opms.entity.PmsResumesState.values() %>" var="list"></c:set>
	                                 	<c:forEach items="${list }" var="pmsResumesState">
	                                 		<c:if test="${pmsResumesState.pmsResumesStateindex==1 }">
	                                 		<label class="radio-inline">
                                           		<input id="status" name="status" value="${pmsResumesState.pmsResumesStateindex}" checked="checked" type="radio">
	                                            ${pmsResumesState.pmsResumesStatename } </label>
	                                        </c:if>
	                                        <c:if test="${pmsResumesState.pmsResumesStateindex!=1 }">
                                      			<label class="radio-inline">
                                      			<input id="status" name="status" value="${pmsResumesState.pmsResumesStateindex}" type="radio">
	                                            ${pmsResumesState.pmsResumesStatename } </label>
                                      		</c:if>    
	                                    </c:forEach>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-10">
                                       <input id="bt" type="submit" value="提交保存" class="btn btn-primary">
                                    </div>
                                </div>
                            </form>
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
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.10.3.min.js"></script>
<script src="<%=request.getContextPath()%>/js/datepicker-zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/kindeditor-min.js"></script>
<script src="<%=request.getContextPath()%>/js/zh-CN.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.js"></script>
<script  type="text/javascript">
    $(function(){
        var editor = KindEditor.create('textarea[name="note"]', {
            uploadJson: "/kindeditor/upload",
            allowFileManager: true,
            filterMode : false,
            afterBlur: function(){this.sync();}
        });

        $('#default-date-picker').datepicker('option', $.datepicker.regional['zh-CN']);
        $('#default-date-picker').datepicker({
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            yearRange:'-60:+0'
        });
    });
</script>
<!-- Ajax实现部分,因为有问题所以没有用  
	
<script type="text/javascript">
	$(function(){
		$("#bt").click(function(){
			$("#files").change(function(){
				$('#resume-form01').ajaxSubmit({
					url : "insertResumes",
					dataType:"text",
					success : function(){
						
					}
				});
			});
			
			$.ajax({
				url:'insertResumes',
				type:'post',
				data:$('#formId').serialize(),
				dataType:'json',
				async: true,
				success:function(result){  //表示请求成功后调用的函数
					if(result.flag=="1"){
						dialogInfo("添加成功");
						setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
						window.location.href = 'listResumes';
					}
				},
				error:function(){
					dialogInfo("添加失败");
					setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
				}
			});
		});
	}); 
</script> -->
<script type="text/javascript">
function checkByteLength(str,minlen,maxlen) {
	var l = str.length;
	var blen = 0;
	//循环取得检验值的长度
	for(i=0; i<l; i++) {
	if ((str.charCodeAt(i) & 0xff00) != 0) {
		blen ++;
	}
		blen ++;
	}
	//判断长度是否合法
	if (blen > maxlen || blen < minlen) {
		return false;
	}
	return true;
}
//验证用户名是否合法
var onoff1=false;
var onoff2=false;
var onoff3=false;
function checkRealname(t){
	var value = document.getElementById('realname').value;
// 	var patn = /^[a-zA-Z]+[a-zA-Z0-9]+$/; 
	var patn = /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
	//判断长度是否合法
	if(!checkByteLength(value,2,15)){
		document.getElementById('realname').value="";
		t.parentNode.children[1].innerHTML="请输入2-15位的用户名";
		onoff1=false;
	}
	else{
		t.parentNode.children[1].innerHTML="";
		onoff1=true;
		}
		
};

function checkPhone(t){
    var phone = document.getElementById('phone').value;
    if(!(/^1(3|4|5|7|8)\d{9}$/.test(phone))){ 
    	t.parentNode.children[1].innerHTML="请输入正确的手机号码"; 
    	onoff2=false;
    }
    else{
    	t.parentNode.children[1].innerHTML="";
    	onoff2=true;
        } 
};
function checkBirth(t){
	if(t.value){
		t.parentNode.children[1].innerHTML="";
    	onoff3=true;
		}
	else{
		t.parentNode.children[1].innerHTML="请输入生日"; 
    	onoff3=false;
		}
};
function sub(){
	var realname = document.getElementById('realname');
	var phone = document.getElementById('phone');
	var birth = document.getElementById('birth');
	checkRealname(realname);
	checkPhone(phone);
	checkBirth(birth);
	if(onoff1&&onoff2&&onoff3){
		dialogInfo("添加成功");
		setTimeout(function(){ $('#dialogInfo').modal('hide'); }, 2000);
		return true;
	}else{
		return false;
	}
};
</script>


<script type="text/javascript">
		$('.hasDatepicker').datetimepicker({
		    minView: "month", //选择日期后，不会再跳转去选择时分秒 
		    language:  'zh-CN',
		    format: 'yyyy-mm-dd',
		    todayBtn:  1,
		    autoclose: 1,
		});
</script>
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
<script src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath()%>/js/opms.js"></script>
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
