package com.example.samplemybatis.controller;

import com.example.samplemybatis.entity.UserInfo;
import com.example.samplemybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/signupFrom")
    public String signupFrom(UserInfo userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(UserInfo userCreateForm) {
//        if (bindingResult.hasErrors()) {
//            return "signup_form";
//        }

        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
//            bindingResult.rejectValue("password2", "passwordInCorrect", "2개의 패스워드가 일치하지 않습니다.");

            return "signup_form";
        }

        userService.createUser(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1());

        return "redirect:/";
    }
}
