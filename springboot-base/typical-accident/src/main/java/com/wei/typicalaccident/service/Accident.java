package com.wei.typicalaccident.service;

import com.wei.common.model.entity.Device;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/05/03/18:37
 */
public interface Accident {
    int addError(Device device);
    int addWright(Device device);
}
