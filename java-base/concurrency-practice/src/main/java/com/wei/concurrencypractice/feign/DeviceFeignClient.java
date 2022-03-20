package com.wei.concurrencypractice.feign;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * todo 引入feign有点问题
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/19/16:03
 */
@FeignClient(name = "mybatisplus-provider")
public interface DeviceFeignClient {
    @GetMapping("/device/getDeviceById")
    Response<Device> getDeviceById(@Query("id") String id);

    @GetMapping("/place/getPlaceById")
    Response<Place> getPlaceById(@Query("id") String id);

    @GetMapping("/region/getRegionById")
    Response<Region> getRegionById(@Query("id") String id);

}
