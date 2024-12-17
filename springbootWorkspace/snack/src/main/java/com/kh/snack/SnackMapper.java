package com.kh.snack;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SnackMapper {
    @Insert("""
            INSERT INTO SNACK(
                NO
                ,NAME
                ,PRICE
                ,BRAND
                ,EXPIRATION_DATE
            )
            VALUES(
                SEQ_SNACK.NEXTVAL
                ,#{name}
                ,#{price}
                ,#{brand}
                ,#{expirationDate}
            )
            """)
    int insert(SnackVo vo);


    @Select("""
            SELECT
                NO
                ,NAME
                ,PRICE
                ,BRAND
                ,EXPIRATION_DATE
                FROM SNACK
            WHERE NO = #{no}
            """)
    SnackVo getSnackByNo(Long no);

    @Select("""
            SELECT
                NO
                ,NAME
                ,PRICE
                ,BRAND
                ,EXPIRATION_DATE
                FROM SNACK
            """)
    List<SnackVo> getSnackByAll();

    @Delete("""
            DELETE SNACK
            WHERE NO = #{no}
            """)
    int deleteSnack(Long no);
}
