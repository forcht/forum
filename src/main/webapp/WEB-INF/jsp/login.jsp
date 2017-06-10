<%--
  Created by IntelliJ IDEA.
  User: haitang
  Date: 2017/6/8
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script src="${pageContext.request.contextPath}/resources/js/user.js"></script>
</head>
<body>
<br>
<form action="/Forum/from/login" method="post" onsubmit="return login();">
    <table border="1" align="center" width="25%">
        <caption>用户登录</caption>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username" id="username">
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password">
        </tr>
        <tr>
            <td>
                <input type="checkbox" name="remember">记住我
            </td>
              <c:set var="data" scope="page" value="${data}"/>
                <c:if test="${not empty data}">
                    <td>
                        <label id="tip" style="color: #f81c2e">${data}</label>
                    </td>
                </c:if>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重设">&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/Forum/to/register">注册</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
