package com.example.sing;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SingService {
    private final SingMapper mapper;

    public int singInsert(SingVo vo) {
        return mapper.singInsert(vo);
    }

    public SingVo singByNo(Long no) {
        return  mapper.singByNo(no);
    }

    public List<SingVo> singByAll() {
        return mapper.singByAll();
    }

    public int edit(Long no) {
        return mapper.edit(no);
    }
}
