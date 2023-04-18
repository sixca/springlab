package com.kbstar.app;

import com.kbstar.frame.TV;
import com.kbstar.tv.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//IOC의 개념을 실습으로 알아보자.
public class App {
    public static void main(String args[]){
    //spring을 활용해서 TV라는 객체를 가져와봅시다
        ApplicationContext factory =    //판때기를 만들어라
                new ClassPathXmlApplicationContext("spring.xml");
    //spring.xml에 박아둔 bean을 활용해서 '역제어IOC' 구현.  "stv, ltv"만 바꾸면 기능을 쓸 수 있지.
        TV tv = (TV) factory.getBean("stv");    //stv를 찾아라, stv는 spring.xml에 박아뒀다,
        tv.turnOn();

        // TV tv = new STV(); tv로 STV를 쓰겠다. 이렇게 순방향 제어를 했었지
    }
}

// 이렇게 interface를 구상해두면, TV가 늦게 만들어지더라도 앱을 미리 만들어둘 수 있음.
