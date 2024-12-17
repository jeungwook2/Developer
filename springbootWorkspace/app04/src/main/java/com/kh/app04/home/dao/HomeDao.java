package com.kh.app04.home.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDao {
    public void home(){
        System.out.println("home DAO 호출됨~~~");
    }
}
