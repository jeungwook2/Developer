package com.kh.semitest.vacation.service;

import com.kh.semitest.vacation.mapper.VacationMapper;
import com.kh.semitest.vacation.vo.EmployeeVo;
import com.kh.semitest.vacation.vo.VacationVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationService {

    private final VacationMapper mapper;

    public List<VacationVo> list() {
        return mapper.list();
    }

    public int insert(VacationVo vo) {
        return mapper.insert(vo);
    }

    public List<EmployeeVo> empVoList( ) {
        return mapper.empVoList();
    }

    public EmployeeVo selectvolist(String empNo) {
        return mapper.selectvolist(empNo);
    }
}
