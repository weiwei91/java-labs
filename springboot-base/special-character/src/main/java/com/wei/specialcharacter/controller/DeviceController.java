package com.wei.specialcharacter.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceRequest;
import com.wei.common.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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


    @PostMapping("/list")
    public Response list(@RequestBody DeviceRequest.getList deviceAddRequest) {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>();
        /**
         * 特殊字符需要转义处理
         * _ -> \_
         * % -> \%
         **/
//        deviceAddRequest.setDeviceName( deviceAddRequest.getDeviceName().
//                replace("_","\\_").
//                replace("%","\\%") );

        queryWrapper.like("device_name",deviceAddRequest.getDeviceName());
        List<Device> list  = deviceService.list(queryWrapper);
        return Response.success(list);
    }



}
