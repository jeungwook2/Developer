package com.kh.app09.home.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("home")
@Slf4j
@RequiredArgsConstructor
//에너테이션만 달아주면 자동으로 log가 생성된다
public class HomeController {

    private final HomeService hs;


    // private Logger log = LoggerFactory.getLogger(현재클래스명.class);
    @GetMapping
    public String home(){
//        long time = System.currentTimeMillis();
//        System.out.println("["+time+"]" +"HomeController.home called~~~~~");
        log.trace("홈페이지 보기 요청 발생 비상비상비상 트레이스"); // 레벨 1
        log.debug("홈페이지 보기 요청 발생 비상비상비상 디버그");
        log.info("홈페이지 보기 요청 발생 비상비상비상 인포 ");
        log.warn("홈페이지 보기 요청 발생 비상비상비상 워닝 ");
        log.error("홈페이지 보기 요청 발생 비상비상비상 에러 "); // 레벨 5

        hs.home();
        return "home";
    }
}
