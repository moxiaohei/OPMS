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

    <link rel="shortcut icon" href="<%=request.getContextPath() %>/img/favicon.ico" type="<%=request.getContextPath() %>/image/png">
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/style-responsive.css" rel="stylesheet">

    <link href="<%=request.getContextPath() %>/css/table-responsive.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/demo_table.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/css/DT_bootstrap.css" rel="stylesheet">
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
            <form action="searchBug" class="searchform" method="post">
                <input type="hidden" name="projectid" value="${id}"/>
                <select name="status" class="form-control">
                    <option style="display:none" checked value="0">状态</option>
                    <option value="1">设计如此</option>
                    <option value="2">重复Bug</option>
                    <option value="3">外部原因</option>
                    <option value="4">已解决</option>
                    <option value="5">无法重现</option>
                    <option value="6">延期处理</option>
                    <option value="7">不予解决</option>
                </select>
                <select name="acceptid" class="form-control">
                    <option style="display:none" checked value="0">指派给</option>
                    <c:forEach items="${acceptUser}" var="user"> 
                        <option value="${user.acceptid}">${user.acceptPeople}</option>
                    </c:forEach>
                </select>
                <input class="form-control" name="name" placeholder="请输入名称" value="" type="text">
                <input type="submit" class="btn btn-primary" value="搜索"></input>
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
                            <img src="<%=request.getContextPath() %>/img/96d7546cbe9cbe9e36ce11ffd9afcc95-cropper.jpg" alt="libai">
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
                                <a href="">
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
                <li> <a href="listProjectInfo?projectid=${id}">项目管理</a> </li>
                <li class="active"> Bug </li>
            </ul>
            <div class="pull-right">
                <a href="listPmsProjectsBug?projectid=${id}" class="btn btn-default active">全部</a>
                <a href="searchByAppoint?acceptid=${user.userid}&projectid=${id}" class="hidden-xs btn btn-default ">指派给我</a>
                <a href="serachByMyCreate?userid=${user.userid}&projectid=${id}" class="hidden-xs btn btn-default ">由我创建</a>
                <a href="serachByMySolve?completeid=${user.userid}&projectid=${id}" class="hidden-xs btn btn-default ">由我解决</a>
                <a href="skip?projectid=${id}" class="btn btn-success">+提Bug</a></div>
        </div> 
        <div class="wrapper">
            <div class="row">
                <div class="col-sm-12">
                    <section class="panel">
                        <header class="panel-heading"> 测试 / 总数：${count}<span class="tools pull-right"><a href="javascript:;" class="fa fa-chevron-down"></a>
              </span> </header>
                        <div class="panel-body">
                            <section id="unseen">
                                    <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row-fluid"><div class="span6"></div><div class="span6"></div></div><table class="table table-bordered table-striped table-condensed dataTable" id="dynamic-table">
                                        <thead>
                                        <tr role="row">
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 69px;" aria-label="级别: activate to sort column ascending">级别</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 153px;" aria-label="Bug标题: activate to sort column ascending">Bug标题</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 69px;" aria-label="状态: activate to sort column ascending">状态</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 94px;" aria-label="创建人: activate to sort column ascending">创建人</th>
                                            <th class="hidden-xs sorting_desc" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 141px;" aria-sort="descending" aria-label="创建日期: activate to sort column ascending">创建日期</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 94px;" aria-label="指派人: activate to sort column ascending">指派人</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 94px;" aria-label="解决人: activate to sort column ascending">解决人</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 120px;" aria-label="解决日期: activate to sort column ascending">解决日期</th>
                                            <th class="sorting" role="columnheader" tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1" style="width: 143px;" aria-label="操作: activate to sort column ascending">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody role="alert" aria-live="polite" aria-relevant="all">
	                                        <c:forEach items="${listbug }" var="bug">
	                                            <input type="hidden" name="projectid" value="${bug.projectid}">
	                                        <tr class="odd">
	                                            <td class=" "><span class="label label-warning">${bug.level}</span></td>
	                                            <td class=" "><a href="">${bug.name}</a></td>
	                                            <td class=" ">${bug.state}</td>
	                                            <td class=" "><a href="">${bug.createUser}</a></td>
	                                            <td class="hidden-xs  sorting_1">${bug.getCreateDate()}</td>
	                                            <td class=" "><a href="">${bug.acceptPeople}</a></td>
	                                            <td class=" "><a href="">${bug.completePeople}</a></td>
	                                            <td class=" ">${bug.getCompleteDate()}</td>
	                                            <td class=" ">
	                                                <a href="#acceptModal" data-toggle="modal" data-id="${bug.projectid},${bug.testid}" title="指派" class="btn btn-warning btn-xs"><i class="fa fa-hand-o-right"></i></a>
	                                                <a href="#completeModal" data-toggle="modal" data-id="${bug.testid}" title="完成" class="btn btn-info btn-xs"><i class="fa fa-check-square"></i></a>
	                                                <a href="getPmsProjectsBug?testid=${bug.testid}" title="编辑" class="btn btn-danger btn-xs"><i class="fa fa-pencil-square-o"></i></a> </td>
	                                        </tr>
	                                        </c:forEach>
                                        </tbody>
                                    </table>
                                        <div class="row-fluid">
                                            <div class="span6"></div>
                                            <div class="span6"></div>
                                        </div>
                                    </div>
                            </section>
                        </div>
                    </section>
                </div>
            </div>
        </div>
      <form action="dispatchPeople" method="post">
        <input type="hidden" value="${id}" name="projectid"/>
        <div aria-hidden="true" aria-labelledby="acceptModalLabel" role="dialog" tabindex="-1" id="acceptModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">测试指派给?</h4>
                    </div>
                    <div class="modal-body">
                        <select id="acceptid" class="form-control" name="acceptid">
                            <option value="0" style="display:none;" checked>请选择指派给</option>
                        </select>
                        <p></p>
                        <textarea name="bugdesc" id="note" placeholder="备注说明" style="height: 90px;" class="form-control"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input id="testid" value="105144705259409408" type="hidden">
                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        <input class="btn btn-primary js-dialog-testaccept" type="submit" value="提交"></input>
                    </div>
                </div>
            </div>
        </div>
      </form>
        <div aria-hidden="true" aria-labelledby="completeModalLabel" role="dialog" tabindex="-1" id="completeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title">解决方案</h4>
                    </div>
                  <form action="resolvent" method="post">
                    <input type="hidden" value="${id}" name="projectid"/>
                    <div class="modal-body">
                        <select id="cstatus" class="form-control" name="status">
                            <option style="display:none;" checked value="0">解决方案</option>
                            <option value="1">设计如此</option>
                            <option value="2">重复Bug</option>
                            <option value="3">外部原因</option>
                            <option value="4">已解决</option>
                            <option value="5">无法重现</option>
                            <option value="6">延期处理</option>
                            <option value="7">不予解决</option>
                        </select>
                        <p></p>
                        <textarea name="bugdesc" id="cnote" placeholder="备注说明" style="height: 90px;" class="form-control"></textarea>
                    </div>
                    <div class="modal-footer">
                        <input id="ctestid" value="105144705259409408" type="hidden">
                        <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                        <input class="btn btn-primary js-dialog-testcomplete" type="submit" value="提交"></input>
                    </div>
                  </form>
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
<script src="<%=request.getContextPath() %>/js/jquery.validate.js"></script>
<script src="<%=request.getContextPath() %>/js/opms.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/DT_bootstrap.js"></script>
<script src="<%=request.getContextPath() %>/js/dynamic_table_init.js"></script>
<script>
    $(function(){
        $('#acceptModal').on('show.bs.modal', function (e) {
        	findDispatchPeople($(e.relatedTarget).attr('data-id'));
            $('#testid').val($(e.relatedTarget).attr('data-id'))
        });
        $('#completeModal').on('show.bs.modal', function (e) {
        	addTestId($(e.relatedTarget).attr('data-id'));
            $('#ctestid').val($(e.relatedTarget).attr('data-id'))
        });
    })
    function abc() {
		alert(1);
	}
   //解决方案窗口添加bugID
   function addTestId(testid){
	   var cstatus=document.getElementById("cstatus");
	   var inp=document.createElement("input");
		inp.type="text";
		inp.value=testid;
		inp.name="testid";
		cstatus.appendChild(inp);
   }
   function findDispatchPeople(str){
	    var a=str.split(",");
	    var projectid=a[0];
	    var testid=a[1];
    	var httpRequest=new XMLHttpRequest;
    	var accept=document.getElementById("acceptid");
		httpRequest.onreadystatechange=function(){
			if(httpRequest.readyState==4 & httpRequest.status==200){
				accept.innerHTML="";
				var text=httpRequest.responseText;
				var obj=eval("("+text+")");
				
				var inp=document.createElement("input");
				inp.type="text";
				inp.value=testid;
				inp.name="testid";
				accept.appendChild(inp);
				
				for(var i=0;i<obj.length;i++){
					var op=document.createElement("option");
					op.text=obj[i].username;
					op.value=obj[i].userid;
					accept.appendChild(op);
				}
			}
		}
		httpRequest.open("POST","getdispatchPeople?projectid="+projectid,true);
		httpRequest.send(null);
    }
</script>
</body>
</html>
