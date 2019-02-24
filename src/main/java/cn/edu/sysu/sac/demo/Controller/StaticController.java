package cn.edu.sysu.sac.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {
    
    @GetMapping("/")
    public String html() {
      return "index";
    }
}