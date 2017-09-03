<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html style="overflow: hidden;" lang="en">
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript">
$(function(){
	var knowid1=$("#knowid").val();
	
	var Url="/OPMS"+"/"+"detail";
	$.ajax({
		type:"post",
		url:Url,
		data:{knowid:knowid1},
		dataType:"json",
		success:function(data){
			     var html='';
			     for(var i=0;i<data.length;i++){
				  html+='<h1 class="text-center mtop35"><a>标题</a></h1>'
				       +'<p class="text-center auth-row"> By <a href="http://opms.demo.milu365.cn/user/show/1461312703628858832">'+data[i].username+'</a> |  '+data[i].created+'</p>'
				       +'<div>'
				       +' <p style="box-sizing: inherit; margin-bottom: 16px; color: rgb(61, 70, 77); font-family: &quot;font-size:16px;white-space:normal;background-color:#F8F8F8;&quot;;">'+data[i].title+''
				       +'</p>'
				       +'</div>'
				       +'<br>'
				       +'<a class="btn p-follow-btn js-knowledge-laud" href="https://my.oschina.net/lockupme/blog/778857" target="_blank">源地址</a>'
				       +'<a class="btn p-follow-btn js-knowledge-laud" href="<%=request.getContextPath()%>/laud?knowid='+data[i].knowid+'" data-id="66618679508340736"> <i class="fa fa-heart"></i>'+data[i].laudnum+'</a>&nbsp;'
					   +'<a class="btn p-follow-btn" href="#commenta"> <i class="fa fa-envelope-o"></i>'+data[i].comtnum+'</a>&nbsp;'
					   +'<a class="btn p-follow-btn" href=":;"> <i class="fa fa-eye"></i>'+data[i].viewnum+'</a>'
					   +'<ul class="p-social-link pull-right bdsharebuttonbox bdshare-button-style0-32" data-bd-bind="1499943261073">'
					   +'<li><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a></li>'
                       +'<li><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a></li>'
                       +'<li><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></li>'
                       +'</ul>';  
			     }
			 $('#div11').append(html);
		}
	});
});

$(function(){
var knowid1=$("#knowid").val();
	
	var Url="/OPMS"+"/"+"list";
	$.ajax({
		type:"post",
		url:Url,
		data:{knowid:knowid1},
		dataType:"json",
		success:function(data){
			var html='';
			for(var i=0;i<data.length;i++)
				{
				   html+='<li>'
				       +'<div class="avatar">'
				       +'<a href="">'
				       +'<img src="img/5b41faa955a4c1acdb6d7e6c116bce2f-cropper.jpg">'
				       +'</a>'
				       +'<div class="activity-desk">'
				       +'<h5>'
				       +'<a href="http://opms.demo.milu365.cn/user/show/1461312703628858832">${user.username}</a>'
				       +'<span>:'+data[i].content+'</span></h5>'
				       +'<p class="text-muted">'+data[i].created+'</p>'
				       +'</div>'
				       +'</li>';
				}
			$('#ul1').append(html);
		}
		});
});

function ckme(){
	var comments=$('.form-control').val();
	if(comments=='')
	{
		 $('#knowledge-comment-form1').validate({
		    ignore:'',		    
			rules : {
				comment:{required:true}
		    },
		    messages : {
				comment:{required:'请填写评论内容'}
		    },
		    }); 
	}
	else{
		alert("评论成功");
		
		   /* dialogInfo("评论成功");
       
			setTimeout(function(){window.location.reload();}, 2000); */
       
		
		
		document.getElementById("knowledge-comment-form1").submit();
	}
}
</script>
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <script src="js/share.js"></script>
    <link rel="stylesheet" href="css/share_style0_32.css">
    <script src="js/share_001.js"></script>
    <link rel="stylesheet" href="css/share_style0_32_001.css">
</head>
<body class="sticky-header">
<input id="knowid" value="${knowid}">
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
                            ${user.username}
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
           
            <h3> 知识分享 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="user_index.html">OPMS</a> </li>
                <li> <a href="knowledge_manage.html">知识分享</a> </li>
                <li class="active"> 知识 </li>
            </ul>
        </div>
        <div class="clearfix"></div>
        <div class="wrapper">
            <div class="row">
                <div class="row">
                    <div class="blog">
                        <div class="col-md-12">
                            <div class="panel">
                                <div class="panel-body">
                                   <div class="single-blog" id="div11">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel">
                            <header class="panel-heading"> 精彩点评 <span class="tools pull-right"> <a class="fa fa-chevron-down" href="javascript:;"></a> </span> </header>
                            <div class="panel-body">
                                <ul class="activity-list" id="ul1">
 
                                </ul>
                                <form class="form-horizontal" id="knowledge-comment-form1"  novalidate="novalidate"action="<%=request.getContextPath()%>/comment" method="post">
                                    <a name="commenta"></a>
                                    <div class="form-group">
                                        <div class="col-sm-12">
                                            <textarea name="comment" rows="6" class="form-control" placeholder="精彩评论不断……"></textarea>
                                            <br>
                                            <input class="userid" name="userid" type="hidden" value="${userid}">
                                            <input class="knowid" name="knowid" value="${knowid}" type="hidden">
                                            <button type="button" id="btnConfirm" class="btn btn-primary pull-right" onclick='ckme()'>我来点评</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
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
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
</body>
</html>
