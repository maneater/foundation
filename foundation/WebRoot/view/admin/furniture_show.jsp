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
            <h3 class="page-header">${isAdd?"Add Funiture":"Funiture Information"}</h3>

            <form class="form-horizontal" id="itemForm">

                <c:set var="item" value="${graphModel}"></c:set>
                <input type="hidden" name="id" value="${item.id}">

                <!--use for 3d properties-->
                <div class="form-group col-sm-6 ">
                    <label for="name" class="control-label  col-sm-4">Name</label>

                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" value="${item.name}"
                               name="name">
                    </div>
                </div>
                <div class="form-group col-sm-6 ">
                    <label for="sequenceName" class="control-label  col-sm-4">SequenceName</label>

                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="sequenceName" value="${item.sequenceName}"
                               name="sequenceName">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="tags" class="control-label  col-sm-4">tags</label>

                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="tags" value="${item.tags}"
                               name="tags">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="categoryId" class="control-label col-sm-4">category</label>

                    <div class="col-sm-8">

                        <select class="form-control" name="categoryId" id="categoryId">
                            <c:forEach var="category" items="${categoryList}">
                                <option value="${category.id}" ${item.categoryId == category.id?"selected":""} >${category.name}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="icon" class="control-label col-sm-4">icon</label>

                    <div class="col-sm-8">
                        <div class="input-group">
                            <input required type="text" class="form-control" id="icon" value="${item.icon}"
                                   name="icon">
                            <span class="input-group-btn">
                                <button id="btnChoosePicture" type="button" class="btn btn-primary">select
                                </button>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="iconDigest" class="control-label col-sm-4">iconDigest</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="iconDigest" value="${item.iconDigest}"
                               name="iconDigest">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="model" class="control-label col-sm-4">model</label>

                    <div class="col-sm-8">
                        <div class="input-group">
                            <input id="itemModelPath" type="text" class="form-control" name="model"
                                   value="${item.model}">
                        <span class="input-group-btn">
                            <button id="btnChooseModel" type="button" id="model"
                                    class="btn btn-primary ">select
                            </button>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="modelDigest" class="control-label col-sm-4">modelDigest</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="modelDigest" value="${item.modelDigest}"
                               name="modelDigest">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="width" class="control-label col-sm-4">width</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="width" value="${item.width}"
                               name="width">
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="multiPartModel" class="control-label col-sm-4">multiPart</label>

                    <div class="col-sm-8">
                        <label class="radio">
                            <input type="radio" name="multiPartModel" id="multiPartModel"
                                   value="false" ${item.multiPartModel?"":"checked"}>false
                        </label>
                        <label class="radio">
                            <input type="radio" name="multiPartModel"
                                   value="true" ${item.multiPartModel?"checked":""}>true
                        </label>
                    </div>
                </div>
                <div class="form-group col-sm-6">
                    <label for="height" class="control-label col-sm-4">height</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="height" value="${item.height}"
                               name="height">
                    </div>
                </div>

                <div class="form-group col-sm-6">
                    <label for="movable" class="control-label  col-sm-4">movable</label>

                    <div class="col-sm-8">
                        <label class="radio">
                            <input type="radio" name="movable" value="false" ${item.movable?"":"checked"}>false
                        </label>
                        <label class="radio">
                            <input type="radio" name="movable" id="movable"
                                   value="true" ${item.movable||isAdd?"checked":""}>true
                        </label>
                    </div>
                </div>
                <div class="form-group col-sm-6 ">
                    <label for="depth" class="control-label col-sm-4">depth</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="depth" value="${item.depth}"
                               name="depth">
                    </div>
                </div>


                <div class="form-group col-sm-6">
                    <label for="doorOrWindow" class="control-label  col-sm-4">door|Win</label>

                    <div class="col-sm-8">
                        <label class="radio">
                            <input type="radio" name="doorOrWindow" value="false" ${item.doorOrWindow?"":"checked"}>false
                        </label>
                        <label class="radio">
                            <input type="radio" name="doorOrWindow" id="doorOrWindow"
                                   value="true" ${item.doorOrWindow?"checked":""}>true
                        </label>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="dropOnTopElevation" class="control-label  col-sm-2">dropOnTopElevation</label>

                    <div class="col-sm-9">
                        <input type="number" class="form-control" id="dropOnTopElevation"
                               value="${item.dropOnTopElevation}"
                               name="dropOnTopElevation">
                    </div>
                </div>

                <!--use for 3d properties-->

                <HR style="border:1px solid #646975;" width="95%">

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
                    <label for="itemImg" class="control-label  col-sm-2">Icon ReV</label>

                    <div class="col-sm-9">
                        <img id="itemImg" src="${appPath}/${dirUpload}/${item.icon}" alt=""
                             style="width: 150px;height:150px;"
                             class="img-rounded"/>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="supplierId" class="control-label  col-sm-2">Supplier</label>

                    <div class="col-sm-9">
                        <select class="form-control" name="supplierId" id="supplierId">
                            <c:forEach var="supplier" items="${supplierList}">
                                <option value="${supplier.id}" ${item.supplierId == supplier.id?"selected":""} >${supplier.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="qyt" class="control-label  col-sm-2">QYT</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="qyt" value="${item.qyt}"
                               name="qyt">
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="code" class="control-label  col-sm-2">Code</label>

                    <div class="col-sm-9">
                        <input type="text" class="form-control" id="code" value="${item.code}"
                               name="code">
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
    </div>
</div>

<div class="modal fade" style="" id="chooseModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" style="width: 80%;height: 80%;">
        <div class="modal-content" id="chooseContent" style="height: 100%;">
            <div class="modal-body" style="height: 90%;">
                <h3 id="chooseTitle">Choose Model Picture</h3>
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
    var choosePicUrl = false;

    $().ready(function () {

        $("#btnChooseModel").bind("click", function () {
            choosePicUrl = false;
            $("#chooseTitle").html("Choose Model File");
            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=zip&filePath=${dirFurnitureModel}');
            $("#chooseModal").modal('show');
            <%--$("#chooseContent").load("${appPath}/admin/upload", function () {--%>
            <%--});--%>
        });
        $("#btnChoosePicture").bind("click", function () {
            $("#chooseTitle").html("Choose Model Picture");
            choosePicUrl = true;
            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=img&filePath=${dirFurniture}');
            $("#chooseModal").modal('show');
            <%--$("#chooseContent").load("${appPath}/admin/upload", function () {--%>
            <%--});--%>
        });

        $("#btnConfirm").bind("click", function () {
            var btnConfirm = $(this).button('loading');
            var btnCancel = $("#btnCancel").button('loading');
            submitJson("itemForm", "./save", function (result) {
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
        $("#chooseModal").modal('hide');
        if (choosePicUrl) {
            $("#itemImg").attr("src", appPath + "/upload/" + filePath);
            $("#icon").val(filePath);
            $("#choosePictureModal").modal('hide');
        } else {
            $("#itemModelPath").val(filePath);
        }
    }

</script>

</body>
</html>
