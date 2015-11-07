<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>
    <!-- Bootstrap -->
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #eee;
        }

        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading, .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
    <script src="${appPath}/view/resourse/js/jquery.min.js"></script>
    <script>
        $().ready(function () {
            $("#btnLogin").bind("click", function () {
                $.ajax({
                    url: "./adminLogin",
                    dataType: "json",
                    data: {'name': $("#inputEmail").val(), 'password': $("#inputPassword").val()},
                    success: function (result) {
                        if (result.code == 1) {
                            window.location.href = "${appPath}/admin/index";
                        } else {
                            alert(result.msg);
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>

<div class="container">
    <div class="form-signin">
        <h2 class="form-signin-heading">${pageContext.request.contextPath}${isOpen?"欢迎登陆":"暂时无法服务"}</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" id="inputEmail" class="form-control" placeholder="用户名" required>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密   码" required>

        <div class="checkbox">
            <label> <input type="checkbox" id="ckRemember" value="remember-me">记住我
            </label>
        </div>
        <button id="btnLogin" class="btn btn-lg btn-primary btn-block" type="submit">
            登陆
        </button>
    </div>

</div>
<!-- /container -->
</body>
</html>