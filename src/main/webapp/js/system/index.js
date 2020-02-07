// 当前登录用户可以访问的菜单Map
var menuMap = {};
var basePath;
var oldFlag = false;
var newFlag = false;
var reFlag = false;
var msg;

$(function () {
    //页面加载完就执行ajax
    basePath = $("#basePath").val();
    $.ajax({
        url: basePath + "/menus",
        success: function (datas) {
            console.log(datas);
            $.each(datas, function (index, data) {
                if (!menuMap[data.menuPid]) {
                    menuMap[data.menuPid] = new Array();
                }
                data.menuUrl = basePath + data.menuUrl;
                //封装成Pid和Menu的JS对象
                menuMap[data.menuPid].push(data);
                // console.log(index+'--'+data.menuName);
            })
            console.log(menuMap);
            initMenu();
        }
    });

    msg = $("#message").val();
    if (msg != null && '' != msg.trim()) {
        alert(msg);
        location.href = basePath + "/login";
    }

    // while(true) {
    //     $.ajax({
    //         url: basePath + "/getTime",
    //         success: function (data) {
    //             console.log(data);
    //             $("#nowTime").innerText(data);
    //         }
    //     });
    // }
});


function initMenu() {
    //一级菜单Pid是0
    var menuList = menuMap[0];
    $.each(menuList, function (index, menu) {
        $("#menuDiv").append("<li onclick='initSonMenu(this,\"" + menu.menuId + "\")'><a><span>" + menu.menuName + "</span></a></li>")
    });
}

function initSonMenu(e, id) {
    //先清空所有同级的样式, 再给选中的添加样式
    $("#menuDiv").children().attr("class", "");
    $(e).attr("class", "on");
    // console.log(menuMap[id]);
    $("#subMenuDiv").html("");
    $.each(menuMap[id], function (index, data) {
        // alert("data.menuName");
        $("#subMenuDiv").append("<h3 onclick='clickSonMenu(this,\"" + data.menuUrl + "\")'><a>" + data.menuName + "</a></h3>")
        // $("#subMenuDiv").append("<h3 onclick=\"clickSonMenu(this,'" + data.menuUrl + "')\"><a>" + data.menuName + "</a></h3>");
    });
}

function clickSonMenu(e, url) {
    $("#subMenuDiv").find(".on").attr("class", "");
    // 将当前单击的节点置为[选中样式]
    $(e).children().attr("class", "on");
    console.log(url);
    $("#mainPage").attr("src", url);
    // return false;
}


/**
 * 打开密码修改弹出层
 */
function openAddDiv() {
    $("#mengban").css("visibility", "visible");
    $(".wishlistBox").show();
    $(".wishlistBox").find(".persongRightTit").html("&nbsp;&nbsp;修改密码");
    $("#submitVal").show();
}

/**
 * 关闭密码修改弹出层
 */
function closeDiv() {
    $("#mengban").css("visibility", "hidden");
    $("#oldPassword").val("");
    $("#newPassword").val("");
    $("#newPasswordAgain").val("");
    $(".wishlistBox").hide();
}

function FocusOldPwd(obj, id) {
    $(obj).next('span').html('').removeClass('err');
}

function CheckOldPwd(obj, id) {
    var oldPwd = $.md5($(obj).val());
    $.ajax({
        url: basePath + "/system/check",
        data: {"adminId": id, "oldPwd": oldPwd},
        type: "POST",
        dataType: "text",
        success: function (data) {
            if (data == "true") {
                $(obj).next('span').html('').removeClass('err');
                oldFlag = true;
            } else if (data == "false") {
                $(obj).next('span').html('原始密码输入错误').addClass('err');
                oldFlag = false;
            }
        }
    });
}

function FocusNewPwd(obj, id) {
    $(obj).next('span').html('').removeClass('err');
}

function CheckNewPwd(obj, id) {
    var newPwd = $("#newPassword").val();
    var oldPwd = $("#oldPassword").val();
    if (newPwd.trim() == "") {
        $(obj).next('span').html('新密码不能为空').addClass('err');
        newFlag = false;
    } else if (newPwd == oldPwd) {
        $(obj).next('span').html('新密码不能和原密码相同').addClass('err');
        newFlag = false;
    } else {
        newFlag = true;
    }
}

function FocusRePwd(obj, id) {
    $(obj).next('span').html('').removeClass('err');
}

function CheckRePwd(obj, id) {
    var newPwd = $("#newPassword").val();
    var rePwd = $("#newPasswordAgain").val();
    if (newPwd != rePwd) {
        $(obj).next('span').html('两次输入的密码不一致').addClass('err');
        reFlag = false;
    } else {
        reFlag = true;
    }
}

function checkForm() {
    if (oldFlag && newFlag && reFlag) {
        $("#newPasswordAgainMD5").val($.md5($("#newPasswordAgain").val()));
        $("#UpdateForm").attr("action", basePath + "/system/update");
        $("#UpdateForm").submit();
    }
}

function logout() {
    if (confirm('您确认退出系统?')) {
        $('#mainForm').submit();
    }
}