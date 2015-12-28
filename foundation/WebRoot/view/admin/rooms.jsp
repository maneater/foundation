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
                        <th>Act</th>
                        <th>LastUpdate</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${itemList}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.categoryName}</td>
                            <td><img src="${appPath}/${dirUpload}/${item.picUrl}" alt="" style="width: 60px;height:60px;"
                                     class="img-rounded"/></td>
                            <td>
                                <a href="${appPath}/admin/room/show?id=${item.id}"
                                   class="btn btn-default btn-xs" target="_self">detail</a>
                                <a href="${appPath}/admin/room/showview?id=${item.id}"
                                   class="btn btn-default btn-xs" target="_self">view eidt</a>
                                <button onclick="changeEnable(this);" value="${item.enable}"
                                        data-id="${item.id}"
                                        class="btn ${item.enable?"btn-info":"btn-warning"} btn-xs "
                                        title="click for change">${item.enable?"enabled":"disabled"}
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
<script src="${appPath}/view/admin/js/submit.js"></script>
<script>
    function changeEnable(ele) {
        var invokeBtn = $(ele);
        var id = invokeBtn.attr("data-id");
        var value = !("true" == invokeBtn.val());
        invokeBtn.attr("disabled", true);
        invokeBtn.text("loading...");
        submitParams("./enable", "id=" + id + "&enable=" + value, function (result) {
            if (result && result.code == 1) {
                invokeBtn.val(value);
                invokeBtn.button("complete");
                if (value) {
                    invokeBtn.text('enabled');
                    invokeBtn.removeClass("btn-warning");
                    invokeBtn.addClass("btn-info")
                } else {
                    invokeBtn.removeClass("btn-info");
                    invokeBtn.addClass("btn-warning")
                    invokeBtn.text('disabled');
                }
            } else {
                alert(result.msg);
            }
            invokeBtn.attr("disabled", false);
        });
    }
</script>
</body>
</html>
