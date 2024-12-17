package com.kh.semi.notice.controller;

import com.kh.semi.admin.vo.AdminVo;
import com.kh.semi.member.vo.MemberVo;
import com.kh.semi.notice.service.NoticeService;
import com.kh.semi.notice.vo.NoticeReplyVo;
import com.kh.semi.notice.vo.NoticeVo;
import com.kh.semi.util.page.PageVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("notice")
@Slf4j
public class NoticeController {

    private final NoticeService service;
    
    //공지사항 작성하기 (화면)
    @GetMapping("write")
    public String write(HttpSession session){
        AdminVo vo = (AdminVo) session.getAttribute("loginAdminVo");
        if(vo == null){
            session.setAttribute("alertMsg","로그인후 이용하세요");
            return "redirect:/admin/login";
        }


        return "notice/write";
    }
    
    
    //공지사항 작성하기 (처리)
    @PostMapping("write")
    public String write(NoticeVo vo,HttpSession session){

       AdminVo loginVo = (AdminVo)session.getAttribute("loginAdminVo");
        vo.setWriterNo(loginVo.getNo());
       int result = service.write(vo);

        if(result != 1){
              throw new IllegalStateException("[ERROR] NOTICE 공지사항 작성중 오류발생");
        }
        return "redirect:/notice/list";
    }
    
    
    //공지사항 목록조회 (검색추가)
    @GetMapping("list")
    public String list(Model model,@RequestParam(name="pno",required = false,defaultValue = "1") int currentPage,
                       String searchValue){
//                                                pno 인 것을 받아와서 currentPage로 받고 값이 무조건 안들어와도 되고 디폴트값은 1로준다
        int listCount = service.getNoticeCnt();
        int pageLimit = 5;
//        5개의 페이지씩
        int boardLimit = 10;
//        10 줄씩 보여줘라

        PageVo pvo = new PageVo(listCount,currentPage,pageLimit,boardLimit);


        List<NoticeVo> voList = service.getNoticeList(pvo,searchValue);
//        for (NoticeVo vo : voList) {
//            System.out.println("vo = " + vo);
//        }

        model.addAttribute("voList",voList);
        model.addAttribute("pvo",pvo);
        model.addAttribute("searchValue",searchValue);
        return "notice/list";
    }
    



    //공지사항 상세조회
    @GetMapping("detail")
    public String detail(String no,Model model){
        NoticeVo vo = service.getNoticeByNo(no);

        model.addAttribute("vo",vo);
        return "notice/detail";
    }
    //공지사항 수정하기(화면)
    
    
    //공지사항 수정하기(처리)
    
    //공지사항 삭제하기(delete)
    @DeleteMapping("del")
    @ResponseBody
    public int delete(@RequestBody String[] dataArr,HttpSession session){

        for (String data : dataArr) {
            System.out.println(data); // 배열 값 출력
        }

        int result = service.delete(dataArr);
        if(result >0){

        session.setAttribute("alertMsg","삭제성공 ~~");
        }else{
            session.setAttribute("alertMsg","삭제실패 ~~");
        }
        return result;
    }

    //공지사항 수정하기 (화면)
    @GetMapping("edit")
    public void edit(Model model,String no){
        NoticeVo vo = service.getNoticeByNo(no);
        model.addAttribute("vo",vo);
    }
    //공지사항 수정하기

    @PostMapping("edit")
    public String edit(NoticeVo vo,HttpSession session){
        AdminVo adminVo = (AdminVo) session.getAttribute("loginAdminVo");
        vo.setWriterNo(adminVo.getNo());


        int result = service.edit(vo);

        if (result != 1){
            throw new IllegalStateException("수정하기 기능에서 실패함 ~~");
        }
        return "redirect:/notice/list";

    }
    @PostMapping("reply/write")
    @ResponseBody
    public int replyWrite(NoticeReplyVo vo,HttpSession session){
        MemberVo memberVo =(MemberVo) session.getAttribute("loginMemberVo");
        vo.setWriterNo(memberVo.getNo());

        int result =service.replyWrite(vo);

        return result;

    }
    //공지사항 댓글리스트 응답하기
    @GetMapping("reply/list")
    @ResponseBody
    public List<NoticeReplyVo> getNoticeReplyList(String noticeNo){
        List<NoticeReplyVo> noticeReplyVoList =service.getNoticeReplyList(noticeNo);

        return noticeReplyVoList;
    }
}
