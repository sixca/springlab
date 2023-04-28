package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.error.Mark;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;



//ajax요청이 들어오면 실행된 컨트롤러를 따로 만듬
@RestController
public class AjaxImplController {
    @Autowired
    CustService custService;
    @Autowired
    MarkerService markerService;

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
    public Object checkid(String id) throws Exception {
        int result = 0;
        Cust cust = null;
        cust = custService.get(id);
        if(cust != null){
            result=1;
        }
        return result;
    }

    @RequestMapping("/chart05")
    public Object chart05(String year){
        JSONArray ja = new JSONArray();
        for(int i=1; i<=12; i++){
            Random r = new Random();
            int num = r.nextInt(100)+1;
            ja.add(num);
        }
        return ja;
    }

    @RequestMapping("/markers")
    public Object markers(String loc) throws Exception {
    List<Marker> list = null;
        try {
            list = markerService.getLoc(loc);
        } catch (Exception e) {
            throw new Exception("시스템 장애");
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
