package com.rtst.dhjc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("com.rtst.dhjc.repository")
@SpringBootApplication
@EnableSwagger2
@EnableScheduling
public class DhjcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhjcApplication.class, args);
    }
}
