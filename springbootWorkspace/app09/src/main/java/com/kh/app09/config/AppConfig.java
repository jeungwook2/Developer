package com.kh.app09.config;

import com.kh.app09.filter.KhFilter;
import com.kh.app09.home.controller.HomeController;
import com.kh.app09.home.controller.HomeService;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//스프링아 이거보고 스프링 설정해야되
public class AppConfig {
    @Bean
    public HomeService homeService(){
      return new HomeService();
    }
//    빈으로 지정할 객체를 생성해준걸 리턴해주면 빈으로써 동작한다.
    
    @Bean
    public FilterRegistrationBean m01(){
        FilterRegistrationBean<Filter> x = new FilterRegistrationBean<Filter>(new KhFilter());
        x.addUrlPatterns("/*");
        x.setOrder(1);
//        이필터의 통과해야하는 순번을 정할수 있다.
        return x;
    }
}
