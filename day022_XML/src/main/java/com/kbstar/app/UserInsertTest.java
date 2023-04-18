package com.kbstar.app;

import com.kbstar.dto.UserDTO;
import com.kbstar.frame.MyService;
import com.kbstar.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserInsertTest {
    public static void main(String[] args) {
        ApplicationContext factory =
                new ClassPathXmlApplicationContext("spring.xml");
        MyService<String, UserDTO> service =
                (MyService<String, UserDTO>) factory.getBean("uservice");  //uservice 주세요

        UserDTO u = new UserDTO("id01", "pwd01", "lee");
        service.register(u);
    }

}
