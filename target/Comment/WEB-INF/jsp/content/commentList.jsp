<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pop.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/content/commentList.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="${pageContext.request.contextPath}/comments/search" id="mainForm" method="post">
    <input id="id" name="id" type="hidden">
<%--    <input id="basePath" value="${pageContext.request.contextPath}" type="hidden">--%>
    <input name="page.currentPage" id="currentPage" value="1" type="hidden">
    <div class="right">
        <div class="current">当前位置：<a href="#">内容管理</a> &gt; 评论查询</div>
        <div class="rightCont">
            <p class="g_title fix">评论列表</p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td width="80" align="right">评论内容：</td>
                    <td>
                        <input name="commentContent" id="title" value="${searchct.commentContent}" class="allInput" type="text">
                    </td>
                    <td style="text-align: right;" width="150">
                        <input class="tabSub" value="查询" onclick="search('1');" type="button">&nbsp;&nbsp;&nbsp;&nbsp;
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th>序号</th>
                        <th>订单号</th>
                        <th>评论星级</th>
                        <th>手机号</th>
                    </tr>
                    <c:forEach items="${comments}" var="comment" varStatus="s">
                        <tr>
                            <td>${s.index+1}</td>
                            <c:forEach items="${Id_OIdMap}" var="map1">
                                <c:if test="${comment.commentId==map1.key}">
                                    <td>${map1.value}</td>
                                </c:if>
                            </c:forEach>
                            <td>${comment.commentStar}</td>
                            <c:forEach items="${Id_PhoneMap}" var="map2">
                                <c:if test="${comment.commentId==map2.key}">
                                    <td>${map2.value}</td>
                                </c:if>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- 分页 -->
                <t:page page="${searchct.page}" methodName="search"></t:page>
            </div>
        </div>
    </div>
</form>

</body>
</html>