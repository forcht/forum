<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/8
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
<form action="/Forum/from/register" method="post" onsubmit="return register()">
    <label>邮箱</label>
    <input id="email" type="email" name="email" placeholder="请输入您的邮箱" ><br>
    <label>用户名</label>
    <input id="username" type="text" name="username" placeholder="请输入您的用户名"><br>
    <label>密&nbsp&nbsp码</label>
    <input id="password" type="password" name="password" placeholder="请输入您的密码"><br>
    <label>确定密码</label>
    <input id="password1" type="password" name="password1" placeholder="请再次输入您的密码"><br>
    <input type="submit" value="确定">
    <input type="reset" value="重设">
    <a href="/Forum/to/login">登录</a>
</form>
</body>
</html>
