package com.kbstar.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Ncp {
    private MultipartFile img;
    //form과 form data인 cfr1.jsp, cfr2.jsp의 input태그 name="img"와 동일하게 맞춰줘야 함.
}
