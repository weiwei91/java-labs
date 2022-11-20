package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceRequest;
import com.wei.common.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping("/getDeviceById")
    public Response getDeviceById(@RequestParam("id") String id) throws InterruptedException {
        Device device = deviceService.getById(id);
        return Response.success(device);
    }
    @PostMapping("/postAdd")
    public DeviceRequest getString(@RequestBody DeviceRequest deviceAddRequest) {
        return deviceAddRequest;
    }

}
