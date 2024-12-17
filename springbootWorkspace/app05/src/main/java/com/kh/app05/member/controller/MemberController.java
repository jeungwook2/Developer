package com.kh.app05.member.controller;

import com.kh.app05.member.service.MemberService;
import com.kh.app05.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("member")
//클래스 레벨에 달아주면 자동으로 url Mapping값 해줌
@RequiredArgsConstructor
//lombok 에너테이션으로 ms를 지칭하는 객체생성 라인에 생성자 인젝션으로 만들어 준다.
public class MemberController {


    private final MemberService ms;


//    객체가 만들어질때 채우냐  필드 인젝션
//    생성자 호출할때부터 채워주는거 생성자 인젝션

    @GetMapping("join")
    public String join(){
        return "member/join";
    }
    

        @PostMapping("join")
        public String join(MemberVo vo){
            System.out.println(vo);
            int result = ms.join(vo);
            
            if(result == 1){
                System.out.println("회원가입 성공");
                return "redirect:/home";
            }else{
                System.out.println("회원가입 실패");
                return "redirect:/error";
            }

        }

    @GetMapping("login")
    public String login(){

        return "member/login";
    }

    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = ms.login(vo);

        session.setAttribute("loginMemberVo" ,loginMemberVo);

        return "redirect:/home";
    }
//    public String login(MemberVo vo,Model modle){
//    List<MemberVo> list = ms.login();
//
//
//    for(MemberVo vo1 : list){
//        System.out.println(vo1);
//
//    if(vo.getId().equals(vo1.getId())&&vo.getPwd().equals(vo1.getPwd())){
//        System.out.println("로그인 성공");
//        break;
//    }else{
//        System.out.println("로그인 실패");
//        return "redirect:/error";
//    }
//    }
//    return "redirect:/home";
//    }
}
