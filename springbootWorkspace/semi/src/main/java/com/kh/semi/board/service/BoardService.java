package com.kh.semi.board.service;

import com.kh.semi.board.mapper.BoardMapper;
import com.kh.semi.board.vo.AttachmentVo;
import com.kh.semi.board.vo.BoardVo;
import com.kh.semi.board.vo.CateVo;
import com.kh.semi.util.page.PageVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BoardService {

    private final BoardMapper mapper;

    //게시글 작성하기

    /**
     * 파일 업로드를 처리하는 메소드이다.
     * 첨부파일도 처리한다.
     * insert 결과가 양수이면 성공, 음수이면 실패
     * @param vo
     * @param changeName
     * @return insert한 결과가 return 된다
     */
    public int write(BoardVo vo, List<String> changeName){
        int result1 =mapper.write(vo);
        //첫번째 게시글 인서트를 날리고
        int result2 = 1;
        if(changeName.size()>0){
        result2 =mapper.insertBoardAttachment(changeName);
        }


        return  result1 * result2;


    }
    //게시글 목록조회
    public void selectAll(){

    }

    public List<CateVo> getCategory() {
        return mapper.getCategory();
    }

    public List<BoardVo> list(PageVo pvo,String searchType,String searchValue) {
        return mapper.getBoardVolist(pvo,searchType,searchValue);
    }

    public int getBoardCnt(String searchType,String searchValue) {
        return mapper.getBoardCnt(searchType,searchValue);
    }

    public BoardVo getBoard(String bno) {

        int result =mapper.incresaseHit(bno);

        if(result !=1){
            String errMsg ="Board > Service > 상세조회 > 조회수 증가 에러";
            log.error(errMsg);
            throw new IllegalStateException(errMsg);
        }
        return mapper.getBoard(bno);
    }

    public int del(String bno) {
        return mapper.del(bno);
    }

    public int update(BoardVo vo,List<String> changeNameList) {
         int result1 =mapper.update(vo);
        if(result1 != 1){
            throw new IllegalStateException("ERROR ~ BOARd > update > result1 error ~~~");
        }
        int result2 = 1;
        if(!changeNameList.isEmpty()){
            result2 = mapper.updateBoardAttachment(changeNameList , vo.getNo());
        }
        if(result2 < 1){
            throw new IllegalStateException("ERROR ~ BOARd > update > result2 error ~~~");
        }

        if(!changeNameList.isEmpty()){
            result2 =mapper.insertBoardAttachment(changeNameList);
        }
        return result1 * result2;
    }

    public List<AttachmentVo> getAttachmentVoList(String bno) {
        return mapper.getAttachmentVoList(bno);
    }

    public int delAttachment(String ano) {
        return mapper.delAttachment(ano);
    }
    //게시글 상세조회

}
