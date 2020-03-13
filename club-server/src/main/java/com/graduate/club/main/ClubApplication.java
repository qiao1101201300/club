package com.graduate.club.main;

import com.graduate.club.filter.CheckLoginFilter;
import com.graduate.club.shiro.ShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.Filter;

@SpringBootApplication(scanBasePackages = "com.graduate.club")
@MapperScan("com.graduate.club.mapper")
@Slf4j
@EnableTransactionManagement
public class ClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubApplication.class, args);
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
