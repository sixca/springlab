package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//ajax요청이 들어오면 실행된 컨트롤러를 따로 만듬
@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }

    @RequestMapping("/getdata")
    public Object getdata(){
        List<Cust> list = new ArrayList<>();
        list.add(new Cust ("id01", "pwd01", "james"));
        list.add(new Cust ("id02", "pwd02", "johnson"));
        list.add(new Cust ("id03", "pwd03", "thomson"));
        list.add(new Cust ("id04", "pwd04", "maxon"));
        list.add(new Cust ("id05", "pwd05", "jason"));

        // Java Object ---> JSON :: 자바객체를 스크립트 문장으로 파싱한다
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cust obj:list){
            JSONObject jo = new JSONObject();

            Random r = new Random();
            int i = r.nextInt(100)+1;    //계속 새롭게 생기는 데이터를 표현

            jo.put("id", obj.getId()+i);
            jo.put("pwd", obj.getPwd()+i);
            jo.put("name", obj.getName()+i);
            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/checkid")
    public Object checkid(String id){
        int result = 0;
        if(id.equals("qqqq") || id.equals("aaaa") || id.equals("ssss")){
            result = 1;
        }
        return result;
    }

    @RequestMapping("/markers")
    public Object markers(String loc){
    List<Marker> list = new ArrayList<>();
        if(loc.equals("s")){
            list.add(new Marker(100, "국밥", "http://www.nate.com", 37.573617, 126.976041, "a.jpg", "s" ));
            list.add(new Marker(101, "만두", "http://www.naver.com", 37.577617, 126.973041, "b.jpg", "s" ));
            list.add(new Marker(102, "곱창", "http://www.daum.net", 37.575617, 126.978041, "c.jpg", "s" ));
        }else if(loc.equals("b")){
            list.add(new Marker(103, "국밥", "http://www.nate.com", 35.1586975, 129.1663842, "a.jpg", "b" ));
            list.add(new Marker(104, "만두", "http://www.naver.com", 35.1536975, 129.1673842, "b.jpg", "b" ));
            list.add(new Marker(105, "곱창", "http://www.daum.net", 35.1526975, 129.1613842, "c.jpg", "b" ));

        }else if(loc.equals("j")){
            list.add(new Marker(100, "국밥", "http://www.nate.com", 33.2426141, 126.4019696,  "a.jpg", "j" ));
            list.add(new Marker(101, "만두", "http://www.naver.com",33.2416141, 126.4039696,  "b.jpg", "j" ));
            list.add(new Marker(102, "곱창", "http://www.daum.net", 33.2476141, 126.4099696,  "c.jpg", "j" ));
        }
        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id",obj.getId());
            jo.put("title",obj.getTitle());
            jo.put("target",obj.getTarget());
            jo.put("lat",obj.getLat());
            jo.put("lng",obj.getLng());
            jo.put("img",obj.getImg());
            jo.put("loc",obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }
}
