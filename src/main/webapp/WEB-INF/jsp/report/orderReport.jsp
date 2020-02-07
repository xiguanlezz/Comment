<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.8.3.js"></script>
    <%--		<script type="text/javascript" src="${pageContext.request.contextPath}/js/common/common.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/echarts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/report/orderReport.js"></script>
</head>
<body style="background: #e1e9eb;">
<input type="hidden" id="basePath" value="${pageContext.request.contextPath}"/>
<div id="report" style="height:500px;border:1px solid #ccc;padding:10px;"></div>
</body>
</html>