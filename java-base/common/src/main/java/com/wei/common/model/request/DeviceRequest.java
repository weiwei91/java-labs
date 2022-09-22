package com.wei.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
public class DeviceRequest {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Add{
        private String ip;
        private String deviceName;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class getList{
        private String ip;
        private String deviceName;
    }

}
