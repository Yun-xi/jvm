package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-26 16:06
 */
public class MyTest25 implements Runnable{

    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(classLoader);

        System.out.println("Class: " + classLoader.getClass());
        System.out.println("Parent: " + classLoader.getParent().getClass());
    }

    public static void main(String[] args) {
        new MyTest25();
    }

    /**
     * Class: class sun.misc.Launcher$AppClassLoader
     * Parent: class sun.misc.Launcher$ExtClassLoader
     */
}
