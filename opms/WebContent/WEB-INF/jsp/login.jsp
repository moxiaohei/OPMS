<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en">
<head>
    <meta charset="UTF-8">
    <title>OPMS管理系统</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <meta name="author" content="lock">
    <link rel="shortcut icon" href="img/favicon.ico" type="image/png">
    <link href="css/style.css" rel="stylesheet">

    <style>
        /* Code tidied up by ScrapBook */
        .form-signin .help-block { color: rgb(169, 68, 66); }
    </style>
</head><body class="login-body">
<div class="container">
    <form class="form-signin" id="login-form" novalidate="novalidate" action="signin" >
        <div class="form-signin-heading text-center">
            <h1 class="sign-title">登录OPMS</h1>
            <img src="img/logo.png" alt="OPMS" style="width: 120px;"> </div>
        <div class="login-wrap">
            <input class="form-control" name="username" placeholder="请填写用户名" autofocus="" type="text">
            <input class="form-control" name="password" placeholder="请填写密码" type="password">
            <button class="btn btn-lg btn-login btn-block" type="submit" value="">登录</button>
        </div>
    </form>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<div id="ascrail2000" class="nicescroll-rails" style="width: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; cursor: default; position: fixed; top: 0px; height: 100%; right: 0px; display: none;">
    <div style="position: relative; top: 0px; float: right; width: 6px; height: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<div id="ascrail2000-hr" class="nicescroll-rails" style="height: 6px; z-index: 1000; background: rgb(66, 79, 99) none repeat scroll 0% 0%; position: fixed; left: 0px; width: 100%; bottom: 0px; cursor: default; display: none;">
    <div style="position: relative; top: 0px; height: 6px; width: 0px; background-color: rgb(101, 206, 167); border: 0px none; background-clip: padding-box; border-radius: 0px;"></div>
</div>
<script src="js/jquery.validate.js"></script>
<script src="js/opms.js"></script>


</body>
</html>
