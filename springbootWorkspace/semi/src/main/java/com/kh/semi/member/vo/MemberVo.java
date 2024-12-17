package com.kh.semi.member.vo;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String id;
    private String pwd;
    private String nick;
    private String profile;
    private String delYn;
    private String enrollDate;
    private String modifyDate;
}
