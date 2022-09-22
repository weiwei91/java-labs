package com.wei.specialcharacter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.wei")
@MapperScan("com.wei.common.mapper")
public class SpecialCharacterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpecialCharacterApplication.class, args);
    }


}
