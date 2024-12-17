package com.kh.semi.member.controller;

import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.member.service.MemberService;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.util.FileUploader;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {


    @Value("#{pathInfo.getProfilePath()}")
    private String profilePath ;

    private final MemberService service;


    @GetMapping("join")
    public String join(){
        return "member/join";
    }
    @PostMapping("join")
    public String join(MemberVo vo, MultipartFile f, HttpSession session) throws Exception {

//        String path =  staticPath+"img\\profile\\";
        String changeName = FileUploader.save(f,profilePath);
        int result = service.join(vo);


        vo.setProfile(changeName);

//        MemberVo newVo = service.listAll();
        if(result != 1) {
            String errCode = "[MEMBER-J-001]회원가입중 에러발생";
            log.warn(errCode);
            throw new Exception(errCode);
        }



        session.setAttribute("alertMsg","회원가입 완료!!");

        return "redirect:/member/login";
    }

//    @GetMapping("join/photo")
//    public String m01(){
//
//        int result = service.write(bno);
//
//        if(result != 1){
//            System.out.println("실패");
//        }
//        return "redirect:/member/home";
//    }
    @GetMapping("login")
    public String login(){
        return "member/login";
    }
    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session) throws Exception {
        MemberVo loginMemberVo = service.login(vo);


        if(loginMemberVo == null){
            String errCode = "[MEMBER-L-001]로그인중 에러발생";
            log.warn(errCode);
            throw new Exception(errCode);
        }
        session.setAttribute("loginMemberVo",loginMemberVo);
        return "redirect:/home";
    }
    @GetMapping("mypage")
    public String mypage(HttpSession session){
        if(session.getAttribute("loginMemberVo") == null){
        return "member/login";
        }else{
            return "member/mypage";
        }

    }

    @PostMapping("edit")
    public String edit(MemberVo vo,HttpSession session) throws Exception {
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        vo.setNo(loginVo.getNo());

        MemberVo updatedMemberVo= service.edit(vo);

        session.setAttribute("loginMemberVo",updatedMemberVo);
        if(updatedMemberVo == null){
            throw new Exception();
        }
        return "redirect:/member/mypage";
    }

    @GetMapping("quit")
    public String quit(){
        return "member/quit";
    }
    @PostMapping("quit")
    public String quit(MemberVo vo ,HttpSession session) throws Exception {
        MemberVo loginvo = (MemberVo)session.getAttribute("loginMemberVo");
        vo.setNo(loginvo.getNo());

        int result = service.quit(vo);
        if(result != 1){
            String errCode="[MEMBER-Q-001] 회원탈퇴 중 에러 발생 .." ;
            log.warn(errCode);
            throw new Exception(errCode);
        }
        session.removeAttribute("loginMemberVo");
        return "redirect:/home";
    }
    @PostMapping("id-dup")
    @ResponseBody
    public String checkDupId(String id) throws JsonProcessingException {

        HashMap<String, String> map = new HashMap<>();
        boolean isdup = service.checkDupId(id);
        map.put("data",id);

        if(isdup){
            map.put("status","bad");
        }else{
            map.put("status","good");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(map);
        return str;
    }


    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginMemberVo");
        String x = "로그아웃 되었습니다";
        session.setAttribute("alertMsg",x);
        return "redirect:/home";
    }
}
//COALESCE
