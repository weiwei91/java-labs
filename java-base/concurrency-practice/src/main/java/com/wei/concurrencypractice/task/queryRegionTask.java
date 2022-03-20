package com.wei.concurrencypractice.task;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import com.wei.concurrencypractice.retrofit.DeviceServiceClient;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/20/17:04
 */
public class queryRegionTask implements Callable {
    private String regionCode;
    private DeviceServiceClient deviceServiceClient;

    public queryRegionTask(DeviceServiceClient deviceServiceClient, String regionCode){
        this.deviceServiceClient = deviceServiceClient;
        this.regionCode=regionCode;

    }

    @Override
    public Region call() throws Exception {
        Response<Region> regionResponse = deviceServiceClient.getRegionById(regionCode);
        return regionResponse.isSuccess() ? regionResponse.getData() : null;
    }
}
