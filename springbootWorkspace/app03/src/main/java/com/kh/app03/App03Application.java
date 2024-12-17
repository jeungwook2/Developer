package com.kh.app03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
//MapperScan로 인해서 Mapper 어노테이션 이 bin으로 작업이가능하도록 만들었다.
public class App03Application {

	public static void main(String[] args) {
		SpringApplication.run(App03Application.class, args);
	}

}
