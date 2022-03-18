package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.mybatisplus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/getDeviceById")
    @ResponseBody
    public Response getDeviceById(String id) {
        //000002cfeccb6511c8f0785ab9c49d6b
        return Response.success(deviceService.getById(id));
    }
}
