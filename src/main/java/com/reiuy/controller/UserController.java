package com.reiuy.controller;


import com.reiuy.entity.User;
import com.reiuy.exception.*;
import com.reiuy.service.UserService;
import com.reiuy.utils.MD5utils;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;


@Controller

public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/user/registerUser.do")
    public ModelAndView register(User user,String captcha,HttpServletRequest request) throws UserException {
        ModelAndView mv = new ModelAndView();
        if("".equals(user.getUsername())){
            throw new NameException("用户名为空");
        }
        if("".equals(user.getUserpwd())){
            throw new PwdException("密码为空");
        }
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            throw new VcodeException("验证码错误");
        }

        String tips = "";
        int nums = 0;

        User user_temp = new User();
        user_temp = userService.namecheck(user);
        if(null == user_temp) {


            user.setUserlastlogin(new Timestamp(new java.util.Date().getTime()));
            //设置上次登录时间
            user.setUserlogincount(0);
            //设置登录次数为0

            String text = MD5utils.getMd5(user.getUserpwd(), "UTF-8", false, 32);
            //对密码进行md5加密
            user.setUserpwd(text);
            //加密后放入


            nums = userService.registerUser(user);

            if (nums > 0){
                tips = "用户"+user.getUsername()+"注册成功";
            }else {
                tips = "注册失败";
            }
        }else {
            tips = "您的用户名已经被使用,请重试";
        }
        mv.addObject("tips",tips);
        mv.setViewName("registerresult");


        return mv;
    }



    @RequestMapping(value = "/user/login.do")
    public ModelAndView login(String username, String userpwd, String loginfree,String captcha ,HttpServletResponse response,HttpServletRequest request)throws UserException{
        if("GET".equals(request.getMethod())){
            throw  new MethodException("错误的访问方式");
        }
        ModelAndView mv = new ModelAndView();

        if("".equals(username)){
            throw new NameException("用户名为空");
        }
        if("".equals(userpwd)){
            throw new PwdException("密码为空");
        }
        if (!CaptchaUtil.ver(captcha, request)) {
            CaptchaUtil.clear(request);  // 清除session中的验证码
            throw new VcodeException("验证码错误");
        }

        String tip_time = "";
        String tip_count = "";
        String tips = "";

        User user_temp = new User();
        //定义了一个临时的user对象来作为查找对象


        String text = MD5utils.getMd5(userpwd,"UTF-8",false,32);
        user_temp.setUsername(username);
        user_temp.setUserpwd(text);
        //对临时的user进行填充


        User user = userService.logincheck(user_temp);
        //通过查找拿到user对象
        //如果找到了已注册的用户,将会返回用户,如果没找到则user对象为空,说明并没有注册过

        if(null == user){
            tips = "登录失败,请检查您的用户名和密码";
            mv.addObject("tips",tips);
            mv.setViewName("loginfailed");

        }else {
            tip_time = String.valueOf(user.getUserlastlogin());
            tip_count = String.valueOf(user.getUserlogincount());
            //获得上次的登录时间和登录次数,并转换为字符串

            user.setUserlastlogin(new Timestamp(new java.util.Date().getTime()));
            //将现在的时间设置为登录的时间戳
            user.setUserlogincount(user.getUserlogincount()+1);
            //登录次数+1
            userService.updateusertime(user);

            request.getSession().setAttribute("username",username);
            //将username放入session

            if("y".equals(loginfree)) {
                Cookie userNameCookie = new Cookie("userName", username);
                Cookie userPwdCookie = new Cookie("userPwd", userpwd);
                Cookie userLastlogin = new Cookie("userLastlogin",(String.valueOf(user.getUserlastlogin())).replace(" ",""));
                Cookie userLogincount = new Cookie("userLogincount",String.valueOf(user.getUserlogincount()));

                userNameCookie.setMaxAge(24 * 60 * 60);
                userPwdCookie.setMaxAge(24 * 60 * 60);
                userLastlogin.setMaxAge(24 * 60 * 60);
                userLogincount.setMaxAge(24 * 60 * 60);
                userNameCookie.setPath("/");
                userPwdCookie.setPath("/");
                userLastlogin.setPath("/");
                userLogincount.setPath("/");
                response.addCookie(userNameCookie);
                response.addCookie(userPwdCookie);
                response.addCookie(userLastlogin);
                response.addCookie(userLogincount);
            }

            tips = "登录成功!欢迎回来,"+user.getUsername();
            mv.addObject("tip_time",tip_time);
            mv.addObject("tip_count",tip_count);
            mv.addObject("tips",tips);
            mv.setViewName("loginsuccess");

        }


        return mv;
    }

    @RequestMapping("/logout.do")
    public ModelAndView logout(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        request.getSession().invalidate();

        Cookie userNameCookie = new Cookie("userName", null);
        Cookie userPwdCookie = new Cookie("userPwd", null);
        Cookie userlastCookie = new Cookie("userLastlogin",null);
        Cookie usercountCookie = new Cookie("userLogincount",null);
        userNameCookie.setMaxAge(0);
        userPwdCookie.setMaxAge(0);
        userlastCookie.setMaxAge(0);
        usercountCookie.setMaxAge(0);
        userNameCookie.setPath("/");
        userPwdCookie.setPath("/");
        userlastCookie.setPath("/");
        usercountCookie.setPath("/");

        response.addCookie(userNameCookie);
        response.addCookie(userPwdCookie);
        response.addCookie(userlastCookie);
        response.addCookie(usercountCookie);

        mv.addObject("msg","您已登出");
        mv.setViewName("logout");
        return mv;
    }


}
