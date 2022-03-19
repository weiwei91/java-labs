package com.wei.mybatisplus;

import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.service.DeviceService;
import com.wei.mybatisplus.task.BatchSaveTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootTest
@Slf4j
class MybatisPlusApplicationTests {
    @Resource
    DeviceMapper deviceMapper;
    @Autowired
    DeviceService deviceService;

    @Test
    void contextLoads() {
        List<Device> list = deviceMapper.selectList(null);
        log.info("1");
    }

    @Test
    void addDevice() {
        Device device = Device.builder()
                .deviceName("超脑设备2号")
                .ip("10.16.20.23")
                .port("5202")
                .capability("pir")
                //.indexCode("123")
                //.createTime(new Date())
                .version(1)
                .build();
        deviceMapper.insert(device);
    }
    @Test
    void updateDevice(){
        //验证 乐观锁
        Device device1= deviceMapper.selectById("ce89a665fe8de3578d7b00fe2ead2a2a");
        device1.setDeviceName("更新13");
        Device device2= deviceMapper.selectById("ce89a665fe8de3578d7b00fe2ead2a2a");
        device2.setDeviceName("更新14");
        int a = deviceMapper.updateById(device2);
        int b = deviceMapper.updateById(device1);
        log.info("123");

    }

    @Test
    void mockData(){
        //单线程模拟产生数据100条数据
        Long startTime = System.currentTimeMillis();
        for (int i=0;i<30000000;i++){
            Device device = Device.builder()
                    .deviceName("超脑设备"+i+"号")
                    .ip("10.16.20."+i)
                    .port("5202")
                    .capability("pir")
                    .build();
            deviceMapper.insert(device);
        }
        Long endTime = System.currentTimeMillis();
        log.info("30000000条数据,逐个插入共耗时:{}秒",(endTime-startTime)/1000);
    }

    @Test
    void mockData1(){
        //单线程模拟产生数据100条数据
        Long startTime = System.currentTimeMillis();
        List<Device> list = getDevices(50000);
        deviceService.saveBatch(list);
        Long endTime = System.currentTimeMillis();
        log.info("5万条数据,批量插入共耗时:{}秒",(endTime-startTime)/1000);
        //45秒
    }

    @Test
    void mockData2() throws InterruptedException {
        //多线程批量模拟产生数据100条数据
        Long startTime = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(500);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=10000;i<50000001;){
            List<Device> list1 = getDevices(10000);
            i=i+10000;
            executorService.submit(new BatchSaveTask(deviceService,list1,countDownLatch));
        }
        countDownLatch.await();
        Long endTime = System.currentTimeMillis();
        log.info("5千万条数据,批量插入共耗时:{}秒",(endTime-startTime)/1000);
        //10秒
    }

    public List<Device> getDevices(int size){
        List<Device> list = new ArrayList<>();
        Random random = new Random();
        for (int i = random.nextInt(); i<size; i++){
            Device device = Device.builder()
                    .deviceName("超脑设备"+i+"号")
                    .ip("10.16.20."+i)
                    .port("5202")
                    .capability("pir")
                    .build();
            list.add(device);
        }
        return list;
    }


}