package com.wei.specialcharacter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wei")
@MapperScan("com.wei.common.mapper")
public class SpecialCharacterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecialCharacterApplication.class, args);
    }

}
