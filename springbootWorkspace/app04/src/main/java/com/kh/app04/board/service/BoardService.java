package com.kh.app04.board.service;

import com.kh.app04.board.dao.BoardDao;
import com.kh.app04.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    
    @Autowired
    private BoardDao dao;

    public int insert(BoardVo vo) {
        //sql호출
            return dao.insert(vo);
            //스프링이 알아서 커넥션을 전달할것이다
        //tx 기본적으로 Auto커밋이 가능하다 그래서 tx처리 안한다.
            
        //close
        //close 기능도 spring에서 자동으로 해준다.
        //result

    }
}
