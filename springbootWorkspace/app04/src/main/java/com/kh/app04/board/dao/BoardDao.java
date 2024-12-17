package com.kh.app04.board.dao;

import com.kh.app04.board.mapper.BoardMapper;
import com.kh.app04.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    @Autowired
    private BoardMapper mapper;

    public int insert(BoardVo vo){
    //sql 실행은 매퍼객체.메소드(); 형식으로진행
        return mapper.insert(vo);

    }
}
