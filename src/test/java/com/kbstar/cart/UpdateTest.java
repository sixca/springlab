package com.kbstar.cart;

import com.kbstar.dto.Cart;
import com.kbstar.dto.Cust;
import com.kbstar.service.CartService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UpdateTest {
    @Autowired
    CartService service;
    @Test
    void contextLoads() {
        try {
            service.modify(new Cart(100,"id01",100,5));
        } catch (Exception e) {
            log.info("오류");
        }

    }

}
