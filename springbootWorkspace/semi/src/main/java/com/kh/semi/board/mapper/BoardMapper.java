package com.kh.semi.board.mapper;

import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CateVo;
import com.kh.semi.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            INSERT INTO BOARD(
                NO,
                TITLE,
                CONTENT,
                CATEGORY_NO,
                WRITER_NO
            )VALUES (
                SEQ_BOARD.NEXTVAL,
                #{title},
                #{content},
                #{categoryNo},
                #{writerNo}
            )
            """)
    int write(BoardVo vo);


    int insertBoardAttachment(List<String> changeName);



    @Select("""
            SELECT * FROM CATEGORY
            """)
    List<CateVo> getCategory();

    @Select("""
            SELECT
            A.NO,
            A.TITLE,
            A.CONTENT,
            A.CATEGORY_NO,
            C.NAME AS categoryName,
            A.WRITER_NO,
            B.NICK AS WRITER_NICK,
            A.HIT,
            A.CREATE_DATE,
            A.DEL_YN
            FROM
            BOARD A JOIN ADMIN B ON(A.WRITER_NO = B.NO)
            JOIN CATEGORY C ON (A.CATEGORY_NO = C.NO)
                        WHERE A.DEL_YN ='N'
                        ORDER BY NO DESC
            """)
    List<BoardVo> list();


    @Select("""
            SELECT
                            B.NO
                            ,B.TITLE
                            ,B.CONTENT
                            ,B.CATEGORY_NO
                            ,B.WRITER_NO
                            ,B.HIT
                            ,B.CREATE_DATE
                            ,B.DEL_YN
                            ,M.NICK AS WRITER_NICK
                            ,C.NAME AS CATEGORY_NAME
                        FROM BOARD B
                        JOIN MEMBER M ON (B.WRITER_NO = M.NO)
                        JOIN CATEGORY C ON (B.CATEGORY_NO = C.NO)
            WHERE B.DEL_YN ='N'
            ORDER BY B.NO DESC
            OFFSET #{offset} ROWS FETCH NEXT #{boardLimit} ROWS ONLY
            """)
    List<BoardVo> getCateVoist(PageVo pvo);




    List<BoardVo> getBoardVolist(PageVo pvo,String searchType , String searchValue);


    int getBoardCnt(String searchType,String searchValue);



    //게시글 insert


    //게시글 selectAll


    //게시글 select (상세조회)
    @Select("""
             SELECT
                            B.NO
                            ,B.TITLE
                            ,B.CONTENT
                            ,B.CATEGORY_NO
                            ,B.WRITER_NO
                            ,B.HIT
                            ,B.CREATE_DATE
                            ,B.DEL_YN
                            ,M.NICK AS WRITER_NICK
                            ,C.NAME AS CATEGORY_NAME
                        FROM BOARD B
                        JOIN MEMBER M ON (B.WRITER_NO = M.NO)
                        JOIN CATEGORY C ON (B.CATEGORY_NO = C.NO)
            
                        WHERE B.DEL_YN ='N' AND B.NO =#{bno}
                        ORDER BY NO DESC
            """)
    BoardVo getBoard(String bno);

    @Update("""
            UPDATE BOARD 
            SET HIT = HIT+1
            WHERE NO = #{bno}
            AND DEL_YN = 'N'
            """)
    int incresaseHit(String bno);

    @Update("""
            UPDATE BOARD
            SET DEL_YN= 'Y'
            WHERE NO = #{bno}
            AND DEL_YN ='N'
            """)
    int del(String bno);

    @Update("""
            UPDATE BOARD
            SET TITLE = #{title},
            CONTENT = #{content},
            CATEGORY_NO =#{categoryNo}
            WHERE NO = #{no} AND DEL_YN ='N'
            
            """)
    int update(BoardVo vo);

    @Select("""
              SELECT NO,
                     REF_NO,
                     ORIGIN_NAME,
                     CHANGE_NAME,
                     UPLOAD_DATE,
                     DEL_YN
              FROM BOARD_ATTACHMENT 
              WHERE REF_NO = #{bno} 
              AND DEL_YN ='N'
              ORDER BY NO DESC
            """)
    List<AttachmentVo> getAttachmentVoList(String bno);

    @Update("""
            UPDATE BOARD_ATTACHMENT
            SET 
                DEL_YN = 'Y'
              WHERE NO = #{ano}
            """)
//    삭제하는로직
    int delAttachment(String ano);

//업데이트
    int updateBoardAttachment(List<String> changeNameList, String no);

    //게시글 조회수 증가


}
