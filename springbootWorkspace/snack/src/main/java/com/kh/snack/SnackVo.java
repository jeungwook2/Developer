package com.kh.snack;

import lombok.Data;

@Data
public class SnackVo {
    private Long no;
    private String name;
    private Integer price;
    private String brand;
    private String expirationDate;
}
