package lab4.phamvothanhtuan.controller;

import lab4.phamvothanhtuan.Validator.annotation.ValidUserId;
import lab4.phamvothanhtuan.entity.User;
import jakarta.validation.Valid;
import lab4.phamvothanhtuan.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.BindException;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){return "user/login";}

    @GetMapping("/register")
    public  String register(Model model){
        model.addAttribute("user",new User());
        return "user/register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user")User user , BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            bindingResult.getFieldError().forEach(error
           -> model.addAttribute((error.getField()+"_error",error.getDefaultMessage()));
            return "user/register";
        }
    }
}
