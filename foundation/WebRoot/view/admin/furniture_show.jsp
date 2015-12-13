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
            <h3 class="page-header">
                <c:choose>
                    <c:when test="${isAdd}">Add&nbsp;[${category.name}]&nbsp;Furniture</c:when>
                    <c:otherwise>Furniture Information</c:otherwise>
                </c:choose>
            </h3>

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
                    <label for="code" class="control-label  col-sm-4">Product Code</label>

                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="code" value="${item.code}"
                               name="code">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="price" class="control-label  col-sm-4">Price</label>

                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="price" value="${item.price}"
                               name="price">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="categoryId" class="control-label col-sm-4">category</label>

                    <div class="col-sm-8">
                        <input type="hidden" class="form-control" id="categoryId" value="${category.id}"
                               name="categoryId">
                        <input disabled type="text" class="form-control" id="categoryName" value="${category.name}">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="thumbnailPicture" class="control-label col-sm-4">thumbnail</label>

                    <div class="col-sm-8">
                        <div class="input-group">
                            <input required type="text" class="form-control" id="thumbnailPicture"
                                   value="${item.thumbnailPicture}"
                                   name="thumbnailPicture">
                            <span class="input-group-btn">
                                <button id="btnChooseThumbnailPicture" type="button" class="btn btn-primary">select
                                </button>
                            </span>
                        </div>
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="detailPicture" class="control-label col-sm-4">detailPicture</label>

                    <div class="col-sm-8">
                        <div class="input-group">
                            <input id="detailPicture" type="text" class="form-control" name="detailPicture"
                                   value="${item.detailPicture}">
                        <span class="input-group-btn">
                            <button id="btnChooseDetailPicture" type="button"
                                    class="btn btn-primary ">select
                            </button>
                        </span>
                        </div>
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="thumbnailPicture" class="control-label  col-sm-4"> </label>

                    <div class="col-sm-8">
                        <img id="thumbnailPictureImg" src="${appPath}/${dirUpload}/${item.thumbnailPicture}" alt=""
                             style="width: 150px;height:150px;"
                             class="img-rounded"/>
                    </div>
                </div>


                <div class="form-group col-sm-6 ">
                    <label for="detailPictureImg" class="control-label  col-sm-4"> </label>

                    <div class="col-sm-8">
                        <img id="detailPictureImg" src="${appPath}/${dirUpload}/${item.detailPicture}" alt=""
                             style="width: 150px;height:150px;"
                             class="img-rounded"/>
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="descBasic" class="control-label col-sm-2">descBasic</label>

                    <div class="col-sm-10">
                        <input required type="text" class="form-control" id="descBasic" value="${item.descBasic}"
                               name="descBasic">
                    </div>
                </div>

                <div class="form-group col-sm-12 ">
                    <label for="descDetail" class="control-label col-sm-2">descDetail</label>

                    <div class="col-sm-10">
                        <input required type="text" class="form-control" id="descDetail" value="${item.descDetail}"
                               name="descDetail">
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
                    <label for="height" class="control-label col-sm-4">height</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="height" value="${item.height}"
                               name="height">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="depth" class="control-label col-sm-4">depth</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="depth" value="${item.depth}"
                               name="depth">
                    </div>
                </div>

                <div class="form-group col-sm-6 ">
                    <label for="sizeUnit" class="control-label col-sm-4">sizeUnit</label>

                    <div class="col-sm-8">
                        <input required type="text" class="form-control" id="sizeUnit" value="${item.sizeUnit}"
                               name="sizeUnit">
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

                <!--use for 3d properties-->
                <HR style="border:1px solid #646975;" width="95%">
                <c:forEach items="${category.expandPropertyList}" var="expandProperty">
                    <div class="form-group col-sm-12 ">
                        <label for="${expandProperty.name}"
                               class="control-label  col-sm-2">${expandProperty.name}</label>

                        <div class="col-sm-9">
                            <c:forEach var="option" items="${fn:split(expandProperty.defaultOptions,';')}">
                                <button onclick="return addPropertyTR('${expandProperty.name}','${option}','${option}');">${option}</button>
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>

                <div class="col-sm-12"><h4>expand property</h4></div>
                <div class="table col-sm-12">
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Value</th>
                            <th>Info</th>
                            <th>PropertyPic</th>

                            <th>ProductCode</th>
                            <th>ProductPic</th>
                            <th>ProductPrice</th>

                            <th>
                                <button onclick="return addPropertyTR();">Add</button>
                            </th>
                        </tr>
                        </thead>
                        <tbody id="expandTableBody">
                        <c:forEach items="${item.propertyProductList}" var="propertyProduct" varStatus="propertyStatus">
                            <tr data-value="${propertyProduct.propertyName}" data-index="${propertyStatus.index}"
                                id="property">
                                <td><input class="form-control" type="text" name="propertyProductList[${propertyStatus.index}].propertyName" value="${propertyProduct.propertyName}" required="true"/></td>
                                <td><input class="form-control" type="text" name="propertyProductList[${propertyStatus.index}].propertyValue" value="${propertyProduct.propertyValue}"/></td>
                                <td><input class="form-control" type="text" name="propertyProductList[${propertyStatus.index}].propertyInfo" value="${propertyProduct.propertyInfo}"/></td>
                                <td class="col-sm-2"><div class="input-group"><input type="text" class="form-control" value="${propertyProduct.propertyPicUrl}" name="propertyProductList[${propertyStatus.index}].propertyPicUrl"><span class="input-group-btn"><button type="button" class="btn btn-primary" onclick="return selectPicUrl(this.parentNode.parentNode.childNodes[0],'${dirFurniturePropertyPic}');">select</button></span></div></td>

                                <td><input class="form-control" type="text" data-value="productCode"
                                           name="propertyProductList[${propertyStatus.index}].productCode"
                                           value="${propertyProduct.productCode}"/>
                                </td>


                                <td class="col-sm-2">
                                    <div class="input-group">
                                        <input class="form-control" type="text" data-value="productPicUrl"
                                               name="propertyProductList[${propertyStatus.index}].productPicUrl"
                                               value="${propertyProduct.productPicUrl}"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-primary" onclick="return selectPicUrl(this.parentNode.parentNode.childNodes[1],'${dirFurniture}');">select
                                            </button>
                                        </span>
                                    </div>
                                </td>


                                <td><input class="form-control" type="text" data-value="productPrice"
                                           name="propertyProductList[${propertyStatus.index}].productPrice"
                                           value="${propertyProduct.productPrice}"/>
                                </td>
                                <td>
                                    <button onclick="return deletePropertyRT(this);">delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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


    <fd:toJs argName="expandProperty" argObj="${category.expandPropertyList}"></fd:toJs>;
    <fd:toJs argName="proudctProperty" argObj="${item.propertyProductList}"></fd:toJs>;


    <%--<tr data-value="${propertyProduct.propertyName}" data-index="${propertyStatus.index}">--%>
    <%--<td><input class="form-control" type="text"  data-value="propertyName"  name="propertyProductList[${propertyStatus.index}].propertyName" value="${propertyProduct.propertyName}" required="true"/></td>--%>
    <%--<td><input class="form-control" type="text"  data-value="propertyValue"  name="propertyProductList[${propertyStatus.index}].propertyValue" value="${propertyProduct.propertyValue}"/></td>--%>
    <%--<td><input class="form-control" type="text"  data-value="propertyInfo"  name="propertyProductList[${propertyStatus.index}].propertyInfo" value="${propertyProduct.propertyInfo}"/></td>--%>

    <%--<td class=\"col-sm-2\"><div class=\"input-group\"><input type=\"text\" class=\"form-control\" value=\"${propertyProduct.propertyPicUrl}\" name=\"propertyProductList[${propertyStatus.index}].propertyPicUrl\"><span class=\"input-group-btn\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"return selectPicUrl(this.parentNode.parentNode.childNodes[1],'${dirFurniturePropertyPic}');\">select</button></span></div></td>--%>

    <%--<td><input class="form-control" type="text"  data-value="productCode"  name="propertyProductList[${propertyStatus.index}].productCode" value="${propertyProduct.productCode}"/></td>--%>
    <%--<td><input class="form-control" type="text"  data-value="productPicUrl"  name="propertyProductList[${propertyStatus.index}].productPicUrl" value="${propertyProduct.productPicUrl}"/></td>--%>
    <%--<td><input class="form-control" type="text"  data-value="productPrice"  name="propertyProductList[${propertyStatus.index}].productPrice" value="${propertyProduct.productPrice}"/></td>--%>
    <%--<td><button onclick="return deletePropertyRT(this);">delete</button></td>--%>
    <%--</tr>--%>

    function addPropertyTR(name, value, info) {
        if (!name) {
            name = "";
        }

        if (!value) {
            value = "";
        }
        if (!info) {
            info = "";
        }

        var price = $("#price").val();

        var trSize = $("#expandTableBody").children().size();
        var tr = $(document.createElement("tr"));
        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"propertyName\"  name=\"propertyProductList[" + trSize + "].propertyName\" value=\"" + name + "\" required=\"true\"/></td>");
        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"propertyValue\"  name=\"propertyProductList[" + trSize + "].propertyValue\" value=\"" + value + "\"/></td>");
        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"propertyInfo\"  name=\"propertyProductList[" + trSize + "].propertyInfo\" value=\"" + info + "\"/></td>");
        tr.append("<td class=\"col-sm-2\"><div class=\"input-group\"><input type=\"text\" class=\"form-control\" value=\"\" name=\"propertyProductList["+trSize+"].propertyPicUrl\"><span class=\"input-group-btn\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"return selectPicUrl(this.parentNode.parentNode.childNodes[0],'${dirFurniturePropertyPic}');\">select</button></span></div></td>");

        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"productCode\"  name=\"propertyProductList[" + trSize + "].productCode\" value=\"\"/></td>");
//        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"productPicUrl\"  name=\"propertyProductList[" + trSize + "].productPicUrl\" value=\"\"/></td>");
        tr.append("<td class=\"col-sm-2\"><div class=\"input-group\"><input type=\"text\" class=\"form-control\" value=\"\" name=\"propertyProductList["+trSize+"].productPicUrl\"><span class=\"input-group-btn\"><button type=\"button\" class=\"btn btn-primary\" onclick=\"return selectPicUrl(this.parentNode.parentNode.childNodes[0],'${dirFurniture}');\">select</button></span></div></td>");
        tr.append("<td><input class=\"form-control\" type=\"text\"  data-value=\"productPrice\"  name=\"propertyProductList[" + trSize + "].productPrice\" value=\"" + price + "\"/></td>");

        tr.append("<td><button onclick='return deletePropertyRT(this);'>delete</button></td>");
        $("#expandTableBody").append(tr);
        return false;
    }
    function deletePropertyRT(ele) {
        $(ele).parent().parent().remove();
        return false;
    }

    var appPath = '${appPath}';
    var chooseDetail = false;

    var picPathTarget=null;
    var picShowTarget=null;

    function selectPicUrl(pathTarget,filePath,showTarget){
        console.info(pathTarget);

        picPathTarget = pathTarget;
        picShowTarget = null;

        $("#chooseTitle").html("Choose Picture");
        $("#iframe").attr("src", '${appPath}/admin/upload?fileType=img&filePath='+filePath);
        $("#chooseModal").modal('show');
    }


    $().ready(function () {

        $("#btnChooseThumbnailPicture").bind("click", function () {
            chooseDetail = false;
            $("#chooseTitle").html("Choose ThumbnailPicture");
            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=img&filePath=${dirFurnitureModel}');
            $("#chooseModal").modal('show');
        });
        $("#btnChooseDetailPicture").bind("click", function () {
            $("#chooseTitle").html("Choose DetailPicture");
            chooseDetail = true;
            $("#iframe").attr("src", '${appPath}/admin/upload?fileType=img&filePath=${dirFurniture}');
            $("#chooseModal").modal('show');
        });

        $("#btnConfirm").bind("click", function () {
            var btnConfirm = $(this).button('loading');
            var btnCancel = $("#btnCancel").button('loading');
            submitParams("./save", $("#itemForm").serialize(), function (result) {
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
        if(picPathTarget != null){
            <%--$(picPathTarget).attr("src", appPath + "/${dirUpload}/" + filePath);--%>
            $(picPathTarget).val(filePath);
            picPathTarget = null;
            return ;
        }

        if (chooseDetail) {
            $("#detailPictureImg").attr("src", appPath + "/${dirUpload}/" + filePath);
            $("#detailPicture").val(filePath);
        } else {
            $("#thumbnailPictureImg").attr("src", appPath + "/${dirUpload}/" + filePath);
            $("#thumbnailPicture").val(filePath);
        }
    }

</script>

</body>
</html>
