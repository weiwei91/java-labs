package com.wei.aopapplication.dto;

//todo 需要优化

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResp<T> {

    /**
     * 业务上的成功或失败
     */
    private boolean success = true;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回泛型数据，自定义类型
     */
    private T content;

    public static CommonResp success(String msg){
        return new CommonResp(true, msg,null);
    }
}

