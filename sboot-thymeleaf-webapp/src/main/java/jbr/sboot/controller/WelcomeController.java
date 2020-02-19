package jbr.sboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

  @Value("${home.page.message}")
  private String welcomeMessage;

  @Value("${home.page.title}")
  private String homePageTitle;

  @Value("#{'${week.days}'.split(',')}")
  private List<String> weekDays;
  
  @Value("${header.name}")
  private String headerName;
  
  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("welcomeMessage", welcomeMessage);
    model.addAttribute("homePageTitle", homePageTitle);
    model.addAttribute("weekDays", weekDays);
    model.addAttribute("headerName", headerName);
    return "home";
  }

}
