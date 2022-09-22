package com.wei.mybatisplus.wrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.MybatisPlusApplicationTests;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.service.DeviceService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
public class WrapperTest extends MybatisPlusApplicationTests {

    @Resource
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceService deviceService;

    @Test
    public void testGet() {
        QueryWrapper<Device> queryWrapper =new QueryWrapper<>();

        queryWrapper.select("*").like("device_name","超脑");

        List<Device> deviceList = deviceMapper.selectList(queryWrapper);



    }

    @Test
    public void testPage() {
        QueryWrapper<Device> queryWrapper =new QueryWrapper<>();

        queryWrapper.select("*").like("device_name","超脑");

        Page page =new Page<>(2,10);
        Page<Device> deviceList = deviceMapper.selectPage(page,queryWrapper);



    }


}
