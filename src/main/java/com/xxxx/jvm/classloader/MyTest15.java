package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 11:50
 */
public class MyTest15 {

    public static void main(String[] args) {
        String[] strings = new String[2];
        System.out.println(strings.getClass().getClassLoader());

        System.out.println("----------------");

        MyTest15[] myTest15s = new MyTest15[2];
        System.out.println(myTest15s.getClass().getClassLoader());

        System.out.println("----------------");

        int[] ints = new int[2];
        System.out.println(ints.getClass().getClassLoader());

        /**
         * null
         * ----------------
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * ----------------
         * null
         */
    }
}
