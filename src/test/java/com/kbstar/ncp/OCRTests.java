package com.kbstar.ncp;

import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@Slf4j
@SpringBootTest
class OCRTests {

    @Value("${uploadimgdir}")
    String imgpath;

    @Test
    void contextLoads() {
        JSONObject jo = new JSONObject();
        jo = (JSONObject)OCRUtil.getResult(imgpath, "biz1.jpg");
        log.info(jo.toJSONString());
    }
}
