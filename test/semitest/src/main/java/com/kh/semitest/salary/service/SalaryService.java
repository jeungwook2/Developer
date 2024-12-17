package com.kh.semitest.salary.service;

import com.kh.semitest.salary.mapper.SalaryMapper;
import com.kh.semitest.salary.vo.SalaryVo;
import com.kh.semitest.vacation.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryMapper mapper;


    public List<SalaryVo> listAll() {
        return mapper.listAll();
    }

    public EmployeeVo selectvolist(String empNo) {
        return mapper.selectvolist(empNo);
    }

    public List<EmployeeVo> empVoList() {
        return mapper.empVoList();
    }

    public int write(SalaryVo vo) {
        return mapper.write(vo);
    }
}
