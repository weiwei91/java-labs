package com.wei.designpatterns.singletonpattern;

public class StaticTest {

    public static int a = 1;
    public static StaticTest1 t = new StaticTest1();
    public static int b;


    public static void main(String[] arg)
    {
        System.out.println(StaticTest.a);
        System.out.println(StaticTest.b);
    }

    /**
     * 实验静态变量初始化时机
     * 记住两点
     * 静态变量会按照声明的顺序先依次声明并设置为该类型的默认值，但不赋值为初始化的值。
     * 声明完毕后,再按声明的顺序依次设置为初始化的值，如果没有初始化的值就跳过
     * */
}
