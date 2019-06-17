package com.xxxx.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-06-17 17:11
 */
public class MyTest19 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();

        System.out.println(aesKeyGenerator.getClass().getClassLoader());
        System.out.println(MyTest19.class.getClassLoader());
    }
}
