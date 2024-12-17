package com.kh.app04.board.vo;

import lombok.Data;

@Data

//데이터 에노테이션 생성하면 toString getter/setter 생성자 다 생성된다
//데이터 에노테이션 사용하려면 lombok 라이브러리 다운받아 사용해야한다
public class BoardVo {
    private String no;
    private String title;
    private String content;
    private String writerNo;
    private String hit;
    private String enrollDate;
    private String modifyDate;
    private String delYn;
}

//    public BoardVo() {
//
//    }
//
//    public BoardVo(String no, String title, String content, String writerNo, String hit, String enrollDate, String modifyDate, String delYn) {
//        this.no = no;
//        this.title = title;
//        this.content = content;
//        this.writerNo = writerNo;
//        this.hit = hit;
//        this.enrollDate = enrollDate;
//        this.modifyDate = modifyDate;
//        this.delYn = delYn;
//    }
//
//    public String getNo() {
//        return no;
//    }
//
//    public void setNo(String no) {
//        this.no = no;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getWriterNo() {
//        return writerNo;
//    }
//
//    public void setWriterNo(String writerNo) {
//        this.writerNo = writerNo;
//    }
//
//    public String getHit() {
//        return hit;
//    }
//
//    public void setHit(String hit) {
//        this.hit = hit;
//    }
//
//    public String getEnrollDate() {
//        return enrollDate;
//    }
//
//    public void setEnrollDate(String enrollDate) {
//        this.enrollDate = enrollDate;
//    }
//
//    public String getModifyDate() {
//        return modifyDate;
//    }
//
//    public void setModifyDate(String modifyDate) {
//        this.modifyDate = modifyDate;
//    }
//
//    public String getDelYn() {
//        return delYn;
//    }
//
//    public void setDelYn(String delYn) {
//        this.delYn = delYn;
//    }
//
//    @Override
//    public String toString() {
//        return "BoardVo{" +
//                "no='" + no + '\'' +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                ", writerNo='" + writerNo + '\'' +
//                ", hit='" + hit + '\'' +
//                ", enrollDate='" + enrollDate + '\'' +
//                ", modifyDate='" + modifyDate + '\'' +
//                ", delYn='" + delYn + '\'' +
//                '}';
//    }
//}
