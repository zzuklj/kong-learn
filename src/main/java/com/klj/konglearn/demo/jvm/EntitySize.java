package com.klj.konglearn.demo.jvm;


public class EntitySize {

    /**
     * 参考链接：https://blog.csdn.net/iter_zc/article/details/41822719
     * java.lang.instrument.Instrumentation.getObjectSize()
     * 这种方法得到的是Shallow Size，
     * 即遇到引用时，只计算引用的长度，不计算所引用的对象的实际大小。
     * 如果要计算所引用对象的实际大小，可以通过递归的方式去计算
     *
     * java.lang.instrument.Instrumentation的实例必须通过指定javaagent的方式才能获得，具体的步骤如下：
     * 1. 定义一个类，提供一个premain方法: public static void premain(String agentArgs, Instrumentation instP)
     * 2. 创建META-INF/MANIFEST.MF文件，内容是指定PreMain的类是哪个： Premain-Class: sizeof.ObjectShallowSize
     * 3. 把这个类打成jar，然后用java -javaagent XXXX.jar XXX.main的方式执行
     * @param o
     */
    public static void InstrumentationCalculate(Object o){


    }

    public static void main(String[] args) throws IllegalAccessException {
        final ClassIntrospector ci = new ClassIntrospector();

        ObjectInfo res;

        res = ci.introspect( new byte[64] );
        System.out.println( res.getDeepSize() );
    }

    private static class ObjectA {
        String str;  // 4
        int i1; // 4
        byte b1; // 1
        char c; // 1
        byte[] b2; // 1
        int i2;	 // 4
        ObjectB obj; //4
        byte b3;  // 1
    }

    private static class ObjectB {

    }
}
