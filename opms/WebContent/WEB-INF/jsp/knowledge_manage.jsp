<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html style="overflow: hidden;" lang="en">
<script type="text/javascript" src="js/jquery.min.js"></script>
<style type="text/css">
  #mydiv{   position:absolute;
          left:50%;
          top:50%; 
          margin-left:-200px;
          margin-top:-50px 
       } 
       #popDiv{
        position:absolute;
          left:50%;
          top:50%; 
          margin-left:-485px;
          margin-top:30px
       }
  .mouseOver{
     background:#708090;
    color:#FFFAFA;
  }
  .mouseOut{
   
    color:#000000;
  }
</style>
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet">
    <link href="css/table-responsive.css" rel="stylesheet">
</head>
<body class="sticky-header">
<% response.setHeader("contentType", "text/html; charset=utf-8");
   request.setCharacterEncoding("utf-8");
%>
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
    <div id="mydiv">
    <form  class="searchform"action="<%=request.getContextPath()%>/search" method="post">
     <input  placeholder="请输入标题、标签"class="form-control" type="text"size="50px" name="keywords" id="keyword" oninput="getMoreConents()"
           onblur="clearContent()" onfocus="getMoreConents()"/>
     <button class="btn btn-primary" type="submit" width="50px">搜索</button>
    </form>
    <!-- 内容展示区 -->
    <div id="popDiv">
      <table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0"
               cellpadding="0">
      <tbody id="content_table_body">
      <!-- 动态显示数据的地方 -->
      </tbody>
      </table>
    </div>
  </div>
          
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
                            ${user.username }
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-usermenu pull-right">
                            <li>
                                <a href="<%=request.getContextPath()%>/user_index">
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
            <h3> 知识分享 </h3>
            <ul class="breadcrumb pull-left">
                <li> <a href="<%=request.getContextPath()%>/user_index">OPMS</a> </li>
                <li> <a href="<%=request.getContextPath()%>/knowledge_manage?userid=${user.userid}">知识分享</a> </li>
                <li class="active"> 知识 </li>
            </ul>
            <div class="pull-right">
                 <input type="hidden" id="userid" value="${user.userid}">
                <a href="<%=request.getContextPath()%>/knowledge_manage?userid=${user.userid}" class="btn btn-warning">我的知识</a>
                <a href="<%=request.getContextPath()%>/all_knowledge_manage" class="btn btn-success">全部知识</a>
                <a href="<%=request.getContextPath()%>/add_knowlwdge_manage?userid=${user.userid}" class="btn btn-success">+分享知识</a>
            </div>
        </div>
        <div class="clearfix"></div>
        <div class="wrapper">
            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel">
                                <header class="panel-heading"> 精彩分享 <span class="tools pull-right"> <a class="fa fa-chevron-down" href="javascript:;"></a> </span> </header>
                                <div class="panel-body">
                                    <ul class="activity-list">
                                    <c:forEach var="list" items="${listPmsKnowledgesUser}">
                                       <li>
                                            <div class="avatar"> <a href="<%=request.getContextPath()%>/user_index"><img src="img/1.jpg"></a> </div>
                                            <div class="activity-desk">
                                                <h5>
                                                <a href="<%=request.getContextPath()%>/user_index">${list.username}</a> 
                                                <span>
                                                  <a href="<%=request.getContextPath()%>/knowledge_detail?knowid=${list.knowid}" style="color: rgb(42, 50, 63);">${list.title}</a>
                                                </span>
                                                </h5>
                                                <p class="text-muted">${list.summary}</p>
                                                <p class="pull-right text-muted"> 
                                               <c:if test="${b==a}">
                                                <a title="修改" href="<%=request.getContextPath()%>/update?knowid=${list.knowid}">
                                                 <i class="fa fa-edit"></i>
                                                 </a>
                                                 <a title="删除" href="<%=request.getContextPath()%>/del?knowid=${list.knowid}">
                                                 <i class="fa fa-trash-o"></i>
                                                 </a>
                                                 </c:if>
                                                 <i class="fa fa-eye"></i> ${list.viewnum}&nbsp;&nbsp;&nbsp;
                                                 <i class="fa fa-heart"></i>${list.comtnum}&nbsp;&nbsp;&nbsp;
                                                 <i class="fa fa-envelope-o"></i> ${list.laudnum}&nbsp;&nbsp;&nbsp;${list.created}</p>
                                            </div>
                                        </li>
                                        </c:forEach>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="blog-post">
                                <h3>分类</h3>
                                <c:set var="Sort" value="<%=com.opms.entity.PmsSort.values()%>"/>
                                     <c:forEach var="type" items="${Sort}">
                                <ul>
                                    <li><a href="<%=request.getContextPath()%>/sort?sortid=${type.index}">${type.name}</a></li>
                              </ul>
                                 </c:forEach>
                                
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

<script>
var xmlHttp;
function getMoreConents(){
	
	  //获得用户输入的数据
	  var content=document.getElementById("keyword");
	  
	 
	  if(content.value=="")
		  {
		 clearContent();
		  return ;
		  } 
	  //将用户数入的数据发送给服务器，因为采用ajax异步发送数据
	  //所以我们要使用一个对象xmlHttp
	  xmlHttp=creatXMLHttp();
	   
	 //给服务器发送数据
	  var url="search2?keyword="+content.value;//夹escape为了防止中文乱码
	//与服务器建立连接
	//true表示javaScript脚本会在send()方法之后继续执行，而不会等待来自服务器的响应
	xmlHttp.open("GET",url,false);
	//xmlHttp绑定回调函数（接收服务器响应），这个回调方法会在XMLHttp状态改变时被调用
	//因为当数据传输过程完成后（状态值为4时）再调用回调函数才有意义
	xmlHttp.onreadystatechange=callback;
	
	xmlHttp.send(null); 
	  
} 
 function creatXMLHttp(){
	 //对于大多数的浏览器
	 var xmlHttp;
	 if(window.XMLHttpRequest)
		 {
		 xmlHttp=new XMLHttpRequest();
		 }
	 //考虑浏览器的兼容性
	 if(window.ActiveXObject){
		 xmlHttp=new ActiveXObject("Microsoft.XMLHttp");
		 //如果不支持参数Microsoft.XMLHttp
		 if(!xmlHttp)
			 {
			 xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			 }
	 }
	 return xmlHttp;
}  
//回调函数
 function callback()
{
	  if(xmlHttp.readyState==4)
		  {
		  if(xmlHttp.status==200)
			  {
			  var result=xmlHttp.responseText;
			  
			  var json=eval("("+result+")");
			  setContent(json);
			  }
		  }
	 
} 
//获得关联数据的展示，参数代表服务器传过来的相关数据
 function setContent(contents)
{
	   clearContent();
	  //首先得到关联数据的长度，以此来确定生成多少<tr></tr>
	  setLocation();
	  var size=contents.length;
	  //设置内容
	  for(var i=0;i<size;i++)
		  {
		  var nextNode=contents[i];//代表的是json格式数据的第几个元素
		  var tr=document.createElement("tr");
		  var td=document.createElement("td");
		  td.setAttribute("border",0);
		  td.setAttribute("bgcolor", "#FFFAFA");
		  td.onmouseover=function(){
			  this.className='mouseOver';
		  };
		  td.onmouseout=function(){
			  this.className='mouseOut';
		  };
		  td.onmousedown = function(){ 
			   //当鼠标点击一个关联数据时，自动在输入框添加数据 
			   document.getElementById("keyword").value =this.innerText; 
			  
			   }; 
		  var text=document.createTextNode(nextNode);
		  td.appendChild(text);
		  tr.appendChild(td);
		  document.getElementById("content_table_body").appendChild(tr);
		  }
}
  function clearContent()
{
	
	  var table=document.getElementById("content_table_body");
	  var size=table.childNodes.length;
	 
	  for(var i=size-1;i>=0;i--)
		  {
		     table.removeChild(table.childNodes[i]);
		  }
	  document.getElementById("popDiv").style.border="none";
} 
  //设置显示的关联数据的位置
  function setLocation()
  {
  	var content=document.getElementById("keyword");
  	var width=content.offsetWidth;//输入框的宽度
  	var left=content["offsetLeft"];//到左边框的距离
  	var top=content["offsetTop"]+content.offsetHeight;//到顶部的距离
  	//获得显示数据的div
  	var popDiv=document.getElementById("popDiv");
  	popDiv.style.border="black 1px solid";
  	popDiv.style.left=left+"px";
  	popDiv.style.top=top+"px";
  	popDiv.style.width=width+"px";
  	document.getElementById("content_table").style.width=width+"px";
  }
</script>


</body>
</html>
