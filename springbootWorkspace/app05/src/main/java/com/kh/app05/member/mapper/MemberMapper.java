package com.kh.app05.member.mapper;

import com.kh.app05.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
            INSERT INTO MEMBER
            (
                NO
                , ID
                , PWD
                , NICK
            )
            VALUES
            (
                SEQ_MEMBER.NEXTVAL
                , #{id}
                , #{pwd}
                , #{nick}
            )
            """)
    int join(MemberVo vo);

//    @Select("SELECT * FROM MEMBER")
//    List<MemberVo> login();
    @Select("""
            SELECT *
                        FROM MEMBER
                        WHERE ID = #{id}
                        AND PWD = #{pwd}
                        AND DEL_YN = 'N'
            """)
    MemberVo login(MemberVo vo);
}
