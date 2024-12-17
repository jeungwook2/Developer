package com.kh.app04practice.board.dao;

import com.kh.app04practice.board.mapper.BoardMapper;
import com.kh.app04practice.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private BoardMapper mapper;
    public int insert(BoardVo vo){
        return mapper.insert(vo);
    }

    public List<BoardVo> select() {
        List<BoardVo> list = mapper.select();
        return list;
    }
}
