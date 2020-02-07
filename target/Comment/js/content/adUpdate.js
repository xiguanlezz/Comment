var basePath;
var message;

$(function () {
    basePath = $("#basePath").val();
    message = $("#message").val();
    // adId = $("#adId").val();
    // console.log(basePath);
    if (message != null && "" != message) {
        alert(message);
        if (message == "更新成功") {
            location.href = basePath + "/ad";
        }
    }
    $("#mainForm").validate({
        rules: {
            "advertisementName": "required",
            "advertisementLink": "required",
            "advertisementWeight": {
                required: true,
                digits: true,
                maxlength: 5,
            }
        },
        messages: {
            "advertisementName": "请输入广告标题！",
            "advertisementLink": "请输入图片链接！",
            "advertisementWeight": "该字段必须是数字且最多为5位数！"
        }
    });
});

function update(id) {
    $("#mainForm").attr("action", basePath + "/ad/" + id);
    $("#methodName").attr("value", "PUT");
    // if (msg != null && "" != msg) {
    //     alert(msg);
    $("#mainForm").submit();
    // }
}

function goback() {
    location.href = basePath + "/ad";
}