package com.kbstar.dto;

import lombok.*;

// 롬복 실습
// 생성자, 겟터/세터, 투스트링 선언 생략.
// ANNOTATION방식으로 CustDTO를 활용하도록 해줌.
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Cust {
    private String id;
    private String pwd;
    private String name;
}
