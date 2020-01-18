package com.sq.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Author:   chenfeiliang
 * Description:
 */
public class InterceptorConfig implements HandlerInterceptor {
        private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("hello");
        log.error("---------------------查看文章详情----------------------------");
        return true;

    }


    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.error("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }


    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.error("---------------视图渲染之后的操作-------------------------0");
    }

}