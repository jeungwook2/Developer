package com.kh.semi.member.service;

import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.member.mapper.MemberMapper;
import com.kh.semi.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
    private final MemberMapper mapper;

    public int join(MemberVo vo) throws Exception {

        //biz

        validateMemberVo(vo);
        return mapper.join(vo);
    }

    public MemberVo login(MemberVo vo) throws Exception {
        validateMemberVo(vo);
        return mapper.login(vo);
    }

    public MemberVo edit(MemberVo vo) throws Exception {
        validateMemberVo(vo);
        int result = mapper.edit(vo);
        if(result !=1){
            String errCode ="[MEMBER-E-201] 회원정보 수정 에러 발생..";
            log.warn(errCode);
            throw new Exception(errCode);
        }
        MemberVo updateMemberVo = mapper.getMemberByNo(vo.getNo());
        return updateMemberVo;
    }
    public int quit(MemberVo vo) throws Exception {
        validateMemberVo(vo);
        return mapper.quit(vo);
    }

    public void validateMemberVo(MemberVo vo) throws Exception {
        String errCode = null;
        if(vo.getId()!= null && vo.getId().length()!=0 &&vo.getId().length() < 4){
           errCode ="[MEMBER-V-001]아이디가 너무 짦음";
        }
        if(vo.getPwd()!= null && vo.getPwd().length()!=0 &&vo.getPwd().length() < 4) {
            errCode ="[MEMBER-V-002]비밀번호가 너무 짦음";
        }
        if(vo.getNick()!= null && vo.getNick().length()!=0 && vo.getNick().length() < 4){
            errCode ="[MEMBER-V-003]닉네임이 너무 짦음";
        }
        if(errCode !=null){
            log.warn(errCode);
            throw new Exception(errCode);
        }

    }


    public boolean checkDupId(String id) {
        MemberVo vo = mapper.checkDupId(id);
//null
        //vo != true false
        return vo !=null;

    }

    public int write(String bno) {
        return mapper.write(bno);
    }
}
