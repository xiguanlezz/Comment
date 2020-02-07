var basePath;

$(function () {
    basePath = $("#basePath").val();
    var message = $("#message").val();
    if (message != null && "" != message) {
        alert(message);
    }
    $("#mainForm").validate({
        rules: {
            "businessTitle": "required",
            "businessSubtitle": "required",
            "businessPrice": {
                required: true,
                digits: true
            },
            "businessDistance": {
                required: true,
                digits: true
            },
            "file": {
                required: true,
                filetype: ["jpg", "jpeg", "png"]
            }
        },
        messages: {
            "businessTitle": "请输入商户的主标题！",
            "businessSubtitle": "请输入商户的子标题！",
            "businessPrice": "价格只能包含数字！",
            "businessDistance": "距离只能包含数字！",
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
    location.href = basePath + "/business";
}