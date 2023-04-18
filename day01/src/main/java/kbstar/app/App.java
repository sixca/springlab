package kbstar.app;

import kbstar.frame.TV;
import kbstar.tv.STV;

public class App {
    public static void main(String args[]){
        TV tv = (TV) new STV();    //여기만 STV, LTV 바꾸면 작동을하게됨
//        TV tv = new STV();
        tv.turnOn();
    }
}

// 이렇게 interface를 구상해두면, TV가 늦게 만들어지더라도 앱을 미리 만들어둘 수 있음.
