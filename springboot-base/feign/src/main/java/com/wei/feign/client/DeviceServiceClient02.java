package com.wei.feign.client;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface DeviceServiceClient02 {
    @GetMapping("/device/getDeviceById")
    Response<Device> getDeviceById(@RequestParam("id") String id);

    @PostMapping(value = "/device/postAdd", consumes = "application/json")
    DeviceAddRequest postAdd(@RequestBody DeviceAddRequest request);
}
