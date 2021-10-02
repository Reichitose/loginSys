<%@ page import="com.reiuy.entity.User" %>
<%@ page import="com.reiuy.utils.MD5utils" %><%--
  Created by IntelliJ IDEA.
  User: RE1UY
  Date: 2021/10/1
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://"+request.getServerName()
            + ":" + request.getServerPort() +request.getContextPath() + "/";

    //通过字符串拼接方式完成指定<base>标签内容的拼接
%>
<%
    Cookie[]cookies = request.getCookies();

    if(cookies != null) {
        String username = "";
        String userpwd = "";
        String tips;
        String tip_time = "";
        String tip_count = "";
        for (Cookie cookie : cookies) {
            if ("userName".equals(cookie.getName())) {
                username = cookie.getValue();
            }
            if ("userPwd".equals(cookie.getName())) {
                userpwd = cookie.getValue();
            }
            if("userLastlogin".equals(cookie.getName())){
                tip_time = cookie.getValue();
            }
            if ("userLogincount".equals(cookie.getName())){
                tip_count = cookie.getValue();
            }
        }
        if (!"".equals(username) && !"".equals(userpwd)) {
            tips = "登录成功!欢迎回来"+username;
            request.setAttribute("tips",tips);
            request.setAttribute("tip_time",tip_time);
            request.setAttribute("tip_count",tip_count);
            request.getRequestDispatcher("/WEB-INF/view/loginsuccess.jsp").forward(request, response);
        }
    }
%>

<html>
<head>
    <title>登录</title>
    <base href="<%=basePath%>"/>
</head>

<body>
<div align="center">
    <form action="user/login.do" method="post">
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
                <td><input type="checkbox" name="loginfree" value="y"></td>
                <td>一天内免登录</td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>
</div>
<div>
    <center>
    <a href="/reiCode/register.jsp">没有账号?点此注册</a>
    </center>
</div>
</body>
</html>
