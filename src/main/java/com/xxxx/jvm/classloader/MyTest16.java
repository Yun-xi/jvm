package com.xxxx.jvm.classloader;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 11:53
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private String path;

    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();        // 将系统类加载器作为当前类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);  // 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);

        byte[] data = this.loadClassDate(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassDate(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            this.classLoaderName = className.replace(".", "/");

            is = new FileInputStream(new File(path + classLoaderName + this.fileExtension));
            baos = new ByteArrayOutputStream();

            int ch = 0;

            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return data;
    }

    /**
     * loader1为loader2的父加载器，所以loader1会加载MyTest1，
     * loader2加载的时候，由于父委托机制交给loader1加载，loader1已经加载过，所以直接返回，不会走findClass方法
     *******************************************结果*************************************
     *
     * findClass invoked: com.xxxx.jvm.classloader.MyTest1
     * class loader name: loader1
     * class: 21685669
     * com.xxxx.jvm.classloader.MyTest1@7f31245a
     *
     * class: 21685669
     * com.xxxx.jvm.classloader.MyTest1@6d6f6e28
     *
     * findClass invoked: com.xxxx.jvm.classloader.MyTest1
     * class loader name: loader3
     * class: 856419764
     * com.xxxx.jvm.classloader.MyTest1@2503dbd3
     *
     ************************************************************************************
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    /*public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\classes/");

        Class<?> clazz = loader1.loadClass("com.xxxx.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        MyTest16 loader2 = new MyTest16(loader1, "loader1");
        loader2.setPath("D:\\classes/");

        Class<?> clazz2 = loader2.loadClass("com.xxxx.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz2.hashCode());
        Object object2 = clazz2.newInstance();
        System.out.println(object2);

        System.out.println();

        MyTest16 loader3 = new MyTest16("loader3");
        loader3.setPath("D:\\classes/");

        Class<?> clazz3 = loader3.loadClass("com.xxxx.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz3.hashCode());
        Object object3 = clazz3.newInstance();
        System.out.println(object3);

        System.out.println();
    }*/

    /**
     * 演示了类的卸载
     *
     * 添加了-XX:+TraceClassUnloading虚拟机参数
     *******************************************结果*************************************
     *
     * findClass invoked: com.xxxx.jvm.classloader.MyTest1
     * class loader name: loader1
     * class: 21685669
     * com.xxxx.jvm.classloader.MyTest1@7f31245a
     *
     * [Unloading class com.xxxx.jvm.classloader.MyTest1 0x0000000100061028]
     * findClass invoked: com.xxxx.jvm.classloader.MyTest1
     * class loader name: loader1
     * class: 1173230247
     * com.xxxx.jvm.classloader.MyTest1@330bedb4
     *
     ************************************************************************************
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\classes/");

        Class<?> clazz = loader1.loadClass("com.xxxx.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);

        System.out.println();

        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        loader1 = new MyTest16("loader1");
        loader1.setPath("D:\\classes/");

        clazz = loader1.loadClass("com.xxxx.jvm.classloader.MyTest1");
        System.out.println("class: " + clazz.hashCode());
        object = clazz.newInstance();
        System.out.println(object);

        System.out.println();
    }

}
