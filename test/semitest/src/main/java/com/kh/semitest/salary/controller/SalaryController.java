package com.kh.semitest.salary.controller;

import com.kh.semitest.salary.service.SalaryService;
import com.kh.semitest.salary.vo.SalaryVo;
import com.kh.semitest.vacation.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/hr/salary")
public class SalaryController {

    private final SalaryService service;

    @GetMapping("list")
    public String listAll(Model model){

        List<SalaryVo> SalaryVoList = service.listAll();

        for (SalaryVo vo : SalaryVoList) {
            System.out.println("vo    :" +vo);
        }
        model.addAttribute("SalaryVoList",SalaryVoList);
        return "salary/list";
    }

    @GetMapping("write")
    public String write(Model model){
        List<EmployeeVo> empVoList = service.empVoList();

        for (EmployeeVo vo : empVoList) {
            System.out.println("vo = " + vo);
        }

        model.addAttribute("empVoList",empVoList);


        return "salary/write";
    }


    @PostMapping("write")
    public String write(SalaryVo vo){
        System.out.println("payYearmonth  == " +vo.getPayYearmonth());

        String payYearmonth = vo.getPayYearmonth();
        String formattedPayYearmonth = payYearmonth.replace("-", "");

        vo.setPayYearmonth(formattedPayYearmonth);

        int result = service.write(vo);

        return "redirect:/api/hr/salary/list";
    }



    //////사원 선택 버튼클릭후  모달창에 있는 정보를 받아오는 ajax
    @PostMapping("getEmployeeData")
    @ResponseBody
    public EmployeeVo getEmployeeData(@RequestParam("empNo") String empNo){

        System.out.println(empNo);
        EmployeeVo selectvolist = service.selectvolist(empNo);
        return selectvolist;
    }
}
