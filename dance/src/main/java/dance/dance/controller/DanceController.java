package dance.dance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DanceController {

  @RequestMapping("/")
  public String indexPage() {
    return "index";
  }
}
