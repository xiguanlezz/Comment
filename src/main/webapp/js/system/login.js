$(function () {
    var basePath = $("#basePath").val();

    $("#mainForm").validate({
        rules: {
            "name": {
                required: true
            },
            "password": {
                required: true
            }
        }
    });

// 单击登录
    $("#submit_login").click(function () {
        if ($("#password").val()) {
            $("#password_md5").attr("value", $.md5($("#password").val()));
        }
        // alert(1);
        $.ajax({
            url: basePath + "/login/validate",
            async: true,
            type: "GET",
            data: {
                "adminUsername": $("#name").val(),
                "adminPassword": $("#password_md5").val()
            },
            success: function (data) {
                if (data == "登录成功") {
                    location.href = basePath + "/index";
                } else if (data = "登录失败") {
                    alert("用户名或者密码错误");
                }
            }
        });
    })

});