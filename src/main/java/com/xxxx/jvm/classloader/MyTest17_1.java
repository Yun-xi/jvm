package com.xxxx.jvm.classloader;

/**
 * 关于命名空间的重要说明
 *
 * 1.子加载器所加载的类能够访问父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 */
public class MyTest17_1 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\classes/");

        Class<?> clazz = loader1.loadClass("com.xxxx.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();
    }
}
