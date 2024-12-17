package com.kh.app05.board.service;

import com.kh.app05.board.dao.BoardDao;
import com.kh.app05.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardDao dao;

    public int write(BoardVo vo) {

        return dao.write(vo);
    }

    public List<BoardVo> selectBoardList() {
        return dao.selectBoardList();
    }
}
