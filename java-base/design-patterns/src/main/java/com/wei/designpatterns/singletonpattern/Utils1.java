package com.wei.designpatterns.singletonpattern;
/**
 * 线程安全
 * 饿汉式
 * 参考RunTime
 * */
public class Utils1 {
    private final static Utils1 utils = new Utils1();
    /**
     * 构造函数私有化
     * */
    private Utils1(){}

    static Utils1 getInstance(){
       return utils;
    }



}
