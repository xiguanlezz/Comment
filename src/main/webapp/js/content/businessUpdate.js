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
			location.href = basePath + "/business";
		}
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
			}
		},
		messages: {
			"businessTitle": "请输入商户的主标题！",
			"businessSubtitle": "请输入商户的子标题！",
			"businessPrice": "价格只能包含数字！",
			"businessDistance": "距离只能包含数字！"
		}
	});
});

function update(id) {
	console.log(id);
	$("#mainForm").attr("action", basePath + "/business/" + id);
	$("#methodName").attr("value", "PUT");
	// if (msg != null && "" != msg) {
	//     alert(msg);
	$("#mainForm").submit();
	// }
}

function goback() {
	location.href = basePath + "/business";
}