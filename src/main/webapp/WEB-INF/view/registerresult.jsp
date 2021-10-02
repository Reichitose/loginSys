<%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/1
  Time: 10:26
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
    <title>注册结果</title>
    <base href="<%=basePath%>"/>
</head>
<body>
<center>
    ${tips}<br/>

<a href="/reiCode/login.jsp">已有账户?点此登录</a>
</center>
</body>
</html>
