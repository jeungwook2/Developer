package com.kh.app03.member.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {


    //@Insert("INSERT INTO MEMBER ( NO ,ID ,PWD ,NICK ) VALUES ( SEQ_MEMBER.NEXTVAL ,#{id} ,#{pwd} ,#{nick} )")
    @Insert("INSERT INTO MEMBER ( NO ,ID ,PWD ,NICK ) VALUES ( SEQ_MEMBER.NEXTVAL ,'user1104' ,'1234' ,'nick1104' )")
    int m01();
    //스프링이 알아서 해준다.
}
