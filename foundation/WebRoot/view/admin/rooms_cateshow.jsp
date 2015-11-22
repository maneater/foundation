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
            <h3 class="page-header">${isAdd?"Add Room Category":"Room Category Information"}</h3>

            <form class="form-horizontal" id="itemForm">

                <input type="hidden" name="id" value="${item.id}">


                <div class="form-group col-sm-12 ">
                    <label for="name" class="control-label  col-sm-2">Name</label>

                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" value="${item.name}"
                               name="name">
                    </div>
                </div>

                <c:if test="${!isAdd}">
                    <div class="form-group col-sm-12 ">
                        <label for="createTime" class="control-label  col-sm-2">CreateTime</label>

                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="createTime" value="${item.createTime}"
                                   disabled>
                        </div>
                    </div>
                    <div class="form-group col-sm-12 ">
                        <label for="lastUpdate" class="control-label  col-sm-2">LastUpdate</label>

                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="lastUpdate" value="${item.lastUpdateTime}"
                                   disabled>
                        </div>
                    </div>
                </c:if>

                <div class="form-group col-sm-12 ">
                    <label for="picUrl" class="control-label  col-sm-2">Picture</label>

                    <div class="col-sm-9">
                        <img id="itemImg" src="${appPath}/${dirUpload}/${item.picUrl}" alt=""
                             style="width: 150px;height:150px;"
                             class="img-rounded"/>
                        <input id="btnChoosePicture" type="button" id="picUrl"
                               class="btn btn-sm btn-primary form-inline" value="change picture"></button>
                        <input id="itemPicUrl" type="hidden" name="picUrl" value="${item.picUrl}">
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="info" class="control-label  col-sm-2">Info</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="info" value="${item.info}"
                               name="info">
                    </div>
                </div>


                <div class="form-group col-sm-12 ">
                    <label for="enable" class="control-label  col-sm-2">Enable</label>

                    <div class="col-sm-9">
                        <label class="radio-inline">
                            <input type="radio" name="enable" id="enable" value="true" ${item.enable?"checked":""}>enable
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="enable" value="false" ${item.enable?"":"checked"}>disable
                        </label>
                    </div>
                </div>


                <div class="col-sm-12 ">
                    <div class="col-sm-12 col-md-4 col-md-offset-4">
                        <button type="button" data-toggle="modal" data-target="#confirmModal"
                                class="btn btn-primary form-control">Submit
                        </button>
                    </div>
                </div>

            </form>
            <c:if test="${(!isAdd) && (empty item) }">
                <p>Not find</p>
            </c:if>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" style="top:20%;" id="confirmModal" tabindex="-1" role="dialog" aria-hidden="true"
     data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Notification</h4>
            </div>
            <div class="modal-body" id="#confirmModalContent">
                Are your confirm ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="btnCancel" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary" id="btnConfirm">Confirm</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<div class="modal fade" style="" id="choosePictureModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%;height: 80%;">
        <div class="modal-content" id="chooseContent" style="height: 100%;">
            <div class="modal-body" style="height: 90%;">
                <h3>Choose Category Picture</h3>
                <iframe id="iframe" width="100%" height=100%" frameborder="0"></iframe>
            </div>
        </div>
    </div>
</div>
<!-- /.modal -->

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>
<script src="${appPath}/view/admin/js/submit.js"></script>

<script>

    var appPath = '${appPath}';

    $().ready(function () {

        $("#btnChoosePicture").bind("click", function () {
            $("#choosePictureModal").modal('show');
            $("#iframe").attr("src", '${appPath}/admin/upload?filePath=${dirRoomCatePic}');
            <%--$("#chooseContent").load("${appPath}/admin/upload", function () {--%>

            <%--});--%>
        });

        $("#btnConfirm").bind("click", function () {
            var btnConfirm = $(this).button('loading');
            var btnCancel = $("#btnCancel").button('loading');
            submitJson("itemForm", "./catesave", function (result) {
                if (result && result.code == 1) {
                    $("#confirmModal").modal('hide');
                }
                btnCancel.button('reset')
                btnConfirm.button('reset');
                alert(result.msg);
            });
        });
    });

    function useUpload(filePath) {
        $("#itemImg").attr("src", appPath + "/upload/" + filePath);
        $("#itemPicUrl").val(filePath);
        $("#choosePictureModal").modal('hide');
    }

</script>

</body>
</html>
