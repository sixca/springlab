package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Marker {
    private int id;
    private String title;
    private String target;
    private double lat;
    private double lng;   //float 도 가능요
    private String img;
    private String loc;
}
//loc 추가하여 해당 loc 주변에 맛집 데이터를 가져오기 위해 Marker DTO 생성함
