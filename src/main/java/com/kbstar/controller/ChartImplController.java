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
        // {'category':[], 'datas':[]}
        JSONObject jo = new JSONObject();

        JSONArray jaCnt = new JSONArray();
        for(int i=1;i<=12;i++){
            Random r = new Random();
            int cnt = r.nextInt(10000)+1;
            jaCnt.add(cnt);
        }
        JSONArray jaYear = new JSONArray();
        for(int i=2011; i<=2023;i++){
            jaYear.add(i);
        }
        jo.put("category",jaYear);
        jo.put("datas",jaCnt);
        // {'category':[], 'datas':[]}

        return jo;
    }

    @RequestMapping("/chart0301")
    public Object chart0301(){
        // [[],[]]
        JSONArray ja = new JSONArray();
        for(int i=1;i<=5;i++){
            Random r = new Random();
            int num = r.nextInt(20)+1;
            JSONArray jadata = new JSONArray();
            jadata.add("data:"+num);
            jadata.add(num);
            ja.add(jadata);
        }
        return ja;
    }

}
