package com.reiuy.handler;


import com.reiuy.exception.MethodException;
import com.reiuy.exception.NameException;
import com.reiuy.exception.PwdException;
import com.reiuy.exception.VcodeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


//定义全局异常处理器
@ControllerAdvice
public class GlobalExceptionHandler {

    //用来执行用户名为空的异常
    @ExceptionHandler(NameException.class)
    public ModelAndView doNameException(Exception exception){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","您的用户名不能为空");
        mv.addObject("exception",exception);
        mv.setViewName("nameError");
        return mv;
    }

    //用来执行密码为空的异常
    @ExceptionHandler(PwdException.class)
    public ModelAndView doPwdException(Exception exception){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","您的密码不能为空");
        mv.addObject("exception",exception);
        mv.setViewName("pwdError");
        return mv;
    }




    //用来执行登录请求方法为get的异常
    @ExceptionHandler(MethodException.class)
    public ModelAndView doMethodException(Exception exception){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","您的登录方式有误,请重新登录");
        mv.addObject("exception",exception);
        mv.setViewName("methodError");
        return mv;
    }


    @ExceptionHandler(VcodeException.class)
    public ModelAndView doVcodeException(Exception exception){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","您的验证码输入有误,请重新登录");
        mv.addObject("exception",exception);
        mv.setViewName("vcodeError");
        return mv;
    }







    //用来执行除了定义之外的所有异常
    @ExceptionHandler
    public ModelAndView dodefaultException(Exception exception){
        ModelAndView mv= new ModelAndView();
        mv.addObject("msg","发生了未知的错误");
        mv.addObject("exception",exception);
        mv.setViewName("defaultError");
        return mv;
    }

}
