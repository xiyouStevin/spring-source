package com.xiyou.spring.bean;

import com.xiyou.spring.annotation.MyAnnotation;
import com.xiyou.spring.annotation.MyClassAnnotation;

import java.io.Serializable;

/**
 * @author: Steven
 * @create: 2023-12-20 17:21
 * @Description:
 */
@MyClassAnnotation
public class MyBean extends MyAbstract implements Serializable {

    public String key;


    public String value;

    @MyAnnotation
    public static void myMethod1(){
        //方法1实现
    }

    @MyAnnotation
    public String myMethod2(){
        return "Hello World";
    }

    @MyAnnotation
    public void myMethod3(){
        //方法3的视线
    }

    @MyAnnotation
    public  static class MyInnerClass{
        //内部类的定义
    }

    @MyAnnotation
    public String getName(){
        return "hello";
    }
}
