package com.wei.mybatisplus.task;

import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.service.DeviceService;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class BatchSaveTask implements Runnable{
    private DeviceService deviceService;
    private List<Device> list;
    private CountDownLatch countDownLatch;

    public BatchSaveTask(DeviceService deviceService,List<Device> list,CountDownLatch countDownLatch){
        this.deviceService =deviceService;
        this.list=list;
        this.countDownLatch =countDownLatch;
    }

    @Override
    public void run() {
        deviceService.saveBatch(list);
        countDownLatch.countDown();
    }
}
