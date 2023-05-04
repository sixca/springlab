package com.kbstar;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
class Web12ApplicationTests {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
		String rawPassword = "pwd01";  //입력
		String encPassword = encoder.encode(rawPassword);    //rawPassword를 암호화
		log.info(rawPassword);
		log.info("암호화 된 비번" + encPassword);
		boolean result = encoder.matches("111",encPassword);   //maches함수를 통해 비교. 결과는 T or F
		boolean result2 = encoder.matches(rawPassword,encPassword);   //maches함수를 통해 비교. 결과는 T or F
		log.info(result+"");
		log.info(result2 + "");
		log.info("------------------------------------------------------");
	}
}
