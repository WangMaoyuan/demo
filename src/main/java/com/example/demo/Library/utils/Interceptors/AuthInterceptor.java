package com.example.demo.Library.utils.Interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws IOException {
    HttpSession session = req.getSession();
    // 当session存在时，已登录，拦截器不工作
    // session不存在时，未登录，拦截器工作，重定向到登录
    if (session.getAttribute("uid") == null) {
      // TODO: 重定向到登录页面
      // 一例：res.sendRedirect("/login");
      logger.warn("NOT_LOGIN");
      return true;
    } else return false;
  }
}