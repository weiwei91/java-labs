package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.mybatisplus.mapper.RegionMapper;
import com.wei.mybatisplus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Response getRegionById(String id) {
        //000002cfeccb6511c8f0785ab9c49d6b
        return Response.success(regionMapper.selectById(id));
    }
}
