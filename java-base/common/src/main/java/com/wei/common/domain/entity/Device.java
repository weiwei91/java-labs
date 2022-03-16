package com.wei.common.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "device")
@Builder
public class Device {
    //设备相关
    private String indexCode;
    private String ip;
    private String port;
    private String name;
    private String capability;
    private Date createTime;
    //乐观锁版本号
    private String version;

}
