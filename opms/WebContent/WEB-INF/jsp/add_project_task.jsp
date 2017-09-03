<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html style="" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link href="css/datetimepicker-custom.css" rel="stylesheet">
    <link href="css/default.css" rel="stylesheet"></head>
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
                            <a href="">${user.username}</a>
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
                    <a href="">
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
                    <a href="">
                        <i class="fa fa-tasks"></i>
                        <span>考勤管理</span>
                    </a>
                </li>
                <li>
                    <a href="">
                        <i class="fa fa-suitcase"></i>
                        <span>审批管理</span>
                    </a>
                </li>
                <li>
                    <a href="">
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
                    <a href="">
                        <i class="fa fa-laptop"></i>
                        <span>简历管理</span>
                    </a>
                </li>
                <li>
                    <a href="">
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
                                    <a href="">查看更多</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li>
                        <a href="javascript:;" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                            <img src="img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
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
            <h3> 任务管理 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="">OPMS</a> </li>
                <li> <a href="">testkin1</a> </li>
                <li class="active"> 任务 </li>
            </ul>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">  </header>
                        <div class="panel-body">
                            <form class="form-horizontal adminex-form" id="task-form" novalidate="novalidate" action="insertTask" method="post" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>关联需求</label>
                                    <div class="col-sm-10">
                                        <select name="needsid" class="form-control">
                                            <option value="" selected="selected">请选择项目需求</option>

                                            <c:forEach items="${listProjectNeed }" var = "need">
                                            	<option value="${need.getNeedsid() }">${need.getName() }</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>任务类型</label>
                                    <div class="col-sm-10">
                                        <select name="type" class="form-control">
                                            <option value="">请选择任务类型</option>
                                            <option value="1">设计</option>
                                            <option value="2">开发</option>
                                            <option value="3">测试</option>
                                            <option value="4">研究</option>
                                            <option value="5">讨论</option>
                                            <option value="6">界面</option>
                                            <option value="7">事务</option>
                                            <option value="8">其他</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">指派给</label>
                                    <div class="col-sm-10">
                                        <select name="acceptid" class="form-control">
                                            <option selected="selected" value="">请选择指派给</option>

                                            <c:forEach items="${listTeamMesg }" var = "team">
                                            	<option value="${team.getId() }">${team.getUsername() }</option>
                                            </c:forEach>

                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>任务名称</label>
                                    <div class="col-sm-10">
                                        <input name="name" value="" class="form-control" placeholder="请输入任务名称" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">描述</label>
                                    <div class="col-sm-10">
                                        <textarea name="description" placeholder="请填写描述" style="height: 300px; " class="form-control"></textarea>
                                    </div>
                                </div>
                               <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">备注</label>
                                    <div class="col-sm-10">
                                        <textarea name="note" placeholder="备注说明" style="height: 200px;" class="form-control"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">优先级</label>
                                    <div class="col-sm-10">
                                        <select name="level" class="form-control">
                                            <option value="">请选择优先级</option>
                                            <option value="1">1级</option>
                                            <option value="2">2级</option>
                                            <option value="3">3级</option>
                                            <option value="4">4级</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">预计工时</label>
                                    <div class="col-sm-10">
                                        <input name="tasktime" value="0" class="form-control" placeholder="请输入数字" type="number">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">开始和结束日期</label>
                                    <div class="col-sm-10">
                                        <div class="input-group input-large custom-date-range" data-date="2016-07-07" data-date-format="yyyy-mm-dd">
                                            <input class="form-control dpd1" name="startDate" placeholder="开始日期" value="" type="text" id="datetimeStart">
                                            <span class="input-group-addon">To</span>
                                            <input class="form-control dpd2" name="endDate" placeholder="结束日期" value="" type="text" id="datetimeEnd">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">抄送给</label>
                                    <div class="col-sm-10">
                                        <input name="username" id="cc-username" value="" class="form-control" placeholder="点击选择抄送人" type="text">
                                        <input name="ccid" id="ccid" value="1468140265954907628" type="hidden">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">附件</label>
                                    <div class="col-sm-10">
                                        <input name="file" type="file">
                                    </div>
                                </div> -->
                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-10">
                                        <input name="projectid" id="projectid" value="${projectid }" type="hidden">
                                        <input name="userid" id="userid" value="${user.getUserid() }" type="hidden">
                                        <button type="submit" class="btn btn-primary">提交保存</button>
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
<div aria-hidden="true" aria-labelledby="acceptModalLabel" role="dialog" tabindex="-1" id="acceptModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">抄送给?</h4>
            </div>
            <div class="modal-body">
                <label class="checkbox-inline">
                    <input data-value="1461312703628858832" data-name="李白" type="checkbox">
                    李白 </label>

                <label class="checkbox-inline">
                    <input data-value="1468140265954907628" data-name="李四" type="checkbox">
                    李四 </label>
            </div>
            <div class="modal-footer">
                <input id="testid" type="hidden">
                <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                <button class="btn btn-primary js-dialog-taskcc" type="button">确定</button>
            </div>
        </div>
    </div>
</div>
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
<script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
<script src="js/kindeditor-min.js"></script>
    <script src="js/zh-CN.js"></script>
<script>
    $(function(){
        var editor = KindEditor.create('textarea[name="desc"],textarea[name="note"]', {
            uploadJson: "/kindeditor/upload",
            allowFileManager: true,
            filterMode : false,
            afterBlur: function(){this.sync();}
        });

        $('#cc-username').val($('#cc-username').val().replace(/,$/gi,''))
        var ccidArr = $('#ccid').val().split(',');
        $('.modal-body input[type="checkbox"]').each(function(i){
            if ($.inArray($(this).attr('data-value'), ccidArr) >=0 ) {
                $(this).prop('checked', true);
            }
        });
    })
</script>
<script type="text/javascript">
//日期控制
$("#datetimeStart").datetimepicker({
       format: 'yyyy-mm-dd',
       minView:'month',
       language: 'zh-CN',
       autoclose:true,
       startDate:new Date()
   }).on("click",function(){
       $("#datetimeStart").datetimepicker("setEndDate",$("#datetimeEnd").val())
   });
   $("#datetimeEnd").datetimepicker({
       format: 'yyyy-mm-dd',
       minView:'month',
       language: 'zh-CN',
       autoclose:true,
       startDate:new Date()
   }).on("click",function(){
       $("#datetimeEnd").datetimepicker("setStartDate",$("#datetimeStart").val())
   });
</script>
</body>
</html>
    