package com.kbstar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

//    브라우저에서 "/"요렇게 요청하면 "index"를 찾아라
    @RequestMapping("/")
    public String main(){
        return "index";
    }
}
