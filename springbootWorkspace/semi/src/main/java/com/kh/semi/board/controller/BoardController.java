package com.kh.semi.board.controller;

import com.kh.semi.board.service.BoardService;
import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CateVo;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.util.FileUploader;
import com.kh.semi.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    @Value("#{pathInfo.getBoardAttachmentPath()}")
    private String writerPath;

    private final BoardService service;

    @GetMapping("cate")
    @ResponseBody
    public List<CateVo> cate(){
        return service.getCategory();
    }


    @GetMapping("write")
    public String write(HttpSession session, Model model){
        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo ==null){
            return "redirect:/member/login";
        }
        List<CateVo> cateVo = service.getCategory();
        model.addAttribute("cateVo",cateVo);
        return "board/write";
    }


    //게시글 작성
    @PostMapping("write")
    public String write(BoardVo vo
            , HttpSession session
            , @RequestParam(name = "f") List<MultipartFile> fileList) throws IOException {

           List<String> changeName = new ArrayList<>();
        for (MultipartFile f : fileList) {
            if(f.isEmpty()){break;}
            changeName.add(FileUploader.save(f,writerPath));
        }

        MemberVo loginVo = (MemberVo)session.getAttribute("loginMemberVo");
        if(loginVo ==null){
            return "redirect:/home";
        }
        vo.setWriterNo(loginVo.getNo());
        int result = service.write(vo,changeName);

        if(result>0){
            return "redirect:/board/list";
        }else{
            return "redirect:/error";
        }


    }

    //게시글 목록조회(화면)
    @GetMapping("list")
    public String list(Model model){
        List<CateVo> cateVoList = service.getCategory();
        model.addAttribute("cateVolist" , cateVoList);
        return "board/list";
    }




    //게시글 목록조회(데이터)
    @GetMapping("list/data")
    @ResponseBody
    public HashMap m01(@RequestParam(name="pno",defaultValue="1" , required = false) int currentPage,String searchType,String searchValue){
        System.out.println(currentPage);
        int listCount = service.getBoardCnt(searchType,searchValue);
        int pageLimit = 5;
        int boardLimit = 10;
        PageVo pvo = new PageVo(listCount, currentPage, pageLimit, boardLimit);

        List<BoardVo> boardVoList=service.list(pvo,searchType,searchValue);




        HashMap map =new HashMap();
        map.put("a",boardVoList);
        map.put("b",pvo);
        return map;
    }
    //게시글 상세조회
    @GetMapping("detail")
    public String detail(String bno,Model model) throws Exception {

        BoardVo vo = service.getBoard(bno);

        model.addAttribute("vo",vo);
        List<AttachmentVo> attachmentVoList = service.getAttachmentVoList(bno);
        model.addAttribute("attachmentVoList",attachmentVoList);
        if(vo == null){
            throw new Exception("실패실패 가져오기 실패 ~");
        }

        return "board/detail";
    }
    @GetMapping("delete")
    public String del(String bno,HttpSession session){
        int result = service.del(bno);

        if(result != 1){
            throw new IllegalStateException("게시글 삭제 실패....");
        }
        session.setAttribute("alertMsg","게시글 삭제 성공!");
        return "redirect:/board/list" ;

    }

    //게시글 수정 화면
    @GetMapping("edit")
    public String edit(Model model,String bno){
        BoardVo vo = service.getBoard(bno);
        List<CateVo> cateVoList = service.getCategory();
        List<AttachmentVo> attachmentVoList = service.getAttachmentVoList(bno);
        model.addAttribute("cateVoList",cateVoList);
        model.addAttribute("vo",vo);
        model.addAttribute("attachmentVoList",attachmentVoList);
        return "board/edit";
    }
    @PostMapping("edit")
    public String edit(BoardVo vo,HttpSession session,@RequestParam(name = "f") List<MultipartFile> fileList) throws IOException {

        //파일을 선택하면 등록이 되야하는데 그거에 대한 로직

        List<String> changeNameList = new ArrayList<>();
        for (MultipartFile f : fileList) {
            if(f.isEmpty()){break;}
//            f가 비어있다면 브레이크
            String changeName=FileUploader.save(f,writerPath);
            changeNameList.add(changeName);
        }

        int result = service.update(vo,changeNameList);

        if(result != 1){
            throw new IllegalStateException("[ERROR BOARD 수정 중 에러발생~~~~~]");
        }
        session.setAttribute("alertMsg","게시글 수정 성공!");
        return "redirect:/board/list";
    }

    @PostMapping("attachment/del")
    @ResponseBody
    public int del(String ano,String fileName) throws IOException {
//        data :부분으로 넘겨준 부분을 파라미터 값으로 받는다



        int result = service.delAttachment(ano);
//       DB가서 칼럼을 삭제하는것 까지는 완료
        System.out.println("삭제되는 파일정보");
        System.out.println(ano);
        System.out.println(fileName);
//        D: 가서 저장된것도 삭제해야하니까
        File x =new File("D:\\dev\\springbootWorkspace\\semi\\src\\main\\resources\\static\\"+fileName);
        
//        파일의 경로로 객체를 생성해서
        x.delete();
//        객체.delete();만하면 삭제된다.



        return result;
    }



}
