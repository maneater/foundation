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
            <h1 class="page-header">Room List</h1>


            <a href="${appPath}/admin/room/add">Add</a>

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Picture</th>
                        <th>Model</th>
                        <th>Act</th>
                        <th>LastUpdate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${itemList}">
                        <tr>
                            <td>${item.id}</td>
                            <td><img src="${item.name}" alt="" style="width: 60px;height:60px;"
                                     class="img-rounded"/></td>
                            <td>${item.categoryName}</td>
                            <td>${item.picUrl}</td>
                            <td>${item.modelPath}</td>
                            <td>
                                <a href="${appPath}/admin/room/show?id=${user.id}"
                                   class="btn btn-default btn-xs" target="_self">查看</a>
                                <button app-data="${item.id}|${item.enable}" type="button"
                                        class="btn btn-warning btn-xs" title="当前停用">已禁用
                                </button>
                            </td>
                            <td>
                                    ${item.lastUpdateTime}
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
                <c:if test="${empty itemList}">
                    <p>No Rooms</p>
                </c:if>
            </div>
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
