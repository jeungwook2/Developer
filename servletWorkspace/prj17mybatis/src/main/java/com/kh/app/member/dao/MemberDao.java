package com.kh.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public int join(MemberVo vo, SqlSession ss) {
		int result = ss.insert("MemberMapper.join",vo);
		return result;
	}

	public MemberVo login(MemberVo vo, SqlSession ss) {
		
		return ss.selectOne("MemberMapper.login",vo);
	}

}
