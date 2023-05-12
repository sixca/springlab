package com.kbstar.ncp;

import com.kbstar.util.OCR2Util;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

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
    }
    //OCR 조회, 월 3백회 초과하니 출력 안됨.. 팀 도메인 만들어서 key&url값 (ORC2Util.java)수정함.
}
