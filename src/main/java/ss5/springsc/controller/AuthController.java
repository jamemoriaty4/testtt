package ss5.springsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ss5.springsc.model.entity.User;
import ss5.springsc.repository.UserRepository;

@Controller

public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/logon")
    public String login(){
        return "login";
    }
}
