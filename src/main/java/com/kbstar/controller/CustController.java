package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j       //Logger 선언없이 로그를 사용할 수 있게 됨
@Controller
@RequestMapping("/cust")          //라우터 생성 같은건가..
public class CustController {

    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    //로그기록 사용 선언

    String dir = "cust/";

    //127.0.0.1/cust
    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        //logger.info("--------------로그찍앗---------------");
        Random r = new Random();
        int inx = r.nextInt(1000)+1;
        log.info(inx+"");     //1000 이하 숫자가 로그에 찍히도록
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model, String id){
        Cust cust = new Cust(id, "xxx", "james");
        model.addAttribute("gcust", cust);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"get");
        return "index";
    }

    @RequestMapping("/all")
    public String all(Model model){
        List<Cust> list = new ArrayList<>();
        list.add(new Cust ("id01", "pwd01", "james"));
        list.add(new Cust ("id02", "pwd02", "johnson"));
        list.add(new Cust ("id03", "pwd03", "thomson"));
        list.add(new Cust ("id04", "pwd04", "maxon"));
        list.add(new Cust ("id05", "pwd05", "jason"));
        model.addAttribute("clist", list);

        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }



}
