package com.kbstar.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Data
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
