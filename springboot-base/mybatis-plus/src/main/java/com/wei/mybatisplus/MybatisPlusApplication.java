package com.wei.mybatisplus;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author weiwei10
 */

@SpringBootApplication(scanBasePackages = {"com.wei","com.hikvision"})
@MapperScan(basePackages= {"com.wei.common.mapper"})
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
        System.out.println("启动成功");
    }

}
