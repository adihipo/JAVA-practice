package com.java.practice.java.controller;

import com.java.practice.java.service.BangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  private BangService bangService;

  @Autowired
  MainController(BangService bangService) {
    this.bangService = bangService;
  }

  @GetMapping("/")
  public String getHome(Model model) {
    model.addAttribute("allCards", bangService.getAllCards());
    return "index";
  }

}
