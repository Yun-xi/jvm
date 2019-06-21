package com.xxxx.jvm.classloader;

/**
 * java -Djava.ext.dirs=./ com.xxxx.jvm.classloader.MyTest22
 * 将当前目录作为扩展类加载器加载的目录，得出
 * MyTest22 initializer
 * sun.misc.Launcher$AppClassLoader@73d16e93
 * sun.misc.Launcher$AppClassLoader@73d16e93
 *
 * 发现MyTest22并没有由扩展类加载器来加载，原因是因为扩展类加载器只会加载jar
 *
 * 先把MyTest1.class打成jar包 jar test.jar com/xxxx/jvm/classloader/MyTest1.class
 *
 * 再执行
 *
 */
public class MyTest22 {

    static {
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] args) {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest1.class.getClassLoader());
    }
}
