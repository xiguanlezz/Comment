var basePath;
var message;
$(function () {
    basePath = $("#basePath").val();
    message = $("#message").val();
    if (message != null && "" != message) {
        alert(message);
        location.href = basePath + "/ad";
    }
});

function search(currentPage) {
    // var cp=$("#currentPage").val(currentPage);
    $("#currentPage").attr("value", currentPage);
    // console.log(cp);

    $("#mainForm").submit();
}

function toupdate(id) {
    location.href = basePath + "/ad/" + id;
}

function remove(id) {
    // var basePath = $("#basePath").val();
    if (confirm("是否要删除这条广告?")) {
        $("#methodName").attr("value", "DELETE");
        $("#mainForm").attr("action", basePath + "/ad/" + id);
        $("#mainForm").submit();
    }
}


