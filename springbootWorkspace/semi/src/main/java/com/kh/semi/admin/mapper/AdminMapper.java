package com.kh.semi.admin.mapper;

import com.kh.semi.admin.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {



    @Select("""
            SELECT * FROM ADMIN
            WHERE ID = #{id} AND PWD = #{pwd}
            """)
    AdminVo login(AdminVo vo);
}
