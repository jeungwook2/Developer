package com.kh.myapp.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//bean 으로 만들어주기 위해서
//컨트롤러가 실행이 될때 이 에너테이션을 보고 HomeController를 Bean으로 생성
public class HomeController {
    @GetMapping("hello")
    public void m01(){
        System.out.println("메서드 호출됨~~~");
    }
}
