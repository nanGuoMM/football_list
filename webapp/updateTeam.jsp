<jsp:useBean id="team" scope="request" type="com.nanGuoMM.pojo.FootballTeam"/>
<%--
  Created by IntelliJ IDEA.
  User: nanGuoMM
  Date: 2024/4/25
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改球队</title>
</head>
<body>
<h3>修改球队</h3>
<form action="${pageContext.request.contextPath}/updateAndSelectServlet" method="post">
    <input name="id" type="hidden" value="${team.id}">
    球队名称：<label>
    <input name="teamName" value="${team.teamName}">
</label><br>
    球队位置：<label>
    <input name="location" value="${team.location}">
</label><br>
    排序：<label>
    <input name="ordered" value="${team.ordered}">
</label><br>
    描述信息：<label>
    <textarea rows="5" cols="20" name="description">${team.description}</textarea>
</label><br>
    状态：<c:if test="${team.status==1}">
    <label>
        <input type="radio" name="status" value="1" checked>
    </label>正常
    <label>
        <input type="radio" name="status" value="0">
    </label>破产<br>
</c:if>
    <c:if test="${team.status!=1}">
        <label>
            <input type="radio" name="status" value="1">
        </label>正常
        <label>
            <input type="radio" name="status" value="0" checked>
        </label>破产<br>
    </c:if>

    <input type="submit" value="提交">
</form>
</body>
</html>
