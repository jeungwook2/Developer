package com.kh.app06.member.controller;

import com.kh.app06.member.service.MemberService;
import com.kh.app06.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {

    private final MemberService service;


    @PostMapping("join")
    public String write(MemberVo vo){
    int result = service.join(vo);

    if(result  ==1){
        System.out.println("회원가입 성공");
        return "redirect:/home";
    }else{
        System.out.println("회원가입 실패");
        return "redirect:/error";
    }
    }

    @PostMapping("login")
    public String  login(MemberVo vo , HttpSession session){

        MemberVo loginMemberVo = service.login(vo);
        session.setAttribute("loginMemberVo",loginMemberVo);
        System.out.println("loginMemberVo = " + loginMemberVo);
        return "redirect:/home";
    }

}
