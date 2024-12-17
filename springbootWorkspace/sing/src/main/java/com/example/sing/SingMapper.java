package com.example.sing;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SingMapper {

    @Insert("""
            INSERT INTO SING(
                NO,
                TITLE,
                RELEASE_DATE,
                SINGER,
                COMPOSER
            )VALUES(
                SEQ_SING.NEXTVAL,
                #{title},
                #{releaseDate},
                #{singer},
                #{composer}
            )
            """)
    int singInsert(SingVo vo);

    @Select("""
            SELECT * FROM SING
            WHERE NO = #{no} AND DEL_YN ='N'
            """)
    SingVo singByNo(Long no);

    @Select("""
            SELECT * FROM SING
            WHERE DEL_YN='N'
            """)
    List<SingVo> singByAll();

    @Update("""
            UPDATE SING
            SET DEL_YN ='Y'
            WHERE NO = #{no}
            """)
    int edit(Long no);
}
