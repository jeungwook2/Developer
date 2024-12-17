package com.kh.semi.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploader {

    public static String save(MultipartFile f,String path) throws IOException {
        //이름 변경 먼저 하고
        //파일을 서버에 저장
        if(!f.isEmpty()){
            // 원본 파일의 이름
            String originalFilename = f.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));

            //광범위한 랜덤값을 가지고있는 변수로 이름을 지정한다.
            String randomStr = UUID.randomUUID().toString();
            // + 확장자 까지 가지고있어야 파일의 이름이 된다
            String changeName= randomStr +ext;
            //파일 객체 생성하고 인자값으로 저장되어있는 파일의 저장경로 줌
            File targetFile = new File(path+changeName);
            /*서버저장*/
            f.transferTo(targetFile);
            //
            return changeName;
        }
        return null;
    }
}
