package com.wei.mybatisplus.task;

import com.wei.common.model.entity.Device;
import com.wei.common.service.DeviceService;
import java.util.List;
import java.util.concurrent.CountDownLatch;
/**
 * @author weiwei10
 */

public class BatchSaveTask implements Runnable{
    private final DeviceService deviceService;
    private final List<Device> list;
    private final CountDownLatch countDownLatch;

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
