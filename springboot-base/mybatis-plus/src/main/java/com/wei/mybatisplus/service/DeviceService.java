package com.wei.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.mapper.DeviceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public interface DeviceService extends IService<Device> {

    public Device getDeviceForUnitTest(String id);

}
