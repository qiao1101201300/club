package com.demo.club.main;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.demo.club")
@MapperScan("com.demo.club.mapper")
@Slf4j
@EnableTransactionManagement
@EnableSwagger2
public class ClubApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubApplication.class, args);
    }

//    @Bean(name = "sessionFilter")
//    public Filter sessionFilter() {
//        return new CheckLoginFilter();
//    }

//    @Bean(name = "shiroRealm")
//    public ShiroRealm customRealm() {
//        return new ShiroRealm();
//    }
}
