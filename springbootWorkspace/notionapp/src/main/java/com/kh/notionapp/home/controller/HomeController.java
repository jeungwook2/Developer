package com.kh.notionapp.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class HomeController {

    @GetMapping("test")
    public String m01() throws Exception {
        //HTTP 요청을 보내고 응답받기
        String databaseId ="154fef1413d78073be10d53428a768bb";
        String secretKey ="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";
        String notionVersion ="2022-06-28";
        //URL 설정
        URL url = new URL("https://api.notion.com/v1/databases/" + databaseId + "/query");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        //method 설정
        connection.setRequestMethod("POST");

        //data(Header)설정
        connection.setRequestProperty("Authorization", secretKey);
        connection.setRequestProperty("Notion-Version", notionVersion);
        connection.setRequestProperty("Content-Type", "application/json");


        //응답코드 얻기
        int responseCode = connection.getResponseCode();
        System.out.println("responseCode = " + responseCode);

        //데이터 읽기
        StringBuilder response = new StringBuilder();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String str;
        while ((str = reader.readLine()) != null) {
            response.append(str.trim());
        }
        System.out.println("response = " + response);
        return response.toString();

    }

}
