<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="common.jsp" %>

<html>
<head>
    <link href="${appPath}/view/resourse/css/bootstrap.min.css" rel="stylesheet">
    <link href="${appPath}/view/admin/css/index.css" rel="stylesheet">
    <style>
        body {
            padding: 0;
        }
    </style>
</head>
<body>

<div class="container-fluid" style="padding-top: 0px;">
    <form id="uploadForm" class="form-horizontal" style="padding: 10px;" enctype="multipart/form-data">
        <div class="input-group">
            <input type="file" class="form-control" name="file">
              <span class="input-group-btn">
                <button id="btnUpload" class="btn btn-default" type="button">upload</button>
              </span>
        </div>
        <input type="hidden" name="filePath" value="${parentInfo.filePath}">
    </form>

    <c:forEach items="${itemList}" var="item" varStatus="status">
        <div class="pull-left" style="margin-left: 15px;width: 180px;">
            <div class="thumbnail" style="padding: 10px;">
                <c:if test="${item.img}">
                    <img src="${appPath}/upload/${item.filePath}" alt="${item.filePath}"
                         style="width: 100px;height: 100px;">
                </c:if>
                <c:if test="${item.dir}">
                    <img src="${appPath}/view/resourse/img/icon_dir.png" alt="${item.filePath}"
                         style="width: 100px;height: 100px;">
                </c:if>
                <c:if test="${item.zip}">
                    <img src="${appPath}/view/resourse/img/icon_zip.png" alt="${item.filePath}"
                         style="width: 100px;height: 100px;">
                </c:if>
                <c:if test="${!(item.zip||item.dir||item.img)}">
                    <img src="${appPath}/view/resourse/img/icon_unknown.png" alt="${item.filePath}"
                         style="width: 100px;height: 100px;">
                </c:if>

                <p>${item.fileName}</p>

                <div class="btn-group btn-group-xs pull-right" role="group" aria-label="...">

                    <c:choose>
                        <c:when test="${item.img || item.zip}">
                            <button type="button" class="btn btn-info" onclick="useUpload('${item.filePath}');">use
                            </button>
                        </c:when>
                        <c:otherwise>
                            <button type="button" class="btn btn-info">use
                            </button>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${item.dir}">
                            <a target="_self" href="${appPath}/admin/upload/index?filePath=${item.filePath}"
                               class="btn btn-primary">open</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${appPath}/upload/${item.filePath}" target="_blank"
                               class="btn btn-primary">open</a>
                        </c:otherwise>
                    </c:choose>

                    <button type="button" class="btn btn-danger"
                            onclick="deleteUpload(this,'${item.filePath}');">
                        delete
                    </button>
                </div>
            </div>
        </div>
    </c:forEach>

    <c:if test="${empty itemList}">
        no files;
    </c:if>
</div>

</body>
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>
<script src="${appPath}/view/admin/js/submit.js"></script>
<script>

    function useUpload(filePath) {
        window.parent.useUpload(filePath);
    }

    function deleteUpload(ele, filePath) {
        var invokeBtn = $(ele);
        console.info(invokeBtn);
        invokeBtn.attr("disabled", true);
        invokeBtn.text("delete...");
        submitParams("${appPath}/admin/upload/delete", "filePath=" + filePath, function (result) {
            if (result && result.code == 1) {
                var target = invokeBtn.parent().parent().parent();
                target.fadeOut(function () {
                    target.remove();
                    target.detach();
                });
            } else {
                alert(result.msg);
                invokeBtn.text("delete");
                invokeBtn.attr("disabled", false);
            }
        });
    }

    $().ready(function () {
        $("#btnUpload").bind("click", function () {
            var formData = new FormData($("#uploadForm")[0]);
            $.ajax({
                url: '${appPath}/admin/upload/upload',
                type: 'POST',
                data: formData,
                async: false,
                cache: false,
                contentType: false,
                processData: false,
                success: function (result) {
                    window.location.reload();
                },
                complete: function (xhr, status) {
                    if (xhr.status != 200) {
                        alert(status);
                    }
                }
            });

            <%--submitParams("${appPath}/admin/upload/upload", formData, function (result) {--%>
            <%--alert(result.msg);--%>
            <%--})--%>
        });
    });
</script>
</html>
