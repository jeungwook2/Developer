package com.kh.semi.admin.controller;

import com.kh.semi.admin.service.AdminService;
import com.kh.semi.admin.vo.AdminVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("admin")
public class AdminController {

    private final AdminService service;
    // 관리자 로그인 화면
    @GetMapping("login")
    public String login(){
        return "admin/login";
    }

    @PostMapping("login")
    public String login(AdminVo vo, HttpSession session){

    AdminVo loginAdminVo = service.login(vo);
    session.setAttribute("loginAdminVo",loginAdminVo);
    session.setAttribute("alertMsg","관리자 로그인 성공!");

    if(loginAdminVo == null){
        throw new IllegalStateException("관리자 로그인중 예외발생...");
    }
        return "redirect:/home";
    }
}
