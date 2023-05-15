package com.kbstar.ncp;

import com.kbstar.util.OCR2Util;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class OCR2Tests {

    @Value("${uploadimgdir}")
    String imgpath;

    @Test
    void contextLoads() {
        JSONObject jo = new JSONObject();
        jo = (JSONObject)OCR2Util.getResult(imgpath, "passport1.jpg");
        log.info(jo.toJSONString());

        Map map = OCR2Util.getData(jo);
        log.info(map.keySet().toString() + " " + map.values().toString());
        // OCR2Util에서 map 안에 담은 key값과 value값을 차례로 로그에 찍어 보기.
    }
    //OCR 조회, 월 3백회 초과하니 출력 안됨.. 팀 도메인 만들어서 key&url값 (ORC2Util.java)수정함.. 실습 후 삭제함;
}
