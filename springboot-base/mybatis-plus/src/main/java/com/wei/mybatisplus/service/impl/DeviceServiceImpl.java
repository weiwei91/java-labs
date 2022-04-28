package com.wei.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Resource
    DeviceMapper deviceMapper;

    @Override
    public Device getDeviceForUnitTest(String id) {
        return deviceMapper.selectById(id);
    }


}
