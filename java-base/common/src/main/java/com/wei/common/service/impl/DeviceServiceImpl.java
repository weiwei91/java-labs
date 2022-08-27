package com.wei.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.common.mapper.DeviceMapper;
import com.wei.common.model.entity.Device;
import com.wei.common.service.DeviceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Resource
    DeviceMapper deviceMapper;

    @Override
    public Device getDeviceForUnitTest(String id) {
        return deviceMapper.selectById(id);
    }


}
