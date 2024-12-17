package com.kh.semi.member.mapper;

import com.kh.semi.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MemberMapper {
    @Insert("""
            INSERT INTO MEMBER
            (
                NO,
                ID,
                PWD,
                NICK,
                PROFILE
            ) VALUES(
                SEQ_MEMBER.NEXTVAL,
                #{id},
                #{pwd},
                #{nick},
                #{profile}
            )
            """)
    int join(MemberVo vo);


    @Select("""
            SELECT * FROM MEMBER
            WHERE ID = #{id}
            AND PWD = #{pwd}
            AND  DEL_YN ='N'
            """)
    MemberVo login(MemberVo vo);


    int edit(MemberVo vo);


    @Select("""
            SELECT
            NO,
            ID,
            PWD,
            NICK,
            DEL_YN,
            ENROLL_DATE,
            MODIFY_DATE
            FROM MEMBER
            WHERE NO = #{no}
            AND DEL_YN='N'
            """)
    MemberVo getMemberByNo(String no);

    @Update("""
            UPDATE MEMBER 
            SET
            DEL_YN='Y'
            WHERE PWD=#{pwd} AND
            NO= #{no}
            """)
    int quit(MemberVo vo);

    @Select("""
            SELECT * FROM MEMBER 
            WHERE ID = #{id}
            """)
    MemberVo checkDupId(String id);

    @Insert("""
            
            INSERT INTO BOARD(
            NO,
            TITLE,
            CONTENT,
            CATEGORY_NO,
            WRITER_NO
            )VALUES(
            SEQ_BOARD.NEXTVAL,
            'ASB22',
            'ASB22',
            1,
            #{bno}
            )
            """)
    int write(String bno);
}
