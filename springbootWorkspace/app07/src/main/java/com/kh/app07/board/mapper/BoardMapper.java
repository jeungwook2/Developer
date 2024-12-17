package com.kh.app07.board.mapper;

import com.kh.app07.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("""
            SELECT
                B.NO
                , B.TITLE
                , B.CONTENT
                , B.WRITER_NO
                , B.HIT
                , B.ENROLL_DATE
                , B.MODIFY_DATE
                , B.DEL_YN
                , M.NICK AS WRITER_NICK
            FROM BOARD B
            JOIN MEMBER M ON ( B.WRITER_NO = M.NO )
            WHERE B.DEL_YN = 'N'
            ORDER BY B.NO DESC
            """)
    List<BoardVo> selectAll();

    @Insert("""
            INSERT INTO BOARD
                        (
                            NO
                            ,TITLE
                            ,CONTENT
                            ,WRITER_NO
                        )
                        VALUES
                        (
                            SEQ_BOARD.NEXTVAL
                            ,#{title}
                            ,#{content}
                            ,'1'
                        )
            """)
    int write(BoardVo vo);
}
