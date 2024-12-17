package com.kh.semitest.vacation.controller;

import com.kh.semitest.vacation.service.VacationService;
import com.kh.semitest.vacation.vo.EmployeeVo;
import com.kh.semitest.vacation.vo.VacationVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/hr/vacation")
public class VacationController {
    private final VacationService service;

    //게시글 작성 화면 연결
    @GetMapping("write")
    public String write(Model model) {
        List<EmployeeVo> empVoList = service.empVoList();

        for (EmployeeVo vo : empVoList) {
            System.out.println("vo = " + vo);
        }

        model.addAttribute("empVoList", empVoList);


        return "vacation/write";
    }

    @PostMapping("write")
    public String write(VacationVo vo) {

        int result = service.insert(vo);

        return "redirect:/api/hr/vacation/list";
    }


    //////사원 선택 버튼클릭후  모달창에 있는 정보를 받아오는 ajax
    @PostMapping("getEmployeeData")
    @ResponseBody
    public EmployeeVo getEmployeeData(@RequestParam("empNo") String empNo) {

        System.out.println(empNo);
        EmployeeVo selectvolist = service.selectvolist(empNo);
        return selectvolist;
    }


    @GetMapping("list")
    public String list(Model model) {
        List<VacationVo> listVo = service.list();

        for (VacationVo vo : listVo) {
            System.out.println(vo);
        }

        model.addAttribute("vacationListVo", listVo);

        return "vacation/list";
    }


}



//    @PostMapping("detail")
//    @ResponseBody
//    public String detail(String vno){
//        VacationVo vo = service.selectOne();
//        return "";
//    }

