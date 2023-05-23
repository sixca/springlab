package com.kbstar;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorController {
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model){       //예외상황이 발생되면 아래 내용이 실행
        model.addAttribute("msg",e.getMessage());
        model.addAttribute("center","error/error_page1");
        return "index";
    }
}

// 예외상황별로 메소드를 만듬. 잔액부족 오류, 금결원 접속 오류 등등