package com.wei.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.VARCHAR;

@Data
@TableName(value = "device")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @TableId(type= IdType.ASSIGN_UUID)
    @TableField("index_code")
    private String indexCode;
    private String ip;
    private String port;
    @TableField(value = "device_name",jdbcType = VARCHAR )
    private String deviceName;
    private String capability;
    @TableField(value = "create_time",fill = FieldFill.INSERT,jdbcType = TIMESTAMP)
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE,jdbcType = TIMESTAMP)
    private Date updateTime;
    //乐观锁版本号
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
