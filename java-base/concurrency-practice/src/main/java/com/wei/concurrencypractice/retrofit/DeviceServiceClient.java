package com.wei.concurrencypractice.retrofit;

import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.entity.Place;
import com.wei.common.model.entity.Region;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Description:
 * @Auther: weiwei
 * @Date: 2022/03/19/16:03
 */
@RetrofitClient(baseUrl = "http://127.0.0.1:89")
public interface DeviceServiceClient {
    @GET("device/getDeviceById")
    Response<Device> getDeviceById(@Query("id") String id);

    @GET("place/getPlaceById")
    Response<Place> getPlaceById(@Query("id") String id);

    @GET("region/getRegionById")
    Response<Region> getRegionById(@Query("id") String id);

}
