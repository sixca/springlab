package com.kbstar.controller;

import com.kbstar.dto.Cust;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/jsp")
public class JSPController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "jsp/";
    // 127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/jsp01")
    public String jsp01(Model model){
        model.addAttribute("num",10000.234);

        Cust cust = new Cust("id01","pwd01","<a href=''>K</a>");
        model.addAttribute("cust",cust);

        Date date = new Date();
        model.addAttribute("cdate",date);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp01");
        return "index";
    }
    @RequestMapping("/jsp02")
    public String jsp02(Model model){
        Cust cust = new Cust("id01","pwd01","james");
        model.addAttribute("rcust",cust);
        model.addAttribute("num",1);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp02");
        return "index";
    }
    @RequestMapping("/jsp03")
    public String jsp03(Model model){
        List<Cust> list= new ArrayList<>();
        list.add(new Cust("id01","pwd01","james1"));
        list.add(new Cust("id02","pwd02","james2"));
        list.add(new Cust("id03","pwd03","james3"));
        list.add(new Cust("id04","pwd04","james4"));
        list.add(new Cust("id05","pwd05","james5"));

        model.addAttribute("clist",list);

        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp03");
        return "index";
    }
    @RequestMapping("/jsp04")
    public String jsp04(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp04");
        return "index";
    }
    @RequestMapping("/jsp05")
    public String jsp05(Model model){
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"jsp05");
        return "index";
    }
}
