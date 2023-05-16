package com.kbstar.controller;

import com.kbstar.dto.Ncp;
import com.kbstar.util.*;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller

public class NcpController {

    @Value("${uploadimgdir}")
    String imgpath;

    @RequestMapping("/cfr1impl")
    public String cfr1impl(Model model, Ncp ncp) throws ParseException {
       // img를 서버에 저장한다
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다  :: test했던 것 복붙
        String imgname = ncp.getImg().getOriginalFilename(); //이미지명 추출
        JSONObject result =
                (JSONObject) CFRCelebrityUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        // 결과를 받는다. JSONObject인 result 안에 faces array 안에, 첫번째 배열 안에, celebrity라는 Object 안에 String인 value를 추출!
        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);
        JSONObject celebrity = (JSONObject)obj.get("celebrity");
        String value = (String)celebrity.get("value");

        model.addAttribute("result",value);
        model.addAttribute("center","cfr1");
        return "index";
    }

    @RequestMapping("/cfr2impl")
    public String cfr1imp2(Model model, Ncp ncp) throws ParseException {
        // img를 서버에 저장한다
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다  :: test했던 것 복붙
        String imgname = ncp.getImg().getOriginalFilename(); //이미지명 추출
        JSONObject result =
                (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());

        // 결과를 받는다. emotion, gender, pose, age :: 결과 4개를 어떻게 모델에 담을까?
        String emotion_value = "";
        String gender_value = "";
        String pose_value = "";
        String age_value = "";

        //JSONParser jsonParser = new JSONParser(); 왜 JSON Parser 선언없이도 잘 돌아갈까?
        JSONArray faces = (JSONArray)result.get("faces");
        JSONObject obj = (JSONObject)faces.get(0);

        JSONObject gender = (JSONObject) obj.get("gender");
        gender_value = (String)gender.get("value");

        JSONObject emotion = (JSONObject)obj.get("emotion");
        emotion_value = (String)emotion.get("value");

        JSONObject pose = (JSONObject) obj.get("pose");
        pose_value = (String)pose.get("value");

        JSONObject age = (JSONObject)obj.get("age");
        age_value = (String)age.get("value");

//        model.addAttribute("emotion", emotion_value);
//        model.addAttribute("gender", gender_value);
//        model.addAttribute("pose", pose_value);
//        model.addAttribute("age", age_value);
//        model.addAttribute("result","cfr2")
// 이렇게 각자 넣어도 되지만

        //map을 활용해서 한 번에 넣어준다
        Map<String, String> map = new HashMap<>();
        map.put("emotion",emotion_value);
        map.put("pose",pose_value);
        map.put("age",age_value);
        map.put("gender",gender_value);

        model.addAttribute("result",map);
        model.addAttribute("center","cfr2");
        return "index";
    }

//mycfr
@RequestMapping("/mycfr")
public String mycfr(Model model, String imgname) throws ParseException {
    //String imgname이 들어오면 pic.jsp에 <input name="imgname"> 태그에 박힘:: <form action="/mycfr"> 로 역여 있으니..

        // NCP에 요청한다  :: test했던 것 복붙
    JSONObject result =
            (JSONObject) CFRFaceUtil.getResult(imgpath, imgname);
    log.info(result.toJSONString());

    // 결과를 받는다. emotion, gender, pose, age :: 결과 4개를 어떻게 모델에 담을까?
    String emotion_value = "";
    String gender_value = "";
    String pose_value = "";
    String age_value = "";

    JSONArray faces = (JSONArray)result.get("faces");
    JSONObject obj = (JSONObject)faces.get(0);

    JSONObject gender = (JSONObject) obj.get("gender");
    gender_value = (String)gender.get("value");

    JSONObject emotion = (JSONObject)obj.get("emotion");
    emotion_value = (String)emotion.get("value");

    JSONObject pose = (JSONObject) obj.get("pose");
    pose_value = (String)pose.get("value");

    JSONObject age = (JSONObject)obj.get("age");
    age_value = (String)age.get("value");

//        model.addAttribute("emotion", emotion_value);
//        model.addAttribute("gender", gender_value);
//        model.addAttribute("pose", pose_value);
//        model.addAttribute("age", age_value);
//        model.addAttribute("result","cfr2")
// 이렇게 각자 넣어도 되지만

    //map을 활용해서 한 번에 넣어준다
    Map<String, String> map = new HashMap<>();
    map.put("emotion",emotion_value);
    map.put("pose",pose_value);
    map.put("age",age_value);
    map.put("gender",gender_value);

    model.addAttribute("result",map);
    model.addAttribute("center","pic");
    return "index";
}

    @RequestMapping("/ocr1impl")
    public String ocr1impl(Model model, Ncp ncp) throws ParseException {
        // img를 서버에 저장한다
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다  :: test했던 것 복붙
        String imgname = ncp.getImg().getOriginalFilename(); //이미지명 추출
        JSONObject result =
                (JSONObject)OCRUtil.getResult(imgpath, imgname);
        Map map = OCRUtil.getData(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr1");
        return "index";
    }


    @RequestMapping("/ocr2impl")
    public String ocr2impl(Model model, Ncp ncp) throws ParseException {
        // img를 서버에 저장한다
        FileUploadUtil.saveFile(ncp.getImg(), imgpath);

        // NCP에 요청한다  :: test했던 것 복붙
        String imgname = ncp.getImg().getOriginalFilename(); //이미지명 추출
        JSONObject result =
                (JSONObject) OCR2Util.getResult(imgpath, imgname);
        Map map = OCR2Util.getData(result);

        model.addAttribute("result",map);
        model.addAttribute("center","ocr2");
        return "index";
    }


}
