package com.kh.semi.conf;

import org.springframework.stereotype.Component;

import java.io.File;

@Component

public class PathInfo {
    private final String staticPath =
            "D:" + File.separator
            + "dev" + File.separator
            + "springbootWorkspace" + File.separator
            + "semi" + File.separator
            + "src" + File.separator
            + "main" + File.separator
            + "resources" + File.separator
            + "static" + File.separator;


    public String getProfilePath(){

        String path = staticPath
                + "img" + File.separator
                + "profile" + File.separator;
        return path;
    }
    public String getBoardAttachmentPath(){
        String path = staticPath
                + "img" + File.separator
                + "board" + File.separator
                + "attachment" + File.separator;
        return path;
    }
}
