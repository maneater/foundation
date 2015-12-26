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
            <h1 class="page-header">Order Detail</h1>

            <div class="table-responsive">
                <table id="summaryTable"
                       class="table table-striped table-bordered bootstrap-datatable datatable responsive dataTable">
                    <thead>
                    <th width="80">No.</th>
                    <th width="200" colspan="2">Product</th>
                    <th width="120">Code</th>
                    <th width="150">Qty/Stock</th>
                    <th width="150">Sub Total</th>
                    </thead>
                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    <c:set target="${order}" property="totalPrice" value="0"></c:set>
                    <c:forEach var="item" items="${order.orderItemList}" varStatus="status">
                        <tr>
                            <td>${status.index+1}</td>
                            <td style="border-right: none;"><a target="_blank" href="${appPath}/admin/furniture/show?code=${item.productCode}">${item.product.name}</a></td>
                            <td style="border-left: none;"><img
                                    src="${appPath}/${dirUpload}/${item.product.thumbnailPicture}"
                                    style="width: 60px;"/></td>
                            <td>${item.productCode}</td>
                            <td>${item.qyt}</td>
                            <td>$${item.price}</td>
                            <c:set target="${order}" property="totalPrice" value="${(item.price*item.qyt)+order.totalPrice}"></c:set>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <th style="text-align: right;" colspan="5">Grand Total</th>
                    <th id="grandTotalTh">$${order.totalPrice}</th>
                    </tfoot>
                </table>
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
