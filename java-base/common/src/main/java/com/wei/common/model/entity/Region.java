package com.wei.common.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static org.apache.ibatis.type.JdbcType.TIMESTAMP;
import static org.apache.ibatis.type.JdbcType.VARCHAR;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/19/11:00
 */
@Data
@TableName(value = "region")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    //区域相关
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
    private String indexCode;
    @TableField(value = "region_name",jdbcType = VARCHAR )
    private String regionName;

    @TableField(value = "create_time",fill = FieldFill.INSERT,jdbcType = TIMESTAMP)
    private Date createTime;
    @TableField(value = "update_time",fill = FieldFill.UPDATE,jdbcType = TIMESTAMP)
    private Date updateTime;
    //乐观锁版本号
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

}
