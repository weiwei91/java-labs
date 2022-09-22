package com.wei.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 扩展通用 Mapper，支持数据批量插入,单只支持mysql
 * **/
public interface MyBaseMapper<T> extends BaseMapper<T> {
    /**
     * 批量插入 仅适用于mysql
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
}

