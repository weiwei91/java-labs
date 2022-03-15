package com.wei.httpclientselection.OkHttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OkHttpController {
    final OkHttpUtil okHttpUtil;

    public OkHttpController(OkHttpUtil okHttpUtil) {
        this.okHttpUtil = okHttpUtil;
    }

    @GetMapping("/okhttpForGet")
    public String okhttpForGet(String name) {
        Map map =new HashMap();
        map.put("name",name);
        return okHttpUtil.get("http://127.0.0.1:8001/echo",map);
    }
}
