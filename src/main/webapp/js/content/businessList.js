var basePath;
var message;

$(function () {
    basePath = $("#basePath").val();
    message = $("#message").val();
    if (message != null && "" != message) {
        alert(message);
        location.href = basePath + "/business";
    }
});

function search(currentPage) {
    // $("#mainForm").attr("method","GET");
    // $("#mainForm").attr("action", $("#basePath").val() + "/business");
    $("#currentPage").attr("value", currentPage);
    $("#mainForm").submit();

}

function toupdate(id) {
    location.href = basePath + "/business/" + id;
}

function remove(id) {
    if (confirm("是否要删除这个商户?")) {
        $("#methodName").attr("value", "DELETE");
        $("#mainForm").attr("action", basePath + "/business/" + id);
        $("#mainForm").submit();
    }
}

