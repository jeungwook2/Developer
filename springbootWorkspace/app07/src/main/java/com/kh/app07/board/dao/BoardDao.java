package com.kh.app07.board.dao;

import com.kh.app07.board.mapper.BoardMapper;
import com.kh.app07.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDao {
    private final BoardMapper mapper;

    public List<BoardVo> selectAll() {
        List<BoardVo> list = mapper.selectAll();
        return list;
    }

    public int write(BoardVo vo) {
        return mapper.write(vo);
    }
}
