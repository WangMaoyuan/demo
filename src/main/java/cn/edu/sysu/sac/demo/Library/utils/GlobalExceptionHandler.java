package cn.edu.sysu.sac.demo.Library.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.sysu.sac.demo.Bean.ResBody;
import cn.edu.sysu.sac.demo.Service.NetService;

@ControllerAdvice
public class GlobalExceptionHandler {
  @Autowired
  NetService netService;
  @Autowired
  ResBody resBody;

  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public ResBody handle(Exception e) {
    StringWriter stringWriter = new StringWriter();
    e.printStackTrace(new PrintWriter(stringWriter));
    return netService.resError(stringWriter.toString());
  } 
}