package cn.edu.sysu.sac.demo.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.sysu.sac.demo.Bean.ResBody;
import cn.edu.sysu.sac.demo.Service.NetService;

@RestController
@RequestMapping("/api")
public class RootController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  NetService netService;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ResBody hello() {
    logger.info("info");
    logger.warn("warn");
    return netService.resSuccess();
  }

  @RequestMapping(value="/test-connection", method=RequestMethod.GET)
  public Map<String, Object> home() {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("id", UUID.randomUUID().toString());
    model.put("content", "Hello World");
    return model;
  }

  @RequestMapping(value = "/session", method = RequestMethod.GET) 
  public ResBody checkSession(HttpSession session) {
    if (session.getAttribute("uid") == null) return netService.resSuccess();
    else return netService.resSuccess(session.getAttribute("uid"));
  }
}