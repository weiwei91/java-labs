package com.wei.feign.config;
import com.wei.feign.client.DeviceServiceClient01;
import com.wei.feign.client.DeviceServiceClient02;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.spring.SpringContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public DeviceServiceClient01 userServiceFeignClient01() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(DeviceServiceClient01.class, "http://127.0.0.1:89"); // 目标地址
    }

    @Bean
    public DeviceServiceClient02 userServiceFeignClient02() {
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .contract(new SpringContract())//
                .target(DeviceServiceClient02.class, "http://127.0.0.1:89"); // 目标地址
    }



}
