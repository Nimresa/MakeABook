package com.mab.makeabook.controllers;

import com.mab.makeabook.services.PageDataService;
import com.mab.makeabook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConstructorController {
    PageDataService pageDataService;
    UserService userService;

    @Autowired
    public ConstructorController(PageDataService pageDataService, UserService userService) {
        this.pageDataService = pageDataService;
        this.userService = userService;
    }

    @GetMapping("/constructor")
    public String showConstructorPage(Model model){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("constructor"));
        model.addAttribute("availablePages", pageDataService.getPages());
        return "constructor";
    }
}
