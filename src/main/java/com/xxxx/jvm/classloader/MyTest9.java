package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 10:56
 */
public class MyTest9 {

    static {
        System.out.println("MyTest9 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent {

    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {

    static int b = 4;

    static {
        System.out.println("Child static block");
    }
}
