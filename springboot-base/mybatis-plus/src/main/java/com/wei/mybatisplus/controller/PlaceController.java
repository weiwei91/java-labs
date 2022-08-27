package com.wei.mybatisplus.controller;

import com.wei.common.base.response.Response;
import com.wei.mybatisplus.mapper.PlaceMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/place")
public class PlaceController {
    @Resource
    PlaceMapper placeMapper;

    @GetMapping("/getPlaceById")
    @ResponseBody
    public Response getPlaceById(String id) throws InterruptedException {
        //000002cfeccb6511c8f0785ab9c49d6b
        Thread.sleep(100);
        return Response.success(placeMapper.selectById(id));
    }
}
