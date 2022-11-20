package com.wei.mybatisplus.controller;

import com.wei.common.model.entity.Device;
import com.wei.common.service.DeviceService;
import com.wei.mybatisplus.MybatisPlusApplicationTests;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@AutoConfigureMockMvc
public class DeviceControllerTest extends MybatisPlusApplicationTests {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private DeviceService deviceService;

    @Test
    public void testGet() throws Exception {
        // Mock UserService 的 get 方法
        Mockito.when(deviceService.getById("weiwei")).thenReturn(
                Device.builder().ip("10.12.13.10").indexCode("weiwei").deviceName("weiwei").build());

        // 查询设备
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/device/getDeviceById?id=weiwei"));

        // 校验响应状态码
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()); // 响应状态码 200

        //逐个字段匹配
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("data.indexCode", IsEqual.equalTo("weiwei")));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("data.ip", IsEqual.equalTo("10.12.13.10")));
        resultActions.andExpect(MockMvcResultMatchers.jsonPath("data.deviceName", IsEqual.equalTo("weiwei")));
    }

}
