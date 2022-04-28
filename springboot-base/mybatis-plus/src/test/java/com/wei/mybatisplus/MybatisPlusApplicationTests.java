package com.wei.mybatisplus;

import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.mapper.PlaceMapper;
import com.wei.mybatisplus.mapper.RegionMapper;
import com.wei.mybatisplus.service.DeviceService;
import com.wei.mybatisplus.task.BatchSaveTask;
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
class MybatisPlusApplicationTests {
    @Resource
    DeviceMapper deviceMapper;
    @Autowired
    DeviceService deviceService;
    @Resource
    RegionMapper regionMapper;
    @Resource
    PlaceMapper placeMapper;

    @Test
    void batchSave(){
        List<Device> list =new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Device device = Device.builder()
                    .deviceName("超脑设备"+i+"号")
                    .ip("10.16.20.23")
                    .port("5202")
                    .capability("pir")
                    .regionCode("hangzhou")
                    .placeCode("200")
                    .version(1)
                    .build();
            deviceMapper.insert(device);
        }

    }


    @Test
    void contextLoads() {
        List<Device> list = deviceMapper.selectList(null);

    }

    @Test
    void addRegion(){
        Region region1 =Region.builder()
                .regionName("余杭")
                .indexCode("yuhang")
                .build();
        regionMapper.insert(region1);
    }

    @Test
    void addPlace(){
        Place region1 =Place.builder()
                .placeName("富阳区")
                .indexCode("200")
                .build();
        placeMapper.insert(region1);
    }

    @Test
    void addDevice() {

        for (int i = 0; i < 100; i++) {
            Device device = Device.builder()
                    .deviceName("超脑设备"+i+"号")
                    .ip("10.16.20.23")
                    .port("5202")
                    .capability("pir")
                    .regionCode("hangzhou")
                    .placeCode("200")
                    .version(1)
                    .build();
            deviceMapper.insert(device);
        }

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

    }

    @Test
    void mockData1(){
        //单线程模拟产生数据100条数据
        Long startTime = System.currentTimeMillis();
        List<Device> list = getDevices(50000);
        deviceService.saveBatch(list);
        Long endTime = System.currentTimeMillis();

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
