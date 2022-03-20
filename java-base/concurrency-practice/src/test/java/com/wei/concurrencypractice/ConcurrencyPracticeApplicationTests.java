package com.wei.concurrencypractice;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Place;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ConcurrencyPracticeApplicationTests {

    @Autowired
    DeviceServiceClient deviceServiceClient;

    @Test
    void contextLoads() {
        Response<Place> response = deviceServiceClient.getPlaceById("200");
        log.info("1");

    }

}
