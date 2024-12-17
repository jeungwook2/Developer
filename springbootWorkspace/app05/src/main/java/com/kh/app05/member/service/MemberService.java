package com.kh.app05.member.service;

import com.kh.app05.member.dao.MemberDao;
import com.kh.app05.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
//    성공하면 commit 실패하면 rollback 자동으로 실행
//    예외가 없으면 commit 있으면 rollback 예외를 기준으로 성공여부 판단
//클래스 레벨에 달아주면 모든 클래스에 대해 적용된다
public class MemberService {

    private final MemberDao dao;

    
    public int join(MemberVo vo) {
        return dao.join(vo);


    }

    public MemberVo login(MemberVo vo){
        MemberVo loginMemberVo = dao.login(vo);
        return loginMemberVo;
    }
//    public List<MemberVo> login() {
//    List<MemberVo> list = dao.login();
//
//    return list;
//    }
}
