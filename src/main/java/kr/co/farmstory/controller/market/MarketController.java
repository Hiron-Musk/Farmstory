package kr.co.farmstory.controller.market;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MarketController {

    @GetMapping("/market/list")
    public String list(){
        return "market/list";
    }
}
