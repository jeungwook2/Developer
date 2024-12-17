package com.kh.app08.member.mapper;

import com.kh.app08.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                , ID
                , PWD
                , NICK
                , PROFILE   
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{id}
                , #{pwd}
                , #{nick}
                , #{profile}
            )
            """)
    int join(MemberVo vo);


    @Select("""
            SELECT *
            FROM MEMBER
            WHERE ID = #{id}
            AND PWD = #{pwd}
            AND DEL_YN = 'N'
            
            """)
    MemberVo login(MemberVo vo);
}
