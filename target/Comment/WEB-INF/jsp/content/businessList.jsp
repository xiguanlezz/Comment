<%--
  Created by IntelliJ IDEA.
  User: chenjie
  Date: 2020/2/2
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/all.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/pop.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/common/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/content/businessList.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="${pageContext.request.contextPath}/business/search" id="mainForm" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="hidden" id="message" name="id" value="${msg}"/>
    <input type="hidden" id="basePath" value="${pageContext.request.contextPath}"/>
    <input type="hidden" name="page.currentPage" id="currentPage" value="1"/>
    <div class="right">
        <div class="current">当前位置：<a href="#">内容管理</a> &gt; 商户管理</div>
        <div class="rightCont">
            <p class="g_title fix">商户列表</p>
            <table class="tab1">
                <tbody>
                <tr>
                    <td align="right" width="80">标题：</td>
                    <td>
<%--                        涉及到主标题和副标题的模糊查询, 先暂时存在title里面--%>
                        <input name="keyword" id="title" value="${searchbs.keyword}" class="allInput" type="text"/>
                    </td>
                    <td style="text-align: right;" width="150">
                        <input class="tabSub" value="查询" onclick="search('1');" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="tabSub" value="添加"
                               onclick="location.href='${pageContext.request.contextPath}/business/toadd'"
                               type="button"/>
                        <%--                        <t:auth url="/businesses/addPage" method="GET">--%>
                        <%--                            <input class="tabSub" value="添加" onclick="location.href='${basePath}/businesses/addPage'" type="button"/>--%>
                        <%--                        </t:auth>--%>
                    </td>
                </tr>
                </tbody>
            </table>
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th>序号</th>
                        <th>标题</th>
                        <th>副标题</th>
                        <th>城市</th>
                        <th>类别</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${bList}" var="item" varStatus="s">
                        <tr>
                            <td>${s.index + 1}</td>
                            <td>${item.businessTitle}</td>
                            <td>${item.businessSubtitle}</td>
                            <td>${item.businessCityCode}</td>
                            <td>${item.businessCateCode}</td>
                            <td>
                                    <%--                                <t:auth url="/businesses/${item.id}" method="PUT">--%>
                                    <%--                                    <a href="javascript:void(0);" onclick="modifyInit('${item.id}')">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;--%>
                                    <%--                                </t:auth>--%>
                                    <%--                                <t:auth url="/businesses/${item.id}" method="DELETE">--%>
                                    <%--                                    <a href="javascript:void(0);" onclick="remove('${item.id}')">删除</a>--%>
                                    <%--                                </t:auth>--%>
                                        <a href="#" onclick="toupdate(${item.businessId})">修改</a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;
                                        <a href="#" onclick="remove(${item.businessId})">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- 分页 -->
                 <t:page page="${searchbs.page}" methodName="search"></t:page>
            </div>
        </div>
    </div>
</form>
</body>
</html>
