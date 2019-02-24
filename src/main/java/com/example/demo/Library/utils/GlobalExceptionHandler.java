package com.example.demo.Library.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.example.demo.Bean.ResBody;
import com.example.demo.Service.NetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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