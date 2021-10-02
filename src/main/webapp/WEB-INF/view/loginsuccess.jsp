<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/1
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<center>
    ${tips}<br/>
    您的上次登录时间是${tip_time},这是您的第${tip_count}次登录

    <a href="/reiCode/logout.do">点击登出</a>
</center>

</body>
</html>
