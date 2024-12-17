package com.kh.app04practice.board.controller;

import com.kh.app04practice.board.service.BoardService;
import com.kh.app04practice.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BoardController {
    @GetMapping("board/insert")
    public String insert(){

        return "board/insert";
    }


    @Autowired
    private BoardService service;
    @PostMapping("board/insert")
    public void insert(BoardVo vo){
        int result = service.insert(vo);
        
        if(result == 1){
            System.out.println("작성하기 성공");
        }else{
            System.out.println("작성하기 실패");
        }
    }

    @GetMapping("board/list")
    public String select(Model model){
        List<BoardVo> list = service.select();
        model.addAttribute("list",list);
        for(BoardVo vo : list){
            System.out.println(vo);
        }

        if(list != null){
            System.out.println("조회하기 성공");
        }else{
            System.out.println("조회하기 실패");
        }
        return "board/select";
    }
}
