package jbr.sboot.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Map<String, Object> model) {
    model.put("date", new Date());
    return "home";
  }
}
