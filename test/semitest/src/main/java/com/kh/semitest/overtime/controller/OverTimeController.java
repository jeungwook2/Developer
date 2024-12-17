package com.kh.semitest.overtime.controller;

import com.kh.semitest.overtime.service.OverTimeService;
import com.kh.semitest.overtime.vo.OverTimeVo;
import com.kh.semitest.vacation.vo.EmployeeVo;
import com.kh.semitest.vacation.vo.VacationVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/hr/overtime")
public class OverTimeController{
    private final OverTimeService service;


    @GetMapping("write")
    public String write(Model model){
        List<EmployeeVo> empVoList = service.empVoList();

        for (EmployeeVo vo : empVoList) {
            System.out.println("vo = " + vo);
        }

        model.addAttribute("empVoList",empVoList);


        return "overtime/write";
    }

    @PostMapping("write")
    public String write(OverTimeVo vo){

        System.out.println("vo.hour =="+vo.getHour());
        System.out.println("vo.minute =="+vo.getMinute());



        String overtime = vo.getHour()+":"+vo.getMinute();

        System.out.println("overtime : " +overtime);
        vo.setWorkHour(overtime);
        int result = service.insert(vo);

        return "redirect:/api/hr/overtime/list";
    }



    //////사원 선택 버튼클릭후  모달창에 있는 정보를 받아오는 ajax
    @PostMapping("getEmployeeData")
    @ResponseBody
    public EmployeeVo getEmployeeData(@RequestParam("empNo") String empNo){

        System.out.println(empNo);
        EmployeeVo selectvolist = service.selectvolist(empNo);
        return selectvolist;
    }


    @GetMapping("list")
    public String list(Model model){
        List<OverTimeVo> listVo = service.list();

        for (OverTimeVo vo : listVo) {
            System.out.println(vo);
        }

        model.addAttribute("vacationListVo",listVo);

        return "vacation/list";
    }

}
