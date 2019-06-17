package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-17 16:30
 */
public class MySample {

    public MySample() {
        System.out.println("MySample is loaded by: " + this.getClass().getClassLoader());

        new MyCat();
    }
}
