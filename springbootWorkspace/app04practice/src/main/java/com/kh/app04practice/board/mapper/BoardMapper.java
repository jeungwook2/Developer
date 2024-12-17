package com.kh.app04practice.board.mapper;

import com.kh.app04practice.board.vo.BoardVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO BOARD
            (
                NO
                , TITLE
                , CONTENT
                , WRITER_NO
            )
            VALUES
            (
                SEQ_BOARD.NEXTVAL
                , #{title}
                , #{content}
                , '1'
            )
            """)
    int insert(BoardVo vo);


    @Select("SELECT * FROM BOARD")
    List<BoardVo> select();
}
