package com.wei.designpatterns.singletonpattern;
/**
 * 非线程安全
 * 懒加载[原因是静态方法在第一次被加载的时候是不会被执行的!!]
 * */
public class Utils {
    private static Utils utils;
    /**
     * 构造函数私有化
     * */
    private Utils(){}

    static Utils getInstance(){
       if (utils == null){
           utils = new Utils();
       }
       return utils;
    }



}
