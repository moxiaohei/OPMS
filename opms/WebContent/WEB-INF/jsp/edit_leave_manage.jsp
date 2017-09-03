<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow: hidden;" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link href="css/datepicker-custom.css" rel="stylesheet">
    <style>
        /* Code tidied up by ScrapBook */
        .form-group .fa { font-size: 66px; }
        .js-selectuserbox a { border-radius: 50px; width: 60px; height: 70px; text-align: center; vertical-align: middle; display: inline-block; }
        .js-selectuserbox img { width: 60px; height: 60px; border-radius: 50%; }
    </style>
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
            <h3> 审批管理
                <span>
                    <a href="leavemanage">请假</a>
                    <a href="overtimemanage">加班</a>
                    <a href="expensemanage">报销</a>
                    <a href="businesstripmanage">出差</a>
                    <a href="gooutmanage">外出</a>
                    <a href="oagood_manage">物品</a>
                </span>
            </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="user_index.html">OPMS</a> </li>
                <li> <a href="approvalindex">审批管理</a> </li>
                <li class="active"> 请假 </li>
            </ul>
        </div>
        <div class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <section class="panel">
                        <header class="panel-heading">  </header>
                        <div class="panel-body">
                            <div class="alert alert-block alert-danger fade in">
                                <button type="button" class="close close-sm" data-dismiss="alert"> <i class="fa fa-times"></i> </button>
                                <strong>注意!</strong> 请假单状态为正常后(可在列表操作中设置为“正常”)，就不能再编辑！后续流程等待审批人操作。. </div>
                            <form class="form-horizontal adminex-form" id="leave-form" novalidate="novalidate" action="updateLeaveInfo" method="post">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>类型</label>
                                    <div class="col-sm-10">
                                        <select name="type" class="form-control" >
                                            <option value="">请选择类型</option>
                                            <option value="1" >事假</option>
                                            <option value="2">病假</option>
                                            <option value="3">年假</option>
                                            <option value="4">调休</option>
                                            <option value="5">婚假</option>
                                            <option value="6">产假</option>
                                            <option value="7">陪产假</option>
                                            <option value="8">路途假</option>
                                            <option value="9">其他</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>请假日期</label>
                                    <div class="col-sm-10">
                                        <div class="input-group input-large custom-date-range" data-date="2016-07-07" data-date-format="yyyy-mm-dd">
                                            <input id="datetimeStart"  class="form-control dpd1" name="started" placeholder="开始日期" value="<fmt:formatDate value='${editleave.started }' type='date' pattern='yyyy-MM-dd'/>" type="text">
                                            <span class="input-group-addon">To</span>
                                            <input id="datetimeEnd" class="form-control dpd2" name="ended" placeholder="结束日期" value="<fmt:formatDate value='${editleave.ended }' type='date' pattern='yyyy-MM-dd'/>" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">请假天数</label>
                                    <div class="col-sm-10">
                                        <input name="days" value="<fmt:formatNumber value='${editleave.days }' pattern='0'/>" class="form-control" placeholder=" " type="number" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><span>*</span>请假事由</label>
                                    <div class="col-sm-10">

                                        <textarea name="reason" placeholder="" style="height: 200px;" class="form-control">${editleave.reason}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label">图片</label>
                                    <div class="col-sm-10">
                                        <input type="file" id="image" >
                                       <input  name="picture" type="hidden" id="picturepath">
                                       <div id="imageshow"style="width:118px;height:68px;position:relative;overflow:hidden;"> <img id="imagebefor" src="${editleave.picture }" style="width:120px;height:70px;position:absolute;top:-1px;left:-1px;" ></div> 
                              
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-lg-2 col-sm-2 control-label"></label>
                                    <div class="col-lg-10">
                                        <input name="approverids" id="approverid" value="${editleave.approverids}" type="hidden">
                                        <input name="leaveid" id="leaveid" value="${editleave.leaveid }" type="hidden">
                                        <button type="submit" class="btn btn-primary">提交保存</button>
                                    </div>
                                </div>
                            </form>
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
                        <h4 class="modal-title">审批人</h4>
                    </div>
                    <div class="modal-body">
                        <ul class="list-unstyled">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <style>
            /* Code tidied up by ScrapBook */
            .modal-body { max-height: 470px; overflow: auto; }
            .modal-body img { width: 50px; height: 50px; border-radius: 50%; margin-right: 20px; }
            .modal-body li { margin-bottom: 6px; border-bottom: 1px solid rgb(221, 221, 221); padding-bottom: 6px; }
            .modal-body a { display: block; text-decoration: none; }
        </style>
        <footer> 2016 © Admin by Lock &nbsp;&nbsp;<a href="">OPMS官网</a> · <a href="">OPMS手册</a></footer>
    </div>
</section>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; opacity: 0;">
    <div style="position: relative; top: 0px; float: right; width: 6px; height: 308px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; height: 6px; width: 1215px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2001" class="nicescroll-rails" style="width: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; left: 137px; height: 555px; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; float: right; width: 3px; height: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2001-hr" class="nicescroll-rails" style="height: 3px; z-index: 100; background: rgb(66, 79, 99) none repeat scroll 0% 0%; top: 552px; left: 0px; position: fixed; cursor: default; display: none; opacity: 0;">
    <div style="position: relative; top: 0px; height: 3px; width: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px; left: 0px;"></div>
</div>
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>
<script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
<script>
    $(function(){
    	
    	
    	
    	$("#image").change(function(){
    		//$("#imagebefor").remove();
    		var imagepath=$("#image").val();
			$.ajax({
				url : 'uploadPicture',
				type:'post',
			    dataType:'json',
			    data:{image:imagepath},
				success : function(data){
					$("#picturepath").val(data);
					var html="<img  src="+data+" style="+"width:120px;height:70px"+ ">"
					$('#imagebefor').append(html);
					 
				}
			});
			
		});		
    	
    	
    	
    	
    	
    	$("select").val("${editleave.type }");
        $('.js-selectuser').on('click', function(){
            var that = $(this);
            var userid = that.attr('data-id');
            var realname = that.attr('data-name');
            var avatar = that.find('img').attr('src');

            var approverid = $('#approverid').val();
            if(approverid.indexOf(userid) > 0 ){
                $('#acceptModal').modal('hide')
                dialogInfo('审批人已经添加过');
                return false;
            }

            var html = '';
            html += '<a href="javascript:;" data-id="'+userid+'"><img src="'+avatar+'"><span>'+realname+'</span></a><span>..........</span>';
            if ($('.js-selectuserbox').find('a img').size()) {
                $('.addAvatar').before(html);
            } else {
                $('.js-selectuserbox').prepend(html);
            }
            $('#approverid').val(approverid+','+userid);

            $('#acceptModal').modal('hide')
        });

        $('.js-selectuserbox').delegate('a img', 'click',function(){
            var that = $(this);

            var approverid = $('#approverid').val();
            var userid = that.parent().attr('data-id');
            result = approverid.replace(eval("/,?"+userid+",?/"),' ').trim(' ').replace(' ',',');
            $('#approverid').val(result);

            that.parent().next('span').remove();
            that.parent().remove();
        });


        $('.addAvatar').on('show.bs.modal', function (e) {

        })

        var nowTemp = new Date();
        var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

        var checkin = $('.dpd1').datepicker({
            format: 'yyyy-mm-dd',
            onRender: function(date) {
                return date.valueOf() < now.valueOf() ? 'disabled' : '';
            }
        }).on('changeDate', function(ev) {
            if (ev.date.valueOf() > checkout.date.valueOf()) {
                var newDate = new Date(ev.date)
                newDate.setDate(newDate.getDate() + 1);
                checkout.setValue(newDate);
            }
            checkin.hide();
            $('.dpd2')[0].focus();
        }).data('datepicker');
        var checkout = $('.dpd2').datepicker({
            format: 'yyyy-mm-dd',
            onRender: function(date) {
                return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
            }
        }).on('changeDate', function(ev) {
            checkout.hide();
        }).data('datepicker');
        
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
        
        
    })
</script>

</body>
</html>
>