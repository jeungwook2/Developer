package com.kh.app07.board.service;

import com.kh.app07.board.dao.BoardDao;
import com.kh.app07.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private  final BoardDao dao;

    public List<BoardVo> selectAll() {
        List<BoardVo> list = dao.selectAll();

        return list;
    }

    @Transactional
    //이 메서드 가 정상적으로 실행되어야 commit 이 된다 그전에는 rollback으로 처리해라 라는 에너테이션
    //class 레벨에 달아주면 모든 클래스 레벨에 걸려있다.
    public int write(BoardVo vo) {
        dao.write(vo);

        int x= 1/0;

        dao.write(vo);

        return 1;
    }
}
