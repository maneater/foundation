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
    <style type="text/css">
        td {
            vertical-align: middle;
        }
    </style>
</head>

<body>

<%@include file="topnavi.jsp" %>

<div class="container-fluid">
    <div class="row">

        <%@include file="leftmenu.jsp" %>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">User List</h1>

            ${pagePagination}

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nick</th>
                        <th>Login</th>
                        <th>Head</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>From</th>
                        <th>Act</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>${user.id}</td>
                            <td><img src="${user.headPicUrl}" alt="" style="width: 60px;height:60px;"
                                     class="img-rounded"/></td>
                            <td>${user.nick}</td>
                            <td>${user.login}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td>${user.source}</td>
                            <td>
                                <a href="${appPath}/admin/users/show?id=${user.id}"
                                   class="btn btn-default btn-xs" target="_self">查看</a>
                                <button app-data="${user.id}|${user.source}" type="button"
                                        class="btn btn-warning btn-xs" title="当前停用">已禁用
                                </button>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <c:if test="${empty userList}">
                    <p>No User</p>
                </c:if>
            </div>
            ${pagePagination}
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
