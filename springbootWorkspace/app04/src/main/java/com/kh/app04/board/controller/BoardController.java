package com.kh.app04.board.controller;

import com.kh.app04.board.service.BoardService;
import com.kh.app04.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpRequest;

@Controller
public class BoardController {

    //게시글 작성
    @GetMapping("board/insert")
    public String insert(){
        return "board/insert";
    }

    @Autowired
    private BoardService service;
    @PostMapping("board/insert")
    public void insert(BoardVo vo){
        System.out.println(vo.getTitle());

        //data -> obj

        //service

        //dao Sql

        //result
        int result  =service.insert(vo);
        if(result == 1){
            System.out.println("게시글 작성 성공!");
        }else{
            System.out.println("게시글 작성실패 !");
        }
    }
}
