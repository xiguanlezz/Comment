var basePath;

$(function () {
    basePath = $("#basePath").val();
    var message = $("#message").val();
    if (message != null && "" != message) {
        alert(message);
    }
    $("#mainForm").validate({
        rules: {
            "advertisementName": "required",
            "advertisementLink": "required",
            "advertisementWeight": {
                required: true,
                digits: true,
                maxlength: 5,
            },
            "file": {
                required: true,
                filetype: ["jpg", "jpeg", "png"]
            }
        },
        messages: {
            "advertisementName": "请输入广告标题！",
            "advertisementLink": "请输入图片链接！",
            "advertisementWeight": "该字段必须是数字且最多为5位数！",
            "file": "只能支持jpg、jpeg、png格式的图片！"
        }
    });
});

function add() {
    if (check()) {
        alert(00);
        $("#mainForm").submit();
    } else {
        alert("新增失败");
    }
}

function check() {
    // TODO 需要添加表单验证
    return true;
}

function goback() {
    location.href = basePath + "/ad";
}