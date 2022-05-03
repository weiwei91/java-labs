package com.wei.typicalaccident.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wei.common.model.entity.Device;
import com.wei.typicalaccident.mapper.DeviceMapper;
import com.wei.typicalaccident.service.Accident;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.locks.Lock;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/05/03/18:39
 */
@Slf4j
public class AccidentImpl implements Accident {
    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 幂等性问题
     * 由于事务和分布式锁使用有误导致接口产生幂等性问题
     * 条件1：数据库中只能存在一个ip相同的设备
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int addError(Device device) {

        Lock lock = redissonClient.getLock("lock");
        lock.lock();
        QueryWrapper<Device> queryWrapper =new QueryWrapper<>();
        queryWrapper.select("*").eq("ip",device.getIp());
        Long countDevice = deviceMapper.selectCount(queryWrapper);
        try {
            if (countDevice>0){
                log.info("当前设备ip在库中已经存在:{}", JSONObject.toJSON(device));
                return 0;
            }else {
                deviceMapper.insert(device);
                return 1;
            }
        }catch (Exception e){
            log.error("设备入库异常",e);
        }finally {
            lock.unlock();
        }
        return 0;
    }

    /**
     * 既然已经有分布式锁就把事务去掉，
     * 不然可能会出现事务没有提交导致分布式锁被释放
     * */
    @Override
    public int addWright(Device device) {
        Lock lock = redissonClient.getLock("lock");
        lock.lock();
        QueryWrapper<Device> queryWrapper =new QueryWrapper<>();
        queryWrapper.select("*").eq("ip",device.getIp());
        Long countDevice = deviceMapper.selectCount(queryWrapper);
        try {
            if (countDevice>0){
                log.info("当前设备ip在库中已经存在:{}", JSONObject.toJSON(device));
                return 0;
            }else {
                deviceMapper.insert(device);
                return 1;
            }
        }catch (Exception e){
            log.error("设备入库异常",e);
        }finally {
            lock.unlock();
        }
        return 0;
    }
}
