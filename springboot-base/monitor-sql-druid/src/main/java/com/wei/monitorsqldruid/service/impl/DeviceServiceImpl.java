package com.wei.monitorsqldruid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.common.model.entity.Device;
import com.wei.monitorsqldruid.mapper.DeviceMapper;
import com.wei.monitorsqldruid.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
}
