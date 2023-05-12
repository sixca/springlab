package com.kbstar.dto;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Sales {
    private String rdate; // 2023-01-02
    private int price;
    private String gender;
}
