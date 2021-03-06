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
            <h1 class="page-header">Order List</h1>

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>User Login</th>
                        <th>Status</th>
                        <th>company</th>
                        <th>contactNumber</th>
                        <th>email</th>
                        <th>deliveryAddress</th>
                        <th>Create</th>
                        <th>Update</th>
                        <th>Act</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="order" items="${orderList}" varStatus="eachStatus">
                        <tr>
                            <td>${eachStatus.index+1}</td>
                            <td><a target="_blank" href="${appPath}/admin/users/show?id=${order.userId}">${order.user.name}</a></td>
                            <td>${order.status == 0 ?"processing":"complete"}</td>
                            <td>${order.company}</td>
                            <td>${order.contactNumber}</td>
                            <td>${order.email}</td>
                            <td>${order.deliveryAddress}</td>
                            <td><fmt:formatDate value="${order.createTime}" type="both"></fmt:formatDate></td>
                            <td><fmt:formatDate value="${order.lastUpdateTime}" type="both"></fmt:formatDate></td>
                            <td><a href="${appPath}/admin/order/show?orderId=${order.id}" class="btn btn-default btn-xs" target="_blank">detail</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <c:if test="${empty orderList}">
                    <p>No Orders</p>
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
