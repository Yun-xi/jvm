package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-17 16:46
 */
public class MyTest17 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");

        Class<?> clazz = loader1.loadClass("com.xxxx.jvm.classloader.MySample");
        System.out.println("class: " + clazz.hashCode());

        Object object = clazz.newInstance();
    }
}
