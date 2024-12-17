package com.kh.book.service;

import com.kh.book.mapper.BookMapper;
import com.kh.book.vo.BookVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

    @Service
    @Transactional
    @Slf4j
    @RequiredArgsConstructor
    public class BookService {
        public final BookMapper mapper;

        public int insert(BookVo vo) {
            return mapper.insert(vo);
        }

        public List<BookVo> getAllList() {
            return mapper.getAllList();
        }

        public BookVo oneList(String no) {
            System.out.println("service no ==== "+no);
            return mapper.onelist(no);
        }

        public int edit(String no) {
            return mapper.edit(no);
        }
    }

