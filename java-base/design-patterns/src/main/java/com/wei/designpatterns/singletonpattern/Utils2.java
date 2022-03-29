package com.wei.designpatterns.singletonpattern;
/**
 * 线程安全
 * 懒汉式
 * 参考RunTime
 * */
public class Utils2 {
    /**
     * 构造函数私有化
     **/
    private Utils2(){}

    private static class Utils2Instance{
        private static final Utils2 utils2 = new Utils2();
    }

    static Utils2 getInstance(){
       return Utils2Instance.utils2;
    }



}
