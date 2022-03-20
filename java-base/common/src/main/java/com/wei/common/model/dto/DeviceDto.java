package com.wei.common.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/20/16:20
 */
@Data
public class DeviceDto {
    private String ip;
    private String deviceName;
    private String placeName;
    private String regionName;
    private Date createTime;
}
