package com.tc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.tc.mapper")
public class tcBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(tcBlogApplication.class,args);
    }
}
