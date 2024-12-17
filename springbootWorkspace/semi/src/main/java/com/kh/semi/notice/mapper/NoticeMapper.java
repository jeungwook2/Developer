package com.kh.semi.notice.mapper;

import com.kh.semi.notice.vo.NoticeReplyVo;
import com.kh.semi.notice.vo.NoticeVo;
import com.kh.semi.util.page.PageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NoticeMapper {


    @Insert("""
            INSERT INTO NOTICE(
                NO
                ,TITLE
                ,CONTENT
                ,WRITER_NO
            )VALUES(
                SEQ_NOTICE.NEXTVAL
                ,#{title}
                ,#{content}
                ,#{writerNo}
            )
            """)
    int write(NoticeVo vo);

    @Select("""
             SELECT
                                    N.NO,
                                    N.TITLE,
                                    N.CONTENT,
                                    N.WRITER_NO,
                                    A.NICK AS WRITER_NICK,
                                    N.HIT,
                                    N.CREATE_DATE,
                                    N.DEL_YN
                                    FROM NOTICE N
                                    JOIN ADMIN A ON(N.WRITER_NO = A.NO)
                                    WHERE N.DEL_YN='N'
                                    ${str}
                                    ORDER BY N.NO DESC
            
                        OFFSET #{pvo.offset} ROWS FETCH NEXT #{pvo.boardLimit} ROWS ONLY
            """)
    List<NoticeVo> getNoticeList(PageVo pvo, String str);

    @Select("""
            SELECT COUNT(*) FROM NOTICE
                        WHERE DEL_YN ='N'
            """)
    int getNoticeCnt();

    @Select("""
            SELECT
                                    N.NO,
                                    N.TITLE,
                                    N.CONTENT,
                                    N.WRITER_NO,
                                    A.NICK AS WRITER_NICK,
                                    N.HIT,
                                    N.CREATE_DATE,
                                    N.DEL_YN
                                    FROM NOTICE N
                                    JOIN ADMIN A ON(N.WRITER_NO = A.NO)
                                    WHERE N.NO=#{no} AND
                                    N.DEL_YN='N'
            """)
    NoticeVo getNoticeByNo(String no);


    int delete(String[] dataArr);


    @Update("""
            
            UPDATE NOTICE
            SET TITLE = #{title},
            CONTENT = #{content}
            WHERE NO = #{no}
            AND DEL_YN='N'
            AND WRITER_NO = #{writerNo}
            
            """)
    int edit(NoticeVo vo);


    @Insert("""
            INSERT INTO NOTICE_REPLY(
                    NO,
                    CONTENT,
                    REF_NO,
                    WRITER_NO
            )VALUES(
                    SEQ_NOTICE_REPLY.NEXTVAL,
                    #{content},
                    #{refNo},
                    #{writerNo}
                    )
            """)
    int replyWrite(NoticeReplyVo vo);


    @Select("""
            SELECT
                N.NO,
                N.CONTENT,
                N.REF_NO,
                N.WRITER_NO,
                M.NICK AS WRITERNICK,
                N.CREATE_DATE,
                N.DEL_YN
            FROM NOTICE_REPLY N
            JOIN MEMBER M ON(N.WRITER_NO = M.NO)
            WHERE N.REF_NO = #{noticeNo}
            AND N.DEL_YN ='N'
            """)
    List<NoticeReplyVo> getNoticeReplyList(String noticeNo);
}
