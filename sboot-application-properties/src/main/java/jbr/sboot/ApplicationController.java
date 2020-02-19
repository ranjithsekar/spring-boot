package jbr.sboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

  @Value("${app.welcome.message}")
  private String welcomeMessage;
  
  @Value("#{'${app.week.days}'.split(',')}")
  private List<String> weekDays;

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("welcomeMessage", welcomeMessage);
    model.addAttribute("weekDays", weekDays);
    
    return "home";
  }

}
