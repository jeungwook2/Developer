package com.example.sing;

import com.example.sing.response.SingEnrollResponse;
import com.example.sing.response.SingListByAllResponse;
import com.example.sing.response.SingListByNoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("sing")
public class SingController {

    private final SingService service;
    
    //노래 등록하기
    @PostMapping
    public SingEnrollResponse singInsert(SingVo vo){
        int result = service.singInsert(vo);
        SingEnrollResponse response = new SingEnrollResponse();
        response.setResult(result);
        return response;
    }

    //노래 상세조회
    @GetMapping("{no}")
    public SingListByNoResponse singByNo(@PathVariable Long no){
        SingVo vo = service.singByNo(no);
        SingListByNoResponse response = new SingListByNoResponse();
        response.setData(vo);
        return response;
    }

    //노래 목록조회
    @GetMapping
    public SingListByAllResponse SingByAll(){
        List<SingVo> voList = service.singByAll();
        SingListByAllResponse response = new SingListByAllResponse();
        response.setAllData(voList);
        return response;
    }

    //노래삭제
    @DeleteMapping
    public SingEnrollResponse edit(Long no){
        int result = service.edit(no);
        SingEnrollResponse response = new SingEnrollResponse();
        response.setResult(result);
        return response;
    }


}
