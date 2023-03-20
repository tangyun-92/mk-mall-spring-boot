package com.tang.mk_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tang.mk_mall.model.dao")
public class MkMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MkMallApplication.class, args);
    }

}
