package com.wei.httpclientselection.retrofit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RetrofitController {
    @Autowired
    HttpApi httpApi;

    @GetMapping("/RetrofitForGet")
    public String RetrofitForGet(String name) {
        Map map =new HashMap();
        map.put("name",name);
        return httpApi.getPerson(name);
    }
}
