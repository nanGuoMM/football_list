
<%--
  Created by IntelliJ IDEA.
  User: nanGuoMM
  Date: 2024/4/27
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>

<div id="loginDiv" style="height: 350px">
    <form action="${pageContext.request.contextPath}/loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${err_msg}</div>
        <p>Username:<label for="username"></label><input id="username" name="username" type="text" value="${cookie.nanGuoMM_football_username.value}"></p>

        <p>Password:<label for="password"></label><input id="password" name="password" type="password" value="${cookie.nanGuoMM_football_password.value}"></p>
        <p>Remember:<label for="remember"></label><input id="remember" name="remember" type="checkbox" value="1"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">
            <a href="register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>
