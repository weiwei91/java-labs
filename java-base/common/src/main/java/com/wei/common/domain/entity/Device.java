package com.wei.common.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "device")
@Builder
public class Device {
    //设备相关
    /***
     *     设置id生成策略
     *     AUTO(0),//自增
     *     NONE(1),//未设置主键
     *     INPUT(2),//手动输入,需要自己配置id
     *     ID_WORKER(3),//默认的全局唯一id
     *     UUID(4),//全球唯一id
     *     ID_WORKER_STR(5);//ID_WORKER字符串表示
     * **/
    @TableId(type= IdType.UUID)
    private String indexCode;
    private String ip;
    private String port;
    private String name;
    private String capability;
    private Date createTime;
    //乐观锁版本号
    private String version;

}
