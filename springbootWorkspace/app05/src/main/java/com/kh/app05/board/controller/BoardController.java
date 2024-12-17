package com.kh.app05.board.controller;

import com.kh.app05.board.service.BoardService;
import com.kh.app05.board.vo.BoardVo;
import com.kh.app05.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {
    private final BoardService service;
    //게시글 작성 화면
    @GetMapping("write")
    public void write(){

    }
    //게시글 작성 처리
    @PostMapping("write")
    public String write(BoardVo vo, HttpSession session){

        MemberVo x =(MemberVo)session.getAttribute("loginMemberVo");
        String mno = x.getNo();
        vo.setWriterNo(mno);
        int result = service.write(vo);
        if(result == 1){
            return "redirect:/board/list";
        }else{
            return "redirect:/error";
        }

    }
    @GetMapping("list")
    public void list(Model model){
        List<BoardVo> volist = service.selectBoardList();
        System.out.println("volist = " + volist);
        model.addAttribute("volist",volist);
    }
    //게시글 조회


}
