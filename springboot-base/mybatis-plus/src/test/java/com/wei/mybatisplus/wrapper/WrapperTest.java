package com.wei.mybatisplus.wrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WrapperTest {

    @Resource
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;

    @Test
    public void testGet() {
        QueryWrapper<Device> queryWrapper =new QueryWrapper<>();

        queryWrapper.select("*").like("device_name","超脑");

        List<Device> deviceList = deviceMapper.selectList(queryWrapper);

        log.info("1");

    }
}
