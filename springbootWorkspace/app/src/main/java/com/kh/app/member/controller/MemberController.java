package com.kh.app.member.controller;

import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//조작을 위해
public class MemberController {
    @GetMapping("abc")
//    받아오기
    @ResponseBody
//   return 값에 있는 문자열을 그대로 화면에 보여준다.
    public  String  m01(MemberVo vo){
        //url 에 넘어오는것을 인자값으로 받는다
        //데이터 꺼내오고 뭉치는 작업을 인자값으로 한번에 처리가능
        System.out.println("m01 called~~~~");
        System.out.println("vo = " + vo);
        return "hello";

    }
//    메서드마다 개인 웹 에너테이션 지정 가능하다.
}
