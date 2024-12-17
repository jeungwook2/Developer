package com.kh.semi.admin.service;

import com.kh.semi.admin.mapper.AdminMapper;
import com.kh.semi.admin.vo.AdminVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AdminService {

    private final AdminMapper mapper;

    public AdminVo login(AdminVo vo) {
        return mapper.login(vo);
    }
}
