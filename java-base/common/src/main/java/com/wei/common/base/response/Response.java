package com.wei.common.base.response;


import lombok.Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.Writer;

/**
 * 标准返回对象
 *
 * @author weiwei
 */
@Data
public class Response<T> implements Serializable {


    public static String CODE_SUCCESS = "0";
    public static String CODE_FAILURE = "-1";


    /**
     * 响应结果 成功/失败
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private T data;

    public boolean isSuccess(){
        return this.code.equals(CODE_SUCCESS) ? true: false;
    }


    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {

    }

    /**
     * 内部工厂方法，缺省消息提示
     *
     * @param data
     * @return
     */
    public static final Response success(Object data) {
        return new Response(CODE_SUCCESS, "success", data);
    }

    /**
     * 内部工厂方法，完整成功返回
     *
     * @param message
     * @param data
     * @return
     */
    public static final Response success(String message, Object data) {
        return new Response(CODE_SUCCESS, message, data);
    }

    /**
     * 内部工厂方法，缺省消息体与数据体
     *
     * @return
     */
    public static final Response success() {
        return new Response(CODE_SUCCESS, null, null);
    }

    /**
     * 内部工厂方法，缺省数据体
     *
     * @param message
     * @return
     */
    public static final Response failure(String message) {
        return new Response(CODE_FAILURE, message, null);
    }

    /**
     * 内部工厂方法，完整错误消息体
     *
     * @param message
     * @param data
     * @param errorCode
     * @return
     */
    public static final Response failure(String message, Object data, String errorCode) {
        return new Response(errorCode, message, data);
    }

    /**
     * 内部工厂方法，缺省消息体
     *
     * @param data
     * @param errorCode
     * @return
     */
    public static final Response failure(Object data, String errorCode) {
        return new Response(errorCode, null, data);
    }



    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }


}
