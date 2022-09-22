package com.wei.feign;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceRequest;
import com.wei.feign.client.DeviceServiceClient01;
import com.wei.feign.client.DeviceServiceClient02;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class FeignApplicationTests {
    @Resource
    DeviceServiceClient01 deviceServiceClient01;
    @Resource
    DeviceServiceClient02 deviceServiceClient02;

    @Test
    void testGet() {
        Response<Device> devcie1 = deviceServiceClient01.getDeviceById("242f8e85b6c1142b81f96784ee0b6b1f");
        Response<Device> devcie2 = deviceServiceClient02.getDeviceById("242f8e85b6c1142b81f96784ee0b6b1f");
        log.info("1");
    }

    @Test
    void testPost() {
        DeviceRequest.Add deviceAddRequest1 = new DeviceRequest.Add("1","123");
        DeviceRequest.Add  deviceAddRequest2 = new DeviceRequest.Add ("A","ASD");
        DeviceRequest deviceAddRequest3 = deviceServiceClient01.postAdd(deviceAddRequest1);
        DeviceRequest deviceAddRequest4 = deviceServiceClient01.postAdd(deviceAddRequest2);
        log.info("1");
    }

}
