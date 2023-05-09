package com.kbstar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AJAXController {

    String dir = "ajax/";

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    //로그기록 사용 선언
    // http://127.0.0.1/map
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }

    @RequestMapping("/ajax01")
    public String map01(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"ajax01");
        return "index";
    }

    @RequestMapping("/ajax02")
    public String map02(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"ajax02");
        return "index";
    }
    @RequestMapping("/ajax03")
    public String map03(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"ajax03");
        return "index";
    }
    @RequestMapping("/ajax04")
    public String map04(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"ajax04");
        return "index";
    }
    @RequestMapping("/ajax05")
    public String map05(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"ajax05");
        return "index";
    }
}
