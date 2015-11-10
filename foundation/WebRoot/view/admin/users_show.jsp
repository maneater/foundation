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

            <form class="form-inline ">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <td>
                                <label for="nick" class="control-label col-xs-2"
                                       style="vertical-align: middle;">nick</label>

                                <div class="col-xs-10">
                                    <input type="text" class="form-control disabled " id="nick"
                                           value="${item.nick}">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="email">email</label>
                                    <input type="email" class="form-control" id="email" value="${item.email}"
                                           name="email">
                                    <label for="phone">email</label>
                                    <input type="text" class="form-control" id="phone" value="${item.phone}"
                                           name="phone">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="form-group">
                                    <label for="from">Login</label>
                                    <input type="text" class="form-control" id="from" name="source"
                                           value="${item.source}">
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </td>
                        </tr>
                        </tbody>
                    </table>
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
</body>
</html>
