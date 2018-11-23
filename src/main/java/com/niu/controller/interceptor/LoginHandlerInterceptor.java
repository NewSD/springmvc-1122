package com.niu.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ami on 2018/11/23.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        //获取用户的url
        String url = request.getRequestURI();

        //判断用户访问的url是否公开地址,如果是则放行,实际开发中要将公开 地址配置在配置文件中
        if(url.indexOf("/login.action")>=0){//如果用户请求的登陆url是公开地址
            //放行
            return true;
        }

        //判断用户当前是否登陆，从当前session中取出用户身份信息
        //session中身份信息在用户登陆成功后设置进去的，这里用户身份信息key为activeUser
        HttpSession session = request.getSession();
        String activeUser = (String) session.getAttribute("activeUser");
        if(activeUser!=null){
            //如果session中存在用户身份信息，则放行
            return true;
        }

        //用户身份信息不合法，跳转登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

        //返回 true表示不拦截即放行
        //返回false表示拦截，不再向后执行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
