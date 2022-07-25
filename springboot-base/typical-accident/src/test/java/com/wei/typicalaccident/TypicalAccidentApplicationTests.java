package com.wei.typicalaccident;

import com.wei.common.model.entity.Device;
import com.wei.typicalaccident.mapper.DeviceMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class TypicalAccidentApplicationTests {

    @Resource
    DeviceMapper deviceMapper;

    @Test
    void contextLoads() {
        List<Device> deviceList =deviceMapper.selectList(null);
        log.info("1");
    }

}
