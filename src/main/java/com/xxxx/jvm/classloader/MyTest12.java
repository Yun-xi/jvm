package com.xxxx.jvm.classloader;

/**
 * 调用ClassLoader类的loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化
 *
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 11:11
 */
public class MyTest12 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        Class<?> clazz = loader.loadClass("com.xxxx.jvm.classloader.CL");

        System.out.println(clazz);

        System.out.println("-----------------");

        clazz = Class.forName("com.xxxx.jvm.classloader.CL");

        System.out.println(clazz);
    }
}

class CL {

    static {
        System.out.println("Class CL");
    }
}
