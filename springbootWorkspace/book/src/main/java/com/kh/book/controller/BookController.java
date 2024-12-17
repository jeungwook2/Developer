package com.kh.book.controller;

import com.kh.book.service.BookService;
import com.kh.book.vo.BookVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("book")
@CrossOrigin//  (value="192.168.40.111:5500")
public class BookController {
    public final BookService service;

    @GetMapping("write")
    public  String write(){
        return "write";
    }
    //등록하기
    @PostMapping("write")
    @ResponseBody
    public int write(@RequestBody BookVo vo){

        System.out.println(vo);
        int result = service.insert(vo);


        if(result != 1){
            throw new IllegalStateException("작성하기 오류~");
        }
        return result;



    }

    //목록가져오기
    @GetMapping("list")
    @ResponseBody
    public List<BookVo> getAllList(Model model){
        List<BookVo> voList = service.getAllList();
        model.addAttribute("voList",voList);
        return voList;
    }



    //상세조회
    @GetMapping("listone")
    @ResponseBody
    public BookVo onelist(String no, Model model){
        System.out.println(no);
        BookVo vo = service.oneList(no);
        model.addAttribute("vo",vo);
        return vo;
    }

    @GetMapping("edit")
    public String edit(){
        return "edit";
    }
    //삭제하기
    @PostMapping("edit")
    @ResponseBody
    public int edit(String no){
        int result = service.edit(no);
        return  result;
    }

}