package com.example.sing.response;

import com.example.sing.SingVo;
import lombok.Data;

import java.util.List;

@Data
public class SingListByAllResponse {
    private List<SingVo> allData;
}
