package com.example.sing;

import lombok.Data;

@Data
public class SingVo {
    private Long no;
    private String title;
    private String releaseDate;
    private String singer;
    private String composer;
    private String delYn;
}
