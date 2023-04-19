package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    // http://127.0.0.1/
    @RequestMapping("/")      //URL 지정
    public String main(){
        return "index";
    }
    @RequestMapping("/next")      //URL 지정
    public String next(){
        return "next";
    }
}
