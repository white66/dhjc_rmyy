package com.rtst.syzx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.rtst.syzx.repository")
@SpringBootApplication
public class SyzxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SyzxApplication.class, args);
    }

}
