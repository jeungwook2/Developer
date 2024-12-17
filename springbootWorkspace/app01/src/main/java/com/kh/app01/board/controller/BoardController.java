package com.kh.app01.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("board/write")
    public Object m01(HttpServletRequest req, HttpServletResponse resp){
        return "board/write";
    }
    @GetMapping("board/list")
    public Object m01(){
        return "board/list";
    }
}
