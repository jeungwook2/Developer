package com.kh.app07.board.controller;

import com.kh.app07.board.service.BoardService;
import com.kh.app07.board.vo.BoardVo;
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

    @GetMapping("list")
    public String list(Model model){
        List<BoardVo> list = service.selectAll();

        model.addAttribute("list", list);
        return "board/list";

    }
    @PostMapping("write")
    public String write(BoardVo vo){
        int result = service.write(vo);

        if(result == 1) {
            return "redirect:/board/list";
        }else{
            return "redirect:/error";
        }
    }
}
