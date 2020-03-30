package com.rtst.dhjc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.rtst.dhjc.repository")
@SpringBootApplication
public class DhjcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DhjcApplication.class, args);
    }

}
