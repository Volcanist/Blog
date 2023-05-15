package com.tc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@MapperScan("com.tc.mapper")
@EnableScheduling
@EnableSwagger2
public class tcBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(tcBlogApplication.class,args);
    }
}
