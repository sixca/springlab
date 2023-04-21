package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // http://127.0.0.1/
    @RequestMapping("/")
    public String main(){
        return "index";
    }

    //quics?page=bs01           명령어?데이터 :: get방식
    @RequestMapping("/quics")
    public String quics(String page){
        return page;
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }

}
