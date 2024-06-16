<%--
  Created by IntelliJ IDEA.
  User: nanGuoMM
  Date: 2024/4/25
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>nanGuoMM的足球队</title>
</head>
<body>
<h1>当前用户:${cookie.nanGuoMM_football_username.value}</h1>
<a href="${pageContext.request.contextPath}/addTeam.jsp" target="_self"><input type="button" value="新增"></a><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>球队名称</th>
        <th>球队位置</th>
        <th>球队介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <jsp:useBean id="teams" scope="request" type="java.util.List"/>
    <c:forEach items="${teams}" var="team">
        <tr align="center">
            <td>${team.ordered}</td>
            <td>${team.teamName}</td>
            <td>${team.location}</td>
            <td>${team.description}</td>
            <c:if test="${team.status == 1}">
                <td>正常</td>
            </c:if>
            <c:if test="${team.status != 1}">
                <td>破产</td>
            </c:if>
            <td>
                <a href="${pageContext.request.contextPath}/updateAndSelectServlet?teamId=${team.id}" >修改</a>
                <a href="${pageContext.request.contextPath}/deleteServlet?teamId=${team.id}" >删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

