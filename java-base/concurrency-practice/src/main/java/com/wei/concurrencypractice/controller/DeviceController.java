package com.wei.concurrencypractice.controller;

import com.wei.common.base.response.Response;
import com.wei.common.model.dto.DeviceDto;
import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import com.wei.concurrencypractice.convert.DeviceConvert;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;
import com.wei.concurrencypractice.task.queryPlaceTask;
import com.wei.concurrencypractice.task.queryRegionTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


@RestController
public class DeviceController {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

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


    /**
     * 方案2：并发执行
     * 每个请求模拟耗时100ms，总共三个请求
     * 将能并发优化成并发执行
     * 250ms  并发优化了100ms
     * **/
    @GetMapping("/getDeviceById1")
    @ResponseBody
    public Response getDeviceById1(String id) throws InterruptedException, ExecutionException {

        Response<Device> deviceResponse = deviceServiceClient.getDeviceById(id);
        if (deviceResponse.isSuccess()){
            Device device = deviceResponse.getData();
            Future<Place> placeFuture = executorService.submit(new queryPlaceTask(deviceServiceClient,device.getPlaceCode()));
            Future<Region> regionFuture = executorService.submit(new queryRegionTask(deviceServiceClient,device.getRegionCode()));
            //Future get会阻塞主线程
            Place place = placeFuture.get();
            Region region = regionFuture.get();
            if (place != null && region != null){
                DeviceDto deviceDto = DeviceConvert.INSTANCE.convertDeviceDto(device,region,place);
                return Response.success(deviceDto);
            }
        }
        return Response.failure("fail");
    }
}
