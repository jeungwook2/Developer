package com.kh.app05.board.dao;

import com.kh.app05.board.mapper.BoardMapper;
import com.kh.app05.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDao {
    private final BoardMapper mapper;

    public int write(BoardVo vo) {
        return mapper.write(vo);
    }

    public List<BoardVo> selectBoardList() {
        return mapper.selectBoardList();
    }
}
