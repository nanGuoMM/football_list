<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>添加球队</title>
</head>
<body>
<h3>添加球队</h3>
<form action="${pageContext.request.contextPath}/listAndAddServlet" method="post">
    球队名称：<label>
    <input name="teamName">
</label><br>
    球队位置：<label>
    <input name="location">
</label><br>
    排序：<label>
    <input name="ordered">
</label><br>
    描述信息：<label>
    <textarea rows="5" cols="20" name="description"></textarea>
</label><br>
    状态：
    <label>
        <input type="radio" name="status" value="1">
    </label>正常
    <label>
        <input type="radio" name="status" value="0">
    </label>破产<br>

    <input type="submit" value="提交">
</form>
</body>
</html>