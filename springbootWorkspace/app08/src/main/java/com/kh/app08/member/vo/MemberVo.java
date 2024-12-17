package com.kh.app08.member.vo;

import lombok.Data;

@Data
public class MemberVo {
    private String no;
    private String id;
    private String pwd;
    private String nick;
    private String enrollDate;
    private String modifyDate;
    private String delYn;
    private String profile;
}
