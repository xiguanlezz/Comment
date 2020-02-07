<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.validate.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/validation/jquery.validate.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/validation/messages_zh.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/validation/additional-methods.js"></script>
<%--		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>--%>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/content/adAdd.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form id="mainForm" method="post" action="${pageContext.request.contextPath}/ad" enctype="multipart/form-data">
			<input type="hidden" id="message" value="${error}"/>
			<input type="hidden" id="basePath" value="${pageContext.request.contextPath}"/>
			<div class="right">
				<div class="current">当前位置：<a href="###">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">新增广告</p>
					<table class="tab1" width="100%">
						<tbody>
							<tr>
							<td align="right" width="10%">标题<font color="red">*</font>：</td>
							<td width="30%">
								<input id="title" name="advertisementName" class="allInput" style="width:100%;" type="text"/>
							</td>
							<td align="right" width="10%">上传图片<font color="red">*</font>：</td>
							<td width="30%">
								<input id="imgFile" name="file" class="allInput" style="width:100%;" type="file"/>
							</td>
						</tr>
						<tr>
							<td align="right" width="10%">链接地址<font color="red">*</font>：</td>
							<td width="30%">
								<input id="link" name="advertisementLink"  class="allInput" style="width:100%;" type="text"/>
							</td>
							<td align="right" width="10%">权重(值越大排名越靠前)<font color="red">*</font>：</td>
							<td width="30%">
								<input id="weight" name="advertisementWeight"  class="allInput" style="width:100%;" type="text"/>
							</td>
						</tr>
					  </tbody>
					</table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="保     存" type="button" onclick="add();"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="tabSub" value="返     回" type="button" onclick="goback();"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>