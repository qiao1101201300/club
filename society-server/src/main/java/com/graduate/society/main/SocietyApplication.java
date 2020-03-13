package com.graduate.society.main;

import com.graduate.society.filter.CheckLoginFilter;
import com.graduate.society.shiro.ShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;

@SpringBootApplication(scanBasePackages = "com.graduate.society")
@MapperScan("com.graduate.society.mapper")
@Slf4j
public class SocietyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocietyApplication.class, args);
    }

    @Bean(name = "sessionFilter")
    public Filter sessionFilter() {
        return new CheckLoginFilter();
    }

    @Bean(name = "shiroRealm")
    public ShiroRealm customRealm() {
        return new ShiroRealm();
    }
}
