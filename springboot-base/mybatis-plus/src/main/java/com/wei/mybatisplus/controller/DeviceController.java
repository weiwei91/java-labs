package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.mybatisplus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/getDeviceById")
    @ResponseBody
    public Response getDeviceById(String id) throws InterruptedException {
        Thread.sleep(100);
        return Response.success(deviceService.getById(id));
    }
    @GetMapping("/getString")
    public String getString(String id) {
        //000002cfeccb6511c8f0785ab9c49d6b
        return "weiwei";
    }

}
