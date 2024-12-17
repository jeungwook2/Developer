package com.kh.app04.home.controller;

import com.kh.app04.home.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//컨트롤러 서비스 레파지토리 는 기능이 다 다르다.
public class HomeController {

    @Autowired
    private HomeService service;

    @GetMapping("home")
    public String home(){
        System.out.println("home 컨트롤러 호출됨~~~");
        service.home();


    return "home";
    }
}
