package com.wei.feign.client;

import com.wei.common.base.response.Response;
import com.wei.common.model.entity.Device;
import com.wei.common.model.request.DeviceRequest;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface DeviceServiceClient01 {
    @RequestLine("GET /device/getDeviceById?id={id}")
    Response<Device> getDeviceById(@Param("id") String id);

    @RequestLine("POST /device/postAdd")
    @Headers("Content-Type: application/json")
    DeviceRequest postAdd(DeviceRequest.Add request);
}
