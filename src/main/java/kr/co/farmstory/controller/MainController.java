package kr.co.farmstory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }



}
