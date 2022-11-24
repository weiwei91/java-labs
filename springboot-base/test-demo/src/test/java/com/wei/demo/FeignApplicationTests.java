package com.wei.demo;

import com.hikvision.pbg.nree.iwater.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = DemoTestApplication.class)
@Slf4j
class FeignApplicationTests {

    @Autowired
    private DateUtil dateUtil;

    @Test
    void testGet() {
        log.info(dateUtil.speak());
    }



}
