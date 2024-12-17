package com.kh.semitest.overtime.service;

import com.kh.semitest.overtime.mapper.OverTimeMapper;
import com.kh.semitest.overtime.vo.OverTimeVo;
import com.kh.semitest.vacation.vo.EmployeeVo;
import com.kh.semitest.vacation.vo.VacationVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OverTimeService {
    private final OverTimeMapper mapper;

    public List<OverTimeVo> selectAll() {
        return mapper.selectAll();
    }

    public List<EmployeeVo> empVoList() {
        return mapper.empVoList();
    }

    public int insert(OverTimeVo vo) {
        return mapper.insert(vo);
    }

    public EmployeeVo selectvolist(String empNo) {
        return mapper.selectvolist(empNo);
    }

    public List<OverTimeVo> list() {
        return mapper.selectAll();
    }
}
