package com.niu.controller.exceptionResolver;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ami on 2018/11/23.
 */
public class CustomerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        CustomerException customerException = null;

        //如果是系统自定义的异常有针对性的进行业务处理
        if(ex instanceof CustomerException){
            //获取异常信息
            //比如还可以记录异常日志...
            //..

            customerException = (CustomerException)ex;

        }else{
            //如果抛出的异常不是系统自定义的异常

            //提示信息为“系统执行出错，请与管理员联系。。”
            //重新构造 一个自定义的异常对象
            customerException  = new CustomerException("系统执行出错，请与管理员联系");
            //比如还可以记录异常日志...
            //..

        }

        //获取异常信息
        String message =customerException.getMessage();

        //将请求转发错误信息页面，在错误页面上显示错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("message", message);

        return modelAndView;
    }
}
