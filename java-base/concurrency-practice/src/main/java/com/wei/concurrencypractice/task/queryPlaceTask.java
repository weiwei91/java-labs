package com.wei.concurrencypractice.task;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Place;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/20/17:03
 */
public class queryPlaceTask implements Callable {
    private String placeCode;
    private DeviceServiceClient deviceServiceClient;

    public queryPlaceTask(DeviceServiceClient deviceServiceClient, String placeCode){
         this.deviceServiceClient = deviceServiceClient;
         this.placeCode=placeCode;

    }

    @Override
    public Place call() throws Exception {
        Response<Place> placeResponse = deviceServiceClient.getPlaceById(placeCode);
        return placeResponse.isSuccess() ? placeResponse.getData() : null;
    }
}
