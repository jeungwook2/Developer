package com.kh.app05.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // @RequestMapping(value = "home", method = RequestMethod.GET)
    // get post 둘다 사용이 가능함 value = url주소 method는 타입이 RequestMethod타입으로 반환해줘야함

    @GetMapping("home")
    public String home(){
        return "home";
    }
}
