package com.kbstar.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ChartImplController {
    @RequestMapping("/chart02")
    public Object chart02(){
        // {'category':[], 'datas':[]} :: 복수의 배열 데이터를 받을 때, 객체로 받기
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for(int i=0; i<=12; i++){ //data가 12개임
            Random r = new Random();
            int cnt = r.nextInt(10000)+1;
            jaCnt.add(cnt);
        }
         JSONArray jaYear = new JSONArray();
        for(int i=2011; i<=2023; i++){
            jaYear.add(i);
        }   // 2011~2023년
        jo.put("category", jaYear);
        jo.put("datas", jaCnt);
        // {'category':[], 'datas':[]}
        return jo;
    }
    @RequestMapping("/chart0301")
    public Object chart0301(){
        // [[],[]] :: 배열 안에 배열
        JSONArray ja = new JSONArray();
        for(int i=1; i<=5; i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:"+num); // 첫번째 요소
            jadata.add(num);   // 두번째 요소
            ja.add(jadata);    //메인 배열(ja)에 위 2개 요소를 담은 배열(jadata)을 넣음
        }
        return ja;
    }
    @RequestMapping("/chart0302")
    public Object chart0302(){
        // [[],[]] :: 배열 안에 배열
        JSONArray ja = new JSONArray();
        // JSONArray ja2 = new JSONArray();
        for(int n=1; n<=3; n++){
            for(int i=1; i<=34; i++){
                Random r = new Random();
                int num = r.nextInt(5000)+1;
                JSONArray jadata = new JSONArray();
                jadata.add("data:"+num); // 첫번째 요소
                jadata.add(num);   // 두번째 요소
                ja.add(jadata);    //메인 배열(ja)에 위 2개 요소를 담은 배열(jadata)을 넣음
            }
        }
        return ja;
    }

    @RequestMapping("/chart0303")
    public Object chart0303(){
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for(int i=0; i<=10; i++){
            Random r = new Random();
            int cnt = r.nextInt(2000)+1;
            jaCnt.add(cnt);
        }
        jo.put("datas", jaCnt);
        return jo;
    }
}
