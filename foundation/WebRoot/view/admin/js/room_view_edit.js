/**
 * room view edit
 */
var roomViewFurnitureList;
function addViewFurnitureFun(idTemp) {
    var divObj = $("#" + idTemp);
    // 将id加入到list中
    roomViewFurnitureList.push(idTemp);
    var idStr = "furniture" + divObj.attr("res_id");
    var nameStr = divObj.attr("res_name");
    var iconUrl = divObj.attr("res_icon");
    // 在room地图中新增家具类型
    var htmlVal = "<div id='"
        + idStr
        + "' class='draggable safetyInfoItem safetyInfoItemDefault'>"
        + "<img src='"
        + iconUrl
        + "'/><span id='"
        + idStr
        + "span' data-rel='popover' data-original-title='Name："
        + nameStr
        + "' style='position: absolute;' class='icon icon-color icon-comment'></span></div>";
    $("#safetyInfoListDiv").append(htmlVal);
    $("#safetyInfoListDiv").find(".draggable").draggable({
        containment: "#containment-wrapper",
        scroll: false
    });
}

function deleteViewFurnitureFun(idTemp) {
    var divObj = $("#" + idTemp);
    var idStr = "furniture" + divObj.attr("res_id");
    $("#" + idStr).remove();
}

function CategoryPosition(roomId, productCategoryId, x, y, zIndex) {
    this.roomId = roomId;
    this.productCategoryId = productCategoryId;
    this.x = x;
    this.y = y;
    this.zIndex = zIndex;
}


function saveViewFurnitureFun() {
    var roomId = $("#roomViewEditId").val();
    var bgPicUrl = null;
    var viewPosition = {roomId: roomId, bgPicUrl: bgPicUrl, positions: new Array()}

    for (var i = 0; i < roomViewFurnitureList.length; i++) {
        var objItem = roomViewFurnitureList[i];
        var divObj = $("#" + objItem);

        var idStr = "furniture" + divObj.attr("res_id");
        var categoryId = divObj.attr("res_id");
        // 得到防区的坐标
        var infoOffset = $("#" + idStr).position();
        // left有60像素的偏移值
        var x = infoOffset.left;
        var y = infoOffset.top;
        var zIndex = $("#" + idStr).css('z-index');
        viewPosition.positions.push(new CategoryPosition(roomId, categoryId, x, y, zIndex));
    }

    $.ajax({
        url: "./saveview",
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

    /*
     $.post(
     "product_category_position/o_save.do",
     {"roomId": roomId, "pointX": pointXs, "pointY": pointYs, "zIndexs": zIndexs, "productCategoryId":ids},
     function(data) {
     // 对返回的参数进行处理
     }
     );*/
}