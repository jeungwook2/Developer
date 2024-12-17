package com.kh.app08.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("board")
public class BoardController {

    @GetMapping("write")
    public String write(){
        return "board/write";
    }
    @PostMapping("write")
    public String write(String title, String content, MultipartFile f) throws IOException {
        System.out.println("title = " + title);
        System.out.println("content = " + content);
        System.out.println("f = " + f);

        String changeName = UUID.randomUUID().toString();
//                             랜덤값을 뽑아낸다
        String originalFilename = f.getOriginalFilename();
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//        확장자 준비  원본 파일 이름을 가져와서         5번index ~ 10번index 미만
       File target= new File("D:\\dev\\springbootWorkspace\\app08\\src\\main\\resources\\static\\"+changeName+ext);

        f.transferTo(target);

        return "redirect:/board/list";
    }
}
