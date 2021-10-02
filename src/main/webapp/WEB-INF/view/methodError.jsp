<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/2
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>您的登录方式有误</title>
</head>
<body>
<center>
    提示信息${msg}<br/>
    异常信息:${exception.message}
    <a href="/reiCode/login.jsp">点击此处重新登录</a>
</center>
</body>
</html>
