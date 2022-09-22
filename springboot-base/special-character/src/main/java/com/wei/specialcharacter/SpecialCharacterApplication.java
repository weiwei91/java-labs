package com.wei.specialcharacter;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(scanBasePackages = "com.wei")
@MapperScan("com.wei.common.mapper")
@Slf4j
public class SpecialCharacterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpecialCharacterApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        log.info("服务启动成功:http://localhost:" + environment.getProperty("local.server.port"));



    }


}
