package com.wei.designpatterns.singletonpattern;

public class TestMain {
    public static void main(String[] args) {
        Utils utils1 = Utils.getInstance();
        Utils utils2 = Utils.getInstance();
        //查看对象地址
        System.out.println("utils1:"+System.identityHashCode(utils1));
        System.out.println("utils2:"+System.identityHashCode(utils2));

    }
}
