package com.example.demo.Library.utils;

import java.io.File;
import java.io.IOException;

import com.example.demo.Library.utils.Interceptors.AuthInterceptor;
import com.example.demo.Library.utils.Interceptors.LogInterceptor;

import org.springframework.context.annotation.Configuration;
// import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
// import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class Configure extends WebMvcConfigurationSupport {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LogInterceptor()).addPathPatterns("/api/**");
    // 登录状态检查的拦截器
    // 若未登录，则工作
    // 应当拦截所有需要登录状态的api请求
    // 用exclude链接所有不需要登录状态的api
    registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/member/login")
        .excludePathPatterns("/api/*");
    super.addInterceptors(registry);
  }

  private static final String[] CLASSPATH_RESOURCE_LOCATIONS = { "classpath:/META_INF/resources/",
      "classpath:/resources/", "classpath:/static/", "classpath:/public/" };

  // @Override
  // public void addViewControllers(ViewControllerRegistry registry) {
  //   registry.addViewController("/").setViewName("redirect:/index.html");
  //   registry.addViewController("/error").setViewName("error.html");
  //   registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  //   super.addViewControllers(registry);
  // }

  // @Override
  // public void configurePathMatch(PathMatchConfigurer configurer) {
  // super.configurePathMatch(configurer);
  // configurer.setUseSuffixPatternMatch(false);
  // }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    File directiory = new File("");
    try {
      registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
          .addResourceLocations("file:" + directiory.getCanonicalPath() + "/");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}