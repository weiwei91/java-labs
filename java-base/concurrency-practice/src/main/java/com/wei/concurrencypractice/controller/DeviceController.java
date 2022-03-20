package com.wei.concurrencypractice.controller;

import com.wei.common.base.response.Response;
import com.wei.common.model.dto.DeviceDto;
import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import com.wei.concurrencypractice.convert.DeviceConvert;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class DeviceController {
    @Resource
    DeviceServiceClient deviceServiceClient;

    /**
     * 方案1：串行执行
     * 每个请求模拟耗时100ms，总共三个请求
     * 串行执行 总共耗时400ms左右
     * **/
    @GetMapping("/getDeviceById")
    @ResponseBody
    public Response getDeviceById(String id) {
        Response<Device> deviceResponse = deviceServiceClient.getDeviceById(id);
        if (deviceResponse.isSuccess()){
            Device device = deviceResponse.getData();
            Response<Region> regionResponse = deviceServiceClient.getRegionById(device.getRegionCode());
            Response<Place> placeResponse =deviceServiceClient.getPlaceById(device.getPlaceCode());
            if (regionResponse.isSuccess() && placeResponse.isSuccess()){
                DeviceDto deviceDto = DeviceConvert.INSTANCE.convertDeviceDto(device,regionResponse.getData(),placeResponse.getData());
                return Response.success(deviceDto);
            }
        }
        return Response.failure("fail");
    }
}
