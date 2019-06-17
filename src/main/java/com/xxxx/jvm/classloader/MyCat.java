package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-17 16:29
 */
public class MyCat {

    public MyCat() {
        System.out.println("MyCat is loaded by:  " + this.getClass().getClassLoader());
    }
}
