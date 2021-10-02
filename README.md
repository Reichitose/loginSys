# 基于SSM的登录登出系统

## 1.需要实现的功能

登录系统

记录上次访问时间以及登录次数

cookie两周免登陆

防止非法登录

注册功能

图片验证码



## 2.实现方案

### 登录系统

通过login.jsp页面提交的表单,使用service中的查询方法利用dao类进入数据库进行查询,如果有相应的user对象则返回登录成功

### 记录上次访问时间以及登录次数

在登录成功时,记录下当前的时间戳和自增一次登录次数,并通过update存放到数据库中,便于在下次登录时查询

### cookie两周免登陆

在登录成功时, 如果用户选择了一定时长内免登陆 , 将用户信息写入cookie, 设置相应的时间按, 并在login.jsp页面中嵌入判断是否已经有存在的cookies的代码,如果有则直接跳转到登录成功页面

### 防止非法登录

将需要登录成功之后才能展示的页面放入WEB-INF/view目录下,使用户不能直接访问这些页面,在外部只展示index.jsp , login.jsp , register.jsp.

### 注册功能

通过register.jsp页面提交的表单, 检查是否有重复用户名后, 记录时间戳 , 并给登录次数值赋0, 将数据写入数据库

### 图片验证码

通过maven引入第三方依赖 Easy-captcha进行验证码的生成和验证

## 3.额外附加的一些功能

### 一些基本的异常类

注册登录时的用户名密码为空的异常 , 注册登录时的验证码错误或为空的异常 , 并分别编写响应的页面用于给用户友好的提示

### 页面间的跳转

在登录失败等页面应当有重新登录等页面的跳转超链接 , 登录页面和注册页面 也应当有注册页面和登录页面的对应跳转连接. 

### 登出功能

当用户登录成功后,如果需要登出 , 在登录成功页面有相应的跳转链接,点击后会清除session退出登录状态, 并删除掉用户目前的cookie数据 , 便于另一个用户的登录.



## 4.项目结构

```
main
    ├─java
    │  └─com
    │      └─reiuy
    │          ├─controller
    │          │      CaptchaController.java
    │          │      UserController.java
    │          │
    │          ├─dao
    │          │      UserDao.java
    │          │      UserDao.xml
    │          │
    │          ├─entity
    │          │      User.java
    │          │
    │          ├─exception
    │          │      MethodException.java
    │          │      NameException.java
    │          │      PwdException.java
    │          │      UserException.java
    │          │      VcodeException.java
    │          │
    │          ├─handler
    │          │      GlobalExceptionHandler.java
    │          │
    │          ├─service
    │          │  │  UserService.java
    │          │  │
    │          │  └─impl
    │          │          UserServiceImpl.java
    │          │
    │          └─utils
    │                  MD5utils.java
    │
    ├─resources
    │      applicationContext.xml
    │      DispatcherServlet.xml
    │      jdbc.properties
    │      mybatis.xml
    │
    └─webapp
        │  index.jsp
        │  login.jsp
        │  register.jsp
        │
        └─WEB-INF
            │  web.xml
            │
            └─view
                    defaultError.jsp
                    loginfailed.jsp
                    loginsuccess.jsp
                    logout.jsp
                    methodError.jsp
                    nameError.jsp
                    pwdError.jsp
                    registerresult.jsp
                    vcodeError.jsp
```
