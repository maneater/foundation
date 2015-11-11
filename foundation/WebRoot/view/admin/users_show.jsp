<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>${appName}</title>
    <!-- Bootstrap core CSS -->
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${appPath}/view/admin/css/index.css" rel="stylesheet">
</head>

<body>

<%@include file="topnavi.jsp" %>

<div class="container-fluid">
    <div class="row">

        <%@include file="leftmenu.jsp" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">User Information</h1>

            <form class="form-horizontal">
                <div class="form-group col-sm-12 col-md-4">
                    <label for="nick" class="control-label col-sm-2">nick</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control disabled " id="nick"
                               value="${item.nick}">
                    </div>
                </div>
                <div class="form-group col-sm-12 col-md-4">
                    <label for="login" class="control-label col-sm-2">login</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control disabled " id="login"
                               value="${item.login}" disabled>
                    </div>
                </div>

                <div class="form-group col-sm-12 col-md-4">
                    <label for="email" class="control-label  col-sm-2">email</label>

                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="email" value="${item.email}"
                               name="email">
                    </div>
                </div>

                <div class="form-group  col-sm-12 col-md-4">
                    <label for="phone" class="control-label col-sm-2">phone</label>

                    <div class="col-sm-10">
                        <input type="phone" class="form-control" id="phone" value="${item.phone}"
                               name="phone">
                    </div>
                </div>

                <div class="form-group  col-sm-12 col-md-4">
                    <label for="source" class="control-label col-sm-2">source</label>

                    <div class="col-sm-10">
                        <input type="source" class="form-control" id="source" value="${item.source}"
                               name="source">
                    </div>
                </div>

                <div class="checkbox col-sm-10">
                    <label>
                        <input type="checkbox"> Check me out
                    </label>
                </div>


                <div class="col-sm-12 ">
                    <div class="col-sm-12 col-md-4 col-md-offset-4">
                        <button type="submit" class="btn btn-primary form-control">Submit</button>
                    </div>
                </div>

            </form>
            <c:if test="${empty item}">
                <p>Not find target User</p>
            </c:if>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>

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

</body>
</html>
