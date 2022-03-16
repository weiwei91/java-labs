package com.wei.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wei.common.model.entity.Device;
import com.wei.mybatisplus.mapper.DeviceMapper;
import com.wei.mybatisplus.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
}
