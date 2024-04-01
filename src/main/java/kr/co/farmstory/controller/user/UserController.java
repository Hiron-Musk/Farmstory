package kr.co.farmstory.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("user")
public class UserController {

    @GetMapping("/login")
    public String loginFrom() {
        return "/user/login";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "redirct:/index";
//    }

    @GetMapping("/register")
    public String registerForm() {
        return "/user/register";
    }

//    @PostMapping("/register")
//    public String register() {
//        return "redirect:/user/register";
//    }
}
