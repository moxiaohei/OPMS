<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
           <h3> 组织管理 <span>
                   <a href="listPmsUsersProfile">员工</a>
                  	<a href="getDeparts">部门</a>
                   <a href="positionManage">职称</a>
				<a href="getNotices">公告</a>
                   <a href="GetGroups">组</a>
                   <a href="permissionManage">权限</a>
           </span></h3>
           <ul class="breadcrumb pull-left">
               <li> <a href="#">OPMS</a> </li>
               <li> <a href="listPmsUsersProfile">员工管理</a> </li>
               <li class="active"> 员工 </li>
           </ul>
           <div class="pull-right"><a href="add_user_manage.html" class="btn btn-success">+添加新员工</a></div>
       </div>
       <div class="wrapper">
           <div class="row">
               <div class="col-lg-12">
                   <section class="panel">
                       <header class="panel-heading">  </header>
                       <div class="panel-body">
                           <form action="updateUser"  method="post" class="form-horizontal adminex-form" id="userprofile-form" novalidate="novalidate">
                               <header><b> 基本信息 </b></header>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>用户名</label>
                                   <div class="col-sm-10">
                                       <input name="username"  value="${pmsUsers.username}"  style="background-color: white"
                                       
                                       data-userid="${pmsUsers.userid}" class="form-control" readonly="readonly"
                                       
                                       id="form-control1" placeholder="请填写用户名" type="text">
                                       <input   name="userid" value="${pmsUsers.userid }"  type="hidden">
                                       <input   name="user_id" value="${pmsUsers.userid }"  type="hidden">
                                       <input   name="status" value="${pmsUsers.status }"  type="hidden">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">密码</label>
                                   <div class="col-sm-10">
                                       <input name="password" value="" class="form-control" placeholder="请填写密码" type="password">
                                       <input name="avatar" value="${pmsUsers.password}" class="form-control" placeholder="请填写密码" type="hidden">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>部门</label>
                                   <div class="col-sm-10">
                                       <select name="departid" class="form-control">
                                           <option value="${pmsDeparts.departid}">${pmsDeparts.name}</option>
                                          <c:forEach items="${listPmsDeparts }"  var="dept">
                                          <c:if test="${dept.name!=pmsDeparts.name}">
                                           <option value="${dept.departid }">${dept.name }</option>
                                           </c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>职位</label>
                                   <div class="col-sm-10">
                                       <select name="positionid" class="form-control">
                                           <option value="${pmsPositions.positionid }">${pmsPositions.name }</option>
                                           <c:forEach items="${listPmsPositions }"  var="position">
                                           <c:if test="${position.name!=pmsPositions.name }">
                                           <option value="${position.positionid }">${position.name }</option>
                                           </c:if>
                                           </c:forEach>
                                       </select>
                                   </div>
                               </div>
                               <header> <b>帐号信息</b> </header>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>姓名</label>
                                   <div class="col-sm-10">
                                       <input name="realname" value="${pmsUsersProfile.realname }" class="form-control" placeholder="请填写姓名" type="text">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">性别</label>
                                   <div class="col-sm-10">
                                   <c:if test="${pmsUsersProfile.sex==1 }">
                                       <label class="radio-inline">
                                           <input name="sex" value="1" checked="checked" type="radio">
                                           男 </label>
                                       <label class="radio-inline">
                                           <input name="sex" value="2" type="radio">
                                           女 </label>
                                        </c:if>
                                   <c:if test="${pmsUsersProfile.sex==2 }">
                                       <label class="radio-inline">
                                           <input name="sex" value="1"  type="radio">
                                           男 </label>
                                       <label class="radio-inline">
                                           <input name="sex" value="2"  checked="checked" type="radio">
                                           女 </label>
                                        </c:if>
                                   <c:if test="${pmsUsersProfile.sex==0 }">
                                       <label class="radio-inline">
                                           <input name="sex" value="1"  type="radio">
                                           男 </label>
                                       <label class="radio-inline">
                                           <input name="sex" value="2"  type="radio">
                                           女 </label>
                                        </c:if>
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>生日</label>
                                   <div class="col-sm-10">
                                       <input name="birth" id="default-date-picker" value="${pmsUsersProfile.birth }" class="form-control hasDatepicker" placeholder="请填写昵称" type="date">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>公司邮箱</label>
                                   <div class="col-sm-10">
                                       <input name="email" value="${pmsUsersProfile.email }" class="form-control" placeholder="cto@milu365.com" type="email">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">微信号</label>
                                   <div class="col-sm-10">
                                       <input name="webchat" value="${pmsUsersProfile.webchat }" class="form-control" placeholder="微信号" type="text">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">QQ</label>
                                   <div class="col-sm-10">
                                       <input name="qq" value="${pmsUsersProfile.qq }" class="form-control" placeholder="QQ号" type="number">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>手机号</label>
                                   <div class="col-sm-10">
                                       <input name="phone" id="phone" maxlength="11" value="${pmsUsersProfile.phone }" class="form-control" placeholder="手机号" type="number">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">电话</label>
                                   <div class="col-sm-10">
                                       <input name="tel" value="${pmsUsersProfile.tel }" class="form-control" placeholder="联系电话" type="text">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label">住址</label>
                                   <div class="col-sm-10">
                                       <input name="address" value="${pmsUsersProfile.address }" class="form-control" placeholder="详情住址" type="text">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>紧急联系人</label>
                                   <div class="col-sm-10">
                                       <input name="emercontact" value="${pmsUsersProfile.emercontact }" class="form-control" placeholder="紧急联系人" type="text">
                                   </div>
                               </div>
                               <div class="form-group">
                                   <label class="col-sm-2 col-sm-2 control-label"><span>*</span>紧急联系人电话</label>
                                   <div class="col-sm-10">
                                       <input name="emerphone" value="${pmsUsersProfile.emerphone}" class="form-control" placeholder="紧急联系人电话" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-10">
                                       
                                        <input type="submit" class="btn btn-primary" id="btn btn-primary1"/>
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

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>
<script src="js/jquery-ui-1.10.3.min.js"></script>
<script src="js/datepicker-zh-CN.js"></script>
<script>
   $(function(){
       $('#default-date-picker').datepicker('option', $.datepicker.regional['zh-CN']);
       $('#default-date-picker').datepicker({
           dateFormat: 'yy-mm-dd',
           changeMonth: true,
           changeYear: true,
           yearRange:'-60:+0'
       });
   })
</script>
<div id="ui-datepicker-div" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div></body>
</html>


