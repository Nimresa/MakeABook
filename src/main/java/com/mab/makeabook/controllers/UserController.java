package com.mab.makeabook.controllers;

import com.mab.makeabook.models.User;
import com.mab.makeabook.models.UserLogin;
import com.mab.makeabook.services.PageDataService;
import com.mab.makeabook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    PageDataService pageDataService;
    UserService userService;

    @Autowired
    public UserController(PageDataService pageDataService, UserService userService) {
        this.pageDataService = pageDataService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("register"));
        model.addAttribute("availablePages", pageDataService.getPages());
        return "register";
    }

    @PostMapping("/register")
    public String handleUserRegister(User user){
        try {
            userService.createUser(user);
            return "redirect:login?status=signup_success";
        }catch (Exception ex){
            return "redirect:register?status=signup_failed&message="+ex.getMessage();
        }
    }

    @GetMapping("/login")
    public String showLoginPage(
            @RequestParam(name = "status", required = false) String status,
            @RequestParam(name = "message", required = false) String message,
            Model model
    ){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("login"));
        model.addAttribute("availablePages", pageDataService.getPages());
        model.addAttribute("status", status);
        model.addAttribute("message", message);
        return "login";
    }

    @PostMapping("/login")
    public String handleUserLogin(UserLogin userLogin){
        try{
            User user = userService.verifyUser(userLogin);
            return "redirect:/myBooks"+ user.getId();
        }catch (Exception exception){
            return "redirect:login?status=login_failed&message="+exception.getMessage();
        }
    }

    @GetMapping("/myBooks")
    public String showMyBooks(Model model){
        model.addAttribute("appTitle", pageDataService.getAppTitle());
        model.addAttribute("pageInfo", pageDataService.getPage("myBooks"));
        model.addAttribute("availablePages", pageDataService.getPages());
        return "myBooks";
    }

    @PostMapping("/myBooks")
    public String handleMyBooks(UserLogin userLogin){
            return "redirect:/constructor";
    }

}
