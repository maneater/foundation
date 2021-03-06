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
            <h1 class="page-header">User Information-${item.id}</h1>

            <form class="form-horizontal" id="itemForm">

                <input type="hidden" name="id" value="${item.id}">


                <div class="form-group col-sm-12 ">
                    <label for="email" class="control-label  col-sm-2">email</label>

                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="email" value="${item.email}"
                               name="email" disabled>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="createTime" class="control-label  col-sm-2">createTime</label>

                    <div class="col-sm-4">
                        <input type="email" class="form-control" id="createTime" value="${item.createTime}"  disabled>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="headPicUrl" class="control-label  col-sm-2">headPicUrl</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="headPicUrl" value="${item.headPicUrl}"
                               name="headPicUrl">
                    </div>
                </div>


                <div class="form-group col-sm-12 ">
                    <label for="info" class="control-label  col-sm-2">info</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="info" value="${item.info}"
                               name="info">
                    </div>
                </div>


                <div class="form-group col-sm-12 ">
                    <label for="enable" class="control-label  col-sm-2">enable</label>

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
            <c:if test="${empty item}">
                <p>Not find target User</p>
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

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${appPath}/view/resourse/js/jquery.min.js"></script>
<script src="${appPath}/view/resourse/js/bootstrap.min.js"></script>
<script src="${appPath}/view/admin/js/submit.js"></script>

<script>

    $().ready(function () {
        $("#btnConfirm").bind("click", function () {
            var btnConfirm = $(this).button('loading');
            var btnCancel = $("#btnCancel").button('loading');
            submitJson("itemForm", "./update", function (result) {
                if (result && result.code == 1) {
                    $("#confirmModal").modal('hide');
                }
                btnCancel.button('reset')
                btnConfirm.button('reset');
                alert(result.msg);
            });
        });
    });
</script>

</body>
</html>
