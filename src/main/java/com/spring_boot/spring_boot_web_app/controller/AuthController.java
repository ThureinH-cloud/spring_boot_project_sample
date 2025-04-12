package com.spring_boot.spring_boot_web_app.controller;

import com.spring_boot.spring_boot_web_app.dto.RegisterDto;
import com.spring_boot.spring_boot_web_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model){
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value = "/register/save")
    public String userSave(@Valid @ModelAttribute("user") RegisterDto user, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.save(user);
        return "redirect:/register";
    }
}
