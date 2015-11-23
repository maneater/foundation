/**
 * Created by Administrator on 2015/11/12 0012.
 */
$.fn.serializeJson = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

var submitJson = function (formId, url, callback) {
    $.ajax({
        url: url,
        type: "post",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify($("#" + formId).serializeJson()),
        success: function (result) {
            callback(result);
        },
        error: function (xhr, err) {
            console.info(xhr);
            callback({code: 0, msg: "err:" + err, data: null});
            //alert("readyState: " + xhr.readyState + "\nstatus: " + xhr.status);
            //alert("responseText: " + xhr.responseText);
        }
    });
}

var submitParams = function (url, data, callback) {
    $.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        success: function (result) {
            callback(result);
        },
        error: function (xhr, err) {
            console.info(xhr);
            callback({code: 0, msg: "err:" + err, data: null});
            //alert("readyState: " + xhr.readyState + "\nstatus: " + xhr.status);
            //alert("responseText: " + xhr.responseText);
        }
    });
}

