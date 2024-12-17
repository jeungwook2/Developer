package com.kh.review.book.mapper;

import com.kh.review.book.vo.BookVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("""
            INSERT INTO BOOK(
            NO
            ,TITLE
            ,WRITER
            ,PRICE
            
            
            )
            VALUES (
            SEQ_BOOK.NEXTVAL
            ,#{title}
            ,#{writer}
            ,#{price}
            
            )
            """)
    int insert(BookVo vo);

    @Select("""
            SELECT
                NO,
                TITLE,
                WRITER,
                PRICE,
                PUBLISHED_DATE,
                DEL_YN
            FROM BOOK
            WHERE DEL_YN = 'N'
            """)
    List<BookVo> getAllList();

    @Select("""
            SELECT
                NO,
                TITLE,
                WRITER,
                PRICE,
                PUBLISHED_DATE,
                DEL_YN
            FROM BOOK
            WHERE NO =#{no}AND DEL_YN='N'
            """)
    BookVo onelist(String no);


    @Update("""
            UPDATE BOOK
            SET DEL_YN ='Y'
            WHERE NO =#{no}
            """)
    int edit(String no);
}
