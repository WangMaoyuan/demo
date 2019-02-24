package com.example.demo.Library.utils.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LogInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) {
    // 全局日志
    String method = req.getMethod();
    String Uri = req.getRequestURI();
    String queryString = req.getQueryString();
    String remoteAddr = req.getRemoteAddr();
    System.out.println("* * * * * * * * * * * * * * * * * *");
    System.out.println(method + ' ' + Uri);
    System.out.println("With " + queryString);
    System.out.println("From " + remoteAddr);
    System.out.println("* * * * * * * * * * * * * * * * * *");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) {}

  @Override
  public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object handler, Exception e) {}
}