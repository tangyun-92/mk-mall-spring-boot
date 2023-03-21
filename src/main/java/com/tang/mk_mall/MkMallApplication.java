package com.tang.mk_mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.tang.mk_mall.model.dao")
@EnableSwagger2
public class MkMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MkMallApplication.class, args);
    }

}
