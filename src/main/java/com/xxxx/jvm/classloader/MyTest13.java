package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 11:15
 */
public class MyTest13 {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        System.out.println(loader);

        while (null != loader){
            loader = loader.getParent();

            System.out.println(loader);
        }
    }
}
