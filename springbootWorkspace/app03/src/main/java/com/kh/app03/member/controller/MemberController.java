package com.kh.app03.member.controller;

import com.kh.app03.member.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//bin으로 만들어주는건 component 이며 이건 Controller 안에 속해있다.
public class MemberController {

    @Autowired
    //와이어링 자동으로 해준다. 객체가 필요로 하는거 연결해준다.
    // 자동으로 DI를 채워줘
    private MemberMapper mapper;
    //여기다가


    //스프링 핵심메뉴 DI , Ioc 두가지중 DI에 해당되는 내용
    //의존성 주입(DI) :Dependency injection
    //controller  -> service - > dao  순환 과정을 Autowired 가 다처리해준다

    @GetMapping("member/join")
    @ResponseBody
    public String join(){
        System.out.println("MemberController.join");

        mapper.m01();
        return "join ok ~~~";
    }

}
