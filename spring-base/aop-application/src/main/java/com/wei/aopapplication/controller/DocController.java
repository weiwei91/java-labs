package com.wei.aopapplication.controller;

import com.wei.aopapplication.dto.CommonResp;
import com.wei.aopapplication.dto.DocQueryReq;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class DocController {


    @GetMapping("/list")
    public CommonResp list(@Valid DocQueryReq req) {
        return CommonResp.success("123");
    }

}
