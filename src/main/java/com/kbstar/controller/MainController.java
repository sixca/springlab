package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MainController {

    @Autowired
    CustService custService;

    @Autowired
    private BCryptPasswordEncoder encoder;  //암호화

    @Value("${adminserver}")
    String adminserver;

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

    @RequestMapping("/pic")
    public String pic(Model model){
        model.addAttribute("center", "pic");
        return "index";
    }

    @RequestMapping("/websocket")
    public String websocket(Model model){
        model.addAttribute("adminserver", adminserver);
        model.addAttribute("center", "websocket");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/loginimpl")
    public String loginimpl(Model model, String id, String pwd
            ,HttpSession session) throws Exception {      //로그인 성공 시 session에다가 넣어둔다. 로긴 상태 유지
        Cust cust = null;
        String nextPage = "loginfail";
        try {
            cust = custService.get(id);
            if(cust != null && encoder.matches(pwd, cust.getPwd())){    //아이디가 있고, 해당하는 아이디의 pwd를 비교 후 일치하면
                nextPage = "loginok";
                session.setMaxInactiveInterval(1000);  //세션 유지 시간 설정 :: 1000초임. 지나면 세션 종료(로긴 튕김)
                session.setAttribute("logincust", cust);   //쎄션에 로긴정보를 박아두는 것  .. index에도 나오는 logincust
            }
        } catch (Exception e) {
            throw new Exception("시스템 장애, 잠시 후 다시 로그인 하세요");
        }
        model.addAttribute("center", nextPage);
        return "index";
    }

    @RequestMapping("/custinfo")   //로그인 사용자 아이디 클릭 시 정보조회
    public String custinfo(Model model, String id) throws Exception {
        Cust cust =null;
        try {
            cust = custService.get(id);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        model.addAttribute("custinfo", cust);    //뿌릴 정보를 준비하고
        model.addAttribute("center", "custinfo");     //센터에 정보를 뿌림. 익숙해 지세요!
        return "index";
    }

    @RequestMapping("/custinfoimpl")
    public String custinfoimpl(Model model, Cust cust) throws Exception {
        try {
            log.info("-----------"+cust.getPwd());
            cust.setPwd(encoder.encode(cust.getPwd()));  //암호화된 pwd를 다시 엔코딩.. 내장함수여
            custService.modify(cust);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
        }
        return "redirect:/custinfo?id="+cust.getId();         //수정이 일어난 후, "/custinfo"로 다시 보냄
    }


    @RequestMapping("/logout")
    public String logout(Model model, HttpSession session){
        if(session != null){             //로긴 상태면
            session.invalidate();        //세션에서 정보를 없애라
        }
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model, Cust cust
                                ,HttpSession session) throws Exception {
        try {
            cust.setPwd(encoder.encode(cust.getPwd()));  //화면에서 입력한 pwd를 가져와서 암호화 한 다음에 다시 cust 객체에 넣어서 register
            custService.register(cust);
            session.setAttribute("logincust", cust);   //회원가입 시 바로 로그인 처리 되도록하기
        } catch (Exception e) {
            throw new Exception("가입오류");
        }
        model.addAttribute("rcust", cust);
        model.addAttribute("center", "registerok");
        return "index";
    }
}
