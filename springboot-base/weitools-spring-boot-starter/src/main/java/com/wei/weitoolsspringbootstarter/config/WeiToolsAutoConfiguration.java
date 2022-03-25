package com.wei.weitoolsspringbootstarter.config;

import com.wei.weitoolsspringbootstarter.util.Tools;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeiToolsAutoConfiguration {
    @Bean
    Tools getTools(){
        return new Tools();
    }
}
