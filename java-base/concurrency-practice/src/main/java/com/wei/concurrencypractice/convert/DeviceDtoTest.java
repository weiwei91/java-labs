package com.wei.concurrencypractice.convert;


import com.wei.common.model.dto.DeviceDto;
import com.wei.common.model.entity.Device;

public class DeviceDtoTest {

    public static void main(String[] args) {
        // 创建 UserDO 对象
        Device device =Device.builder().deviceName("123").capability("qwe").placeCode("123").build();
        DeviceDto deviceDto = DeviceConvert.INSTANCE.convert(device);
        System.out.println(1);

    }

}
