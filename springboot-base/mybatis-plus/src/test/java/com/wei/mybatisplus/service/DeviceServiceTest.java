package com.wei.mybatisplus.service;

import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.MybatisPlusApplicationTests;
import com.wei.mybatisplus.mapper.DeviceMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


public class DeviceServiceTest extends MybatisPlusApplicationTests {

    @MockBean
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;

    @Test
    public void testGet() {
        Mockito.when(deviceMapper.selectById("wei")).thenReturn(
                Device.builder().ip("10.12.13.10").indexCode("weiwei").deviceName("weiwei").build());

        Device device = deviceService.getDeviceForUnitTest("wei");
        // 校验结果
        Assert.assertEquals("编号不匹配", "weiwei", device.getIndexCode());
        Assert.assertEquals("设备名不匹配", "weiwei", device.getDeviceName());
        Assert.assertEquals("ip不匹配", "10.12.13.10", device.getIp());
    }
}
