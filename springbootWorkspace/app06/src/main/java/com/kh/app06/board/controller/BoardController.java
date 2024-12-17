package com.kh.app06.board.controller;

import com.kh.app06.board.service.BoardService;
import com.kh.app06.board.vo.BoardVo;
import com.kh.app06.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;

    @PostMapping("write")
    public String write(BoardVo vo, HttpSession session){

//        vo.setWriterNo("1");
        MemberVo loginvo =(MemberVo)session.getAttribute("loginMemberVo");
        vo.setWriterNo(loginvo.getNo());
        System.out.println(loginvo.getNo());
        int result = service.write(vo);
        if(result ==1){
            return "redirect:/board/list";
        }else{
            return "redirect:/error";
        }
    }

    @GetMapping("list")
    public void selectAll(){
        List<BoardVo> volist = service.selectAll();
        System.out.println("volist = " + volist);
    }
}
