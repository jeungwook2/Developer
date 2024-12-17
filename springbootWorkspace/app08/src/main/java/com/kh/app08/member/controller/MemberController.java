package com.kh.app08.member.controller;

import com.kh.app08.member.service.MemberService;
import com.kh.app08.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

        private final MemberService service;


    @GetMapping("join")
    public String join(){
        return "member/join";
    }
    @PostMapping("join")
    public String join(MemberVo vo,  MultipartFile f) throws IOException {

        String randomstr = UUID.randomUUID().toString();
        String ext = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf("."));

        String changeName = randomstr+ext;

       File target = new File("D:\\dev\\springbootWorkspace\\app08\\src\\main\\resources\\static\\img\\profile\\"+changeName);
        f.transferTo(target);


       vo.setProfile("img\\profile\\"+changeName);
      int result = service.join(vo);

      if(result == 1){
          return "redirect:/home";
      }else{
          return "redirect:/error";
      }



    }
    @GetMapping("login")
    public String login(){
        return "member/login";
    }
    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginVo = service.login(vo);


        if(loginVo != null){
            session.setAttribute("loginVo",loginVo);
            return "redirect:/home";
        }else{
            return "redirect:/error";
        }
    }
}
