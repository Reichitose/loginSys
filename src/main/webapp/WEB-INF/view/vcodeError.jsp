<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/2
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>您的验证码输入错误</title>
</head>
<body>
<center>
    提示信息${msg}<br/>
    异常信息:${exception.message}
    <a href="/reiCode/login.jsp">点击此处重新登录</a>
</center>
</body>
</html>
