package com.blog.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ProcessInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());
      
        @Override  
        public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

            logger.info("执行拦截请求:...............{}",httpServletRequest.getMethod());
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
      
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
      
            httpServletResponse.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  
      
            httpServletResponse.setHeader("X-Powered-By","Jetty");  
      
      
            String method= httpServletRequest.getMethod();  
      
            if (method.equals("OPTIONS")){  
                httpServletResponse.setStatus(200);  
                return false;  
            }  
      
            System.out.println(method);  
      
            return true;  
        }  
      
        @Override  
        public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
      
        }  
      
        @Override  
        public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {  
      
        }  
    }  