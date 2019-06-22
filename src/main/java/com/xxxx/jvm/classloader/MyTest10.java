package com.xxxx.jvm.classloader;

/**
 * @author xieyaqi
 * @mail 987159036@qq.com
 * @date 2019-05-15 10:59
 */
public class MyTest10 {

    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {

        Parent2 parent2;

        System.out.println("----------------");

        parent2 = new Parent2();

        System.out.println("----------------");

        System.out.println(parent2.a);

        System.out.println("----------------");

        System.out.println(Child2.b);

        /**
         * MyTest10 static block
         * ----------------
         * Parent2 static block
         * ----------------
         * 3
         * ----------------
         * Child2 static block
         * 4
         */
    }
}

class Parent2 {

    static int a = 3;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {

    static int b = 4;

    static {
        System.out.println("Child2 static block");
    }
}
