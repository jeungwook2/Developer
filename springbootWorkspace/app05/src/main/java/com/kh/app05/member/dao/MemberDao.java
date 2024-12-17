package com.kh.app05.member.dao;

import com.kh.app05.member.mapper.MemberMapper;
import com.kh.app05.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper;


    public int join(MemberVo vo) {
        return mapper.join(vo);
    }

//    public List<MemberVo> login() {
//        return mapper.login();
//    }
    
    public MemberVo login(MemberVo vo){
        return mapper.login(vo);
    }
}
