<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/1
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"+request.getServerName()
            + ":" + request.getServerPort() +request.getContextPath() + "/";

    //通过字符串拼接方式完成指定<base>标签内容的拼接
%>
<html>
<head>
    <title>注册用户</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<div align="center">
    <form action="user/registerUser.do" method="post">
        <table>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="userpwd"></td>
            </tr>
            <tr>
                <td><img src="captcha.do" width="130px" height="48px" /></td><br/>
                <td>请输入验证码<input type="text" name="captcha" placeholder="请输入验证码"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <center>
    <a href="/reiCode/login.jsp">已有账号?点此登录</a>
</center>
</div>
</body>
</html>
