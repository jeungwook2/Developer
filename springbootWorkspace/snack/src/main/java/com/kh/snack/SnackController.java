package com.kh.snack;

import com.kh.snack.response.SnackListdataResponse;
import com.kh.snack.response.SnackDetailResponse;
import com.kh.snack.response.SnackEnrollResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("snack")
@Slf4j
public class SnackController {
    //DIPENDENCY INJECTION
    //의존성 주입이며 SPRING 이 관리하는 BEAN으로 관리되는
    //클래스를 자동적으로 SnackService service= new SnackService(); 형태로 만들어주는것

    private final SnackService service;
    //final 을 붙이지 않으면 dependency injection이 되지않는다.
    //    @Autowired
    //    public SnackController(SnackService service){
    //        this.service =service;
    //    }   DI에 의해 현재 생성자가 생성되며 controller가 bean으로 등록될때
    //        함께 등록되게 된다



    // DI 방법
    // field injection    === @Autowired 생성자가 1개뿐일때는 생략이 가능하다
    // setter injection   ===
    // constructor injection  === @RequiredArgsConstructor

    //과자등록
    @PostMapping
    public SnackEnrollResponse enrollSnack(SnackVo vo){
        int result = service.enrollSnack(vo);
//        실행하는요소
        SnackEnrollResponse response = new SnackEnrollResponse();
//        int 타입의 멤버변수를 가지고있는 객체를 생성
        response.setResult(result);
//        @Data 에는 자동적으로 getter,setter,toString ... 등 메서드가 들어있다
//        그중 멤버변수에 int result 선언되어있는곳에 [객체.setResult]로써 값을 집어넣게된다
        return response;
//        객체를 리턴하게되면 자동적으로 JSON 형식으로 배출이 되는것을 이용한것.
    }


    //과자 상세조회
    @GetMapping("{no}")
//    중괄호를 사용해서 GetMapping에 들어온것을 변수로 받을수있다
    public SnackDetailResponse getSnackByNo(@PathVariable Long no){
        SnackVo vo = service.getSnackByNo(no);
        SnackDetailResponse response = new SnackDetailResponse();
        response.setData(vo);
        return response;

    }

    //과자 목록조회
    @GetMapping("list")
    public SnackListdataResponse getSnackByAll(){
        List<SnackVo> voList =service.getSnackByAll();
        SnackListdataResponse response = new SnackListdataResponse();
        response.setAllData(voList);
        return response;

    }

    //과자 삭제
    @DeleteMapping
    public SnackEnrollResponse deleteSnack(Long no){
        int result = service.deleteSnack(no);
        SnackEnrollResponse response = new SnackEnrollResponse();
        response.setResult(result);
        return response;

    }

}
