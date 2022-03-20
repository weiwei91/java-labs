package com.wei.concurrencypractice.controller;

import com.wei.common.base.response.Response;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeviceController {
    @Autowired
    DeviceServiceClient mybatisPlusFeignClient;

    @GetMapping("/getDeviceById")
    @ResponseBody
    public Response getDeviceById(String id) {
        return mybatisPlusFeignClient.getDeviceById(id);
    }
}
