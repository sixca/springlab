package com.kbstar.ncp;

import com.kbstar.util.CFRCelebrityUtil;
import com.kbstar.util.CFRFaceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class CFRFaceTests {

    @Value("${uploadimgdir}")
    String imgpath;

    @Test
    void contextLoads() throws ParseException {
        String imgname = "ma.jpg";
        JSONObject result =
        (JSONObject)CFRFaceUtil.getResult(imgpath, imgname);
        log.info(result.toJSONString());
    }
}
