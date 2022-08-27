package com.wei.specialcharacter.controller;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceAddRequest;
import com.wei.common.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @GetMapping("/getDeviceById")
    public Response getDeviceById(@RequestParam("id") String id) throws InterruptedException {
        Device device = deviceService.getById(id);
        return Response.success(device);
    }
    @PostMapping("/postAdd")
    public DeviceAddRequest getString(@RequestBody DeviceAddRequest deviceAddRequest) {
        return deviceAddRequest;
    }

}
