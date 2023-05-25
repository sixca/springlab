package com.kbstar.enc;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class EncTests2 {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Test
    void contextLoads() {
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("mykey");   //key 값

        String phone = "01029125777";
        String addr = "서울시 성동구 성수동";

        String encPhone = pbeEnc.encrypt(phone);
        log.info("-----------------------Enc String:"+encPhone);
        String encAddr = pbeEnc.encrypt(addr);
        log.info("-----------------------Enc Addr:"+encAddr);
        //phone정보와 addr 정보가 암호화되어 저장된다.
        phone = pbeEnc.decrypt(encPhone);
        addr = pbeEnc.decrypt(encAddr);
        log.info("--------------------------Phone:"+phone);
        log.info("--------------------------Addr:"+addr);
        // 암호화됐던 정보가 복호화되어 출력된다.
    }

}