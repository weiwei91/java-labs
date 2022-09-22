package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.mybatisplus.mapper.RegionMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/region")
public class RegionController {
    @Resource
    RegionMapper regionMapper;

    @GetMapping("/getRegionById")
    @ResponseBody
    public Response getRegionById(String id) throws InterruptedException {
        //000002cfeccb6511c8f0785ab9c49d6b
        Thread.sleep(100);
        return Response.success(regionMapper.selectById(id));
    }
}
