package com.wei.concurrencypractice.convert;

import com.wei.common.model.dto.DeviceDto;
import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/20/16:18
 */
@Mapper
public interface DeviceConvert {
    DeviceConvert INSTANCE = Mappers.getMapper(DeviceConvert.class);

    DeviceDto convert(Device device);

    @Mappings({
            @Mapping(source = "region.regionName", target = "regionName"),
            @Mapping(source = "place.placeName", target = "placeName"),
            @Mapping(source = "device.ip", target = "ip"),
            @Mapping(source = "device.deviceName", target = "deviceName"),
            @Mapping(source = "device.createTime", target = "createTime")
    })
    DeviceDto convertDeviceDto(Device device,Region region, Place place);
}
