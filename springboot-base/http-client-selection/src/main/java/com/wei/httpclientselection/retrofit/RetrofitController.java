package com.wei.httpclientselection.retrofit;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RetrofitController {
    @Autowired
    HttpApi httpApi;

    @Autowired
    MybatisPlusClient mybatisPlusClient;


    @GetMapping("/RetrofitForGet")
    public String RetrofitForGet(String name) {
        Map map =new HashMap();
        map.put("name",name);
        Response<Place> response =  mybatisPlusClient.getPlaceById("200");

        return httpApi.getPerson(name);
    }
}
