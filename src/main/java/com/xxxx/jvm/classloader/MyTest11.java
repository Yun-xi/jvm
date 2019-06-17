package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 11:06
 */
public class MyTest11 {

    public static void main(String[] args) {
        System.out.println(Child3.a);
        System.out.println("-----------------");
        Child3.doSomething();

        /**
         * Parent3 static block
         * 3
         * -----------------
         * do something
         */
    }
}

class Parent3 {

    static int a = 3;

    static {
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3{

    static {
        System.out.println("Child3 static block");
    }
}
