<%--
  Created by IntelliJ IDEA.
  User: nanGuoMM
  Date: 2024/4/27
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="${pageContext.request.contextPath}/registerAndVerificationServlet" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <label for="username"></label><input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${register_err}</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <label for="password"></label><input name="password" type="password" id="password">
                    <br>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <label for="checkCode"></label><input name="checkCode" type="text" id="checkCode">
                    <img src="${pageContext.request.contextPath}/registerAndVerificationServlet" alt="验证图片"
                         id="checkImg">
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>
</div>
<script>
    document.getElementById("checkImg").onclick = function () {
        document.getElementById("checkImg").src = "${pageContext.request.contextPath}/registerAndVerificationServlet?" +
            new Date().getMilliseconds();
    }
</script>
</body>
</html>
