package ss5.springsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String index(){
        return "home";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
}
