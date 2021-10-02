<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/2
  Time: 9:18
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
    <title>主页</title>
    <base href="<%=basePath%>"/>
</head>
<body>
    <center>
        欢迎访问,您可以选择<br/>
        <a href="/reiCode/register.jsp">注册</a>
        <a href="/reiCode/login.jsp">登录</a>

    </center>
</body>
</html>
