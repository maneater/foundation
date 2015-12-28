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
            <h1 class="page-header">${room.name} view editor
                <button class="btn btn-default btn-warning" style="float: right;" onclick="saveCanvas();">Save</button>
            </h1>
            <div class="form-group col-sm-12" id="controlDiv">
                <c:forEach items="${room.productCategoryList}" var="category">
                    <label><input value="${category.id}" type="checkbox" onchange="changeCategoryShow(this);"
                                  <c:if test="${category.productCategoryPosition!=null}">checked="true"</c:if>/>${category.name}
                    </label>
                </c:forEach>
            </div>
            <div class="col-sm-12" id="canvasDiv">
                <img src="${appPath}/${dirUpload}/${room.picUrl}">
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

    var viewPosition = {roomId: "${room.id}", positions: new Array()}

    <fd:toJs argName="categoryList" argObj="${room.productCategoryList}"></fd:toJs>

    <c:forEach items="${room.productCategoryList}" var="category">
    <c:if test="${category.productCategoryPosition!=null}">
    <fd:toJs argName="tmpPosition" argObj="${category.productCategoryPosition}"></fd:toJs>
    viewPosition.positions.push(tmpPosition);
    </c:if>
    </c:forEach>

    function CategoryPosition() {
        this.roomId =${room.id};
        this.productCategoryId = null;
        this.x = 0;
        this.y = 0;
        this.zIndex = 0;
    }

    function changeCategoryShow(ele) {
        //添加或删除家具
        var checked = ele.checked;
        var categoryId = $(ele).val();
        if (checked) {
            var categoryPosition = new CategoryPosition();
            categoryPosition.productCategoryId = categoryId;
            categoryPosition.x = 10;
            categoryPosition.y = 11;
            categoryPosition.zIndex = 1;
            viewPosition.positions.push(categoryPosition);
        } else {
            for (var index = 0; index < viewPosition.positions; index++) {
                if (viewPosition.positions[index].productCategoryId == categoryId) {
                    viewPosition.positions.slice(index, 1);
                    index--;
                }
            }
        }
        console.info(viewPosition.positions.length);
    }


    function saveCanvas() {
        $.ajax({
            url: "${appPath}/admin/room/saveview",
            type: "post",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            data: JSON.stringify(viewPosition),
            success: function (result) {
                alert(result.msg);
            },
            error: function (xhr, err) {
                alert(err);
            }
        });
    }

</script>
</body>
</html>
