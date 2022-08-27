package com.wei.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wei.common.model.entity.Device;

public interface DeviceService extends IService<Device> {

    public Device getDeviceForUnitTest(String id);

}
