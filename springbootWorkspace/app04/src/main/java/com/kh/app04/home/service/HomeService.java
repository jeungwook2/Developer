package com.kh.app04.home.service;

import com.kh.app04.home.dao.HomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class HomeService {
    @Autowired

    private HomeDao dao;

    public void home(){
        System.out.println("home 서비스 호출됨~~~");
        dao.home();
    }
}
