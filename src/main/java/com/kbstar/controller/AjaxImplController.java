package com.kbstar.controller;

import com.kbstar.dto.Cal;
import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import com.kbstar.service.MarkerService;
import com.kbstar.util.DateUtil;
import com.kbstar.util.FileUploadUtil;
import com.kbstar.util.WeatherUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {
    @Autowired
    MarkerService markerService;
    @Autowired
    CustService custService;
    @Autowired
    CartService cartService;


    @Value("${uploadimgdir}")
    String imgdir;


    //pic 메뉴에서 찍힌 사진을 저장하는 기능
    @RequestMapping("/saveimg")
    public String saveimg(MultipartFile file){
        String filename = file.getOriginalFilename();
        FileUploadUtil.saveFile(file, imgdir);
        return filename;
    }

    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        List<Cust> list= new ArrayList<>();
        list.add(new Cust("id01","pwd01","james1"));
        list.add(new Cust("id02","pwd02","james2"));
        list.add(new Cust("id03","pwd03","james3"));
        list.add(new Cust("id04","pwd04","james4"));
        list.add(new Cust("id05","pwd05","james5"));

        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cust obj:list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id",obj.getId());
            jo.put("pwd",obj.getPwd());
            jo.put("name",obj.getName()+i);
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
            result = 1;
        }
        return result;
    }
    @RequestMapping("/addcart")
    public Object addcart(Cart cart) throws Exception {
        cartService.register(cart);
        return "";
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

    @RequestMapping("/weather2")
    public Object weather2() throws Exception {
        // 요청하면 기상청에가서 데이터를 가져온다. :: Object로 담아둔 jo를 return함.
        return WeatherUtil.getWeather2("109");
    }


    @RequestMapping("/weather3")
    public Object weather3() throws Exception {
        // 요청하면 기상청에가서 데이터를 가져온다
        return WeatherUtil.getWeather3("108");
    }

    @RequestMapping("/getcal")
    public Object getcal(){
        List<Cal> list= new ArrayList<>();
        list.add(new Cal("title1","2023-05-01T15:00","","1","/cust"));
        list.add(new Cal("aa","2023-05-03T15:00","","2","/cust"));
        list.add(new Cal("ss","2023-05-06T15:00","","3","/cust"));
        list.add(new Cal("ss","2023-05-06T17:00","","3","/cust"));
        list.add(new Cal("ss","2023-05-06T17:00","","2","/cust"));
        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cal obj:list){
            JSONObject jo = new JSONObject();

            jo.put("title",obj.getTitle());
            jo.put("start",obj.getStart());
            jo.put("end",obj.getEnd());
            if(obj.getDiv().equals("1")){
                jo.put("color","green");
            }else if(obj.getDiv().equals("2")){
                jo.put("color","blue");
            }else{
                jo.put("color","red");
            }

            jo.put("url",obj.getUrl());

            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/getcal2")
    public Object getcal2(){
        List<Cal> list= new ArrayList<>();
        list.add(new Cal("title1","2023-05-01","2023-05-05","1","/cust"));
        list.add(new Cal("aa","2023-05-03","2023-05-06","2","/cust"));
        list.add(new Cal("ss","2023-05-06","2023-05-09","3","/cust"));
        list.add(new Cal("ss","2023-05-10","2023-05-12","3","/cust"));
        list.add(new Cal("ss","2023-05-16","2023-05-19","2","/cust"));
        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cal obj:list){
            JSONObject jo = new JSONObject();

            jo.put("title",obj.getTitle());
            jo.put("start",obj.getStart());
            jo.put("end", DateUtil.getDateStr(obj.getEnd()));

            if(obj.getDiv().equals("1")){
                jo.put("color","green");
            }else if(obj.getDiv().equals("2")){
                jo.put("color","blue");
            }else{
                jo.put("color","red");
            }

            jo.put("url",obj.getUrl());

            ja.add(jo);
        }
        return ja;
    }

    @RequestMapping("/gettime")
    public Object gettime(String tdate){
        JSONArray ja = new JSONArray();
        if(tdate.equals("2023-06-07")){
            ja.add("09:00");
            ja.add("11:00");
            ja.add("01:00");
            ja.add("03:00");
        }else{
            ja.add("11:00");
            ja.add("09:00");
            ja.add("01:00");
        }
        return ja;
    }

    @RequestMapping("/getcal3")
    public Object getcal3(String start, String end){

        List<Cal> list= new ArrayList<>();
        list.add(new Cal("title1","2023-05-01","2023-05-05","1","/cust"));
        list.add(new Cal("aa","2023-05-03","2023-05-06","2","/cust"));
        list.add(new Cal("ss","2023-05-06","2023-05-09","3","/cust"));
        list.add(new Cal("ss","2023-05-10","2023-05-12","3","/cust"));
        list.add(new Cal("ss","2023-05-16","2023-05-19","2","/cust"));
        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cal obj:list){
            JSONObject jo = new JSONObject();

            jo.put("title",obj.getTitle());
            jo.put("start",obj.getStart());

            /*
                calendar 에서는 5.1 ~ 5.3 선택하면 5.3 0시가 Default임
                util : 5.1~5.3 선택하면 마지막 3일에 대한 전체를 인식시키기 위한 Util임
             */
            jo.put("end", DateUtil.getDateStr(obj.getEnd()));

            if(obj.getDiv().equals("1")){
                jo.put("color","green");
            }else if(obj.getDiv().equals("2")){
                jo.put("color","blue");
            }else{
                jo.put("color","red");
            }

            jo.put("url",obj.getUrl());

            ja.add(jo);
        }
        return ja;
    }

}
