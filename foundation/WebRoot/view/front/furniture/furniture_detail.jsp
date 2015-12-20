<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@include file="../common.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>

    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
    Remove this if you use the .htaccess -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!-- 家具-->
    <title>Furniture</title>
    <meta name="description" content=""/>
    <meta name="author" content="yifan"/>

    <%@include file="../include/head.jsp" %>

    <script type="text/javascript" src="${appPath}/view/front/res/style/js/MSClass.js"></script>
    <script type="text/javascript">
        var MarqueeDiv3Control;
        $(function () {
            /*********DIV + CSS向左翻屏滚动、缓动及跳过等待时间图文混排实例***************/
                //new Marquee(["MarqueeDiv3","MarqueeDiv3Boxent"],2,0.2,740,520,20,3000,3000)//向左翻屏滚动、缓动及跳过等待时间实例
            MarqueeDiv3Control = new Marquee(
                    {
                        MSClass: ["MarqueeDiv3", "MarqueeDiv3Boxent"],
                        Direction: 2,
                        Step: 0.4,
                        Width: 740,
                        Height: 580,
                        Timer: 20,
                        DelayTime: 3000,
                        WaitTime: 100000,
                        SwitchType: 1,
                        AutoStart: 1,
                        PrevBtnID: "LeftButton3",
                        NextBtnID: "RightButton3"
                    });
            // $("#LeftButton3").click(function() {
            // MarqueeDiv3Control.Run(3);		//跳过等待时间向右滚动后保持原向运动
            // });
            // $("#RightButton3").click(function() {
            // MarqueeDiv3Control.Run(2);		//跳过等待时间向左滚动后保持原向运动
            // });
            $("#bedFormatListUl").find("input[type='radio']").click(function () {
                $("#bedFormatListUl").find("input[type='number']").attr("disabled", "disabled");
                var res_name = $(this).attr("res_name");
                $("#formatNumber" + res_name).removeAttr("disabled");
            });
        });
        function formBack() {
            $("#bedDetailForm").attr("action", "${appPath}/index");
            $("#bedDetailForm").submit();
        }
        function formSubmit() {
            $("#bedDetailForm").attr("action", "${appPath}/front/product/order");
            $("#bedDetailForm").submit();
        }
        function formNext() {
            var liArray = $("#leftMenuUl").find("li");
            var temp = false;
            var categoryId = "";
            for (var i = 0; i < liArray.length; i++) {
                var liObj = $(liArray.get(i));
                if (temp == true) {
                    temp = false;
                    categoryId = liObj.attr("res");
                    break;
                }
                if (liObj.hasClass("current")) {
                    temp = true;
                }
            }
            $("#detailFormCategoryId").val(categoryId);
            $("#bedDetailForm").attr("action", "${appPath}/front/furniture/index");
            $("#bedDetailForm").submit();
        }

        function formAdd() {

            var checkedList = $("#productDetailFormat").find("input[type='checkbox']:checked");
            var dataArray = new Array();
            for (var i = 0; i < checkedList.length; i++) {
                var checkBox = $(checkedList.get(i));
                var productCode = checkBox.attr("res");
                var qty = $("#" + productCode).val();
                if (qty && qty > 0) {
                    dataArray.push({"productCode": productCode, "qyt": qty});
                }
            }
            if (dataArray.length > 0) {
                $.ajax({
                    url: "${appPath}/front/product/productBatchAdd",
                    type:"post",
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(dataArray),
                    "success": function (data) {
                        alert(data.msg);
                    },
                    "error": function (jqXHR, textStatus, errorThrown) {
                        alert(jqXHR);
                    },
                    "dataType": "json"
                });
            }

            <%--var numList = $("#productDetailFormat").find("input[type='number']");--%>
            <%--var productCurrent = $("#productDetailFormat").find("input[type='radio']:checked");--%>
            <%--var productCode = productCurrent.attr("res");--%>
            <%--var qty;--%>
            <%--for (var i = 0; i < numList.length; i++) {--%>
                <%--var numObj = $(numList.get(i));--%>
                <%--if (numObj.attr("disabled") == null) {--%>
                    <%--qty = numObj.val();--%>
                <%--}--%>
            <%--}--%>
            <%--$.ajax({--%>
                <%--"url": "${appPath}/front/product/productAdd",--%>
                <%--"data": {"productCode": productCode, "qty": qty},--%>
                <%--"success": function (data) {--%>
                    <%--alert(data.msg);--%>
                <%--},--%>
                <%--"error": function (jqXHR, textStatus, errorThrown) {--%>
                    <%--alert(jqXHR);--%>
                <%--},--%>
                <%--"dataType": "json"--%>
            <%--});--%>
        }
    </script>

    <link rel="shortcut icon" href="/favicon.ico"/>
    <link rel="apple-touch-icon" href="/apple-touch-icon.png"/>
</head>

<body>
<div class="contentDiv">
    <!-- head -->
    <%@include file="../include/top.jsp" %>
    <!-- body -->
    <div class="mainBodyDiv clearfix">
        <!-- 内容区域的导航条 -->
        <div class="bodyNavDiv">
            <ul>
                <li>
                    <a href="javascript:void(0);">Home</a>
                </li>
                <li>
                    <a href="javascript:void(0);">New Arrival</a>
                </li>
                <li class="current">
                    <a href="javascript:void(0);">Catalog</a>
                </li>
                <li>
                    <a href="javascript:void(0);">Contact Us</a>
                </li>
            </ul>
        </div>
        <!-- 内容区域 -->
        <div class="bodyContentDiv">
            <div class="leftMenu">
                <ul id="leftMenuUl">
                    <c:forEach var="item" items="${categories}">
                        <li <c:if test="${item.id==categoryId}"> class="current" </c:if> res="${item.id}">
                            <a href="${appPath}/front/furniture/index?categoryId=${item.id}">${item.name }</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="rightContent" style="margin-left: 0px;">
                <div id="main" class="furnitureDetailDiv rollBox">
                    <form id="bedDetailForm" action="../done/summary.html">
                        <input name="categoryId" id="detailFormCategoryId" type="hidden"/>

                        <div id="LeftButton3" class="btnDetailPrev">
                        </div>
                        <div id="MarqueeDiv3" class="detailContent">
                            <div id="MarqueeDiv3Boxent">
                                <%--<c:forEach items="${furinitureList}" var="item">
									--%><!-- item1 -->
                                <div id="detailItem1" class="detailItemDiv item">
                                    <div class="detailLeft">
                                        <img src="${appPath}/${dirUpload}/${bean.detailPicture}" style="width: 100%;"/>

                                        <div id="productDetailFormat" class="detailFormat clearfix">
                                            <%--<c:if test="${categoryName=='Chairs'}">--%>
                                            <!-- charis属性 -->
                                            <h2>${item.name}</h2>
                                            <ul class="formatList clearfix">
                                                <c:forEach items="${bean.propertyProductList}" var="productItem">
                                                    <li id="productItem${productItem.productCode}"
                                                        res="${productItem.productPrice }">
                                                        <label>
                                                            <!-- 如果有 propertyPicUrl ，则展示 -->
                                                            <c:if test="${!(empty productItem.propertyPicUrl)}">
                                                                <img src="${appPath}/${dirUpload}/${productItem.propertyPicUrl}"/>
                                                            </c:if>
                                                            <div class="fl">
                                                                <!--使用propertyValue 做为属性值展示-->
                                                                <span class="formatItemTit">${productItem.propertyValue}</span>
                                                                    <%--<span>${productItem.propertyValue}</span>--%>
                                                            </div>
                                                            <!-- 提交产品CODE 和 数量 -->
                                                            <input name="formatItemProductCode"
                                                                   res="${productItem.productCode}" type="checkbox"
                                                                   class="fr mt10"/>

                                                            <label style="width: 60px;">
                                                                Qty&nbsp;
                                                            </label>
                                                            <input type="number" id="${productItem.productCode}" name="${productItem.productCode}"/>

                                                        </label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                            <%--</c:if>--%>
                                            <%--<c:if test="${categoryName=='Bed'}">--%>
                                            <%--<ul class="formatList clearfix" style="margin-top: 10px;" id="bedFormatListUl">--%>
                                            <%--<c:forEach items="${bean.propertyProductList}" var="productItem">--%>
                                            <%--<li style="width: 120px;">--%>
                                            <%--<label>${productItem.propertyName } <input checked="checked" res_name="${productItem.propertyName }" type="radio" name="formatItemProductCode" res="${productItem.productCode }" /></label>--%>
                                            <%--<label>Qty <input type="number" id="formatNumber${productItem.propertyName }" /></label>--%>
                                            <%--</li>--%>
                                            <%--</c:forEach>--%>
                                            <%--</ul>--%>
                                            <%--</c:if>--%>
                                            <%--<c:if test="${categoryName=='TV'}">--%>
                                            <%--<!-- TV -->--%>
                                            <%--<ul class="formatList clearfix" style="margin-top: 10px;">--%>
                                            <%--<c:forEach items="${bean.propertyProductList}" var="productItem">--%>
                                            <%--<li id="productItem${productItem.productCode }" res="${productItem.productPrice }" style="width: 100px;">--%>
                                            <%--<label>${productItem.propertyName }	<input type="radio" name="formatItemProductCode" res="${productItem.productCode }" />--%>
                                            <%--</label>--%>
                                            <%--</li>--%>
                                            <%--</c:forEach>--%>
                                            <%--</ul>--%>
                                            <%--<label class="pb15">Qty <input type="number" /></label>--%>
                                            <%--</c:if>--%>
                                        </div>
                                    </div>
                                    <!-- right -->
                                    <div class="contentRight fl">
                                        <div class="clearfix">
                                            <h2>${bean.name }</h2>

                                            <p>
                                                ${bean.descDetail }
                                            </p>

                                            <p>
                                            <li style="list-style: none;">General Dimensions</li>
                                            <li style="list-style: none;">Height: ${bean.width }</li>
                                            <li style="list-style: none;">Width: ${bean.height }</li>
                                            <li style="list-style: none;">Depth: ${bean.depth }</li>
                                            </p>
                                        </div>
                                        <div class="detailController">
                                            <input style="margin-bottom: 10px;" type="button" value="Back"
                                                   onclick="formBack()"/>
                                            <input style="margin-bottom: 10px;" class="ml10" type="button" value="Next"
                                                   onclick="formNext()"/>
                                            <input type="button" value="Add" onclick="formAdd()"/>
                                            <input type="button" class="ml10" onclick="formSubmit()" value="Summary"/>
                                        </div>
                                        <div class="clearfix pb15">
                                        </div>
                                    </div>
                                </div>
                                <%--</c:forEach>
									--%><!-- item end -->
                            </div>
                        </div>
                        <div id="RightButton3" class="btnDetailNext">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- foot -->
    <div class="mainFootDiv clearfix">
        &nbsp;
    </div>
</div>
</body>
</html>
