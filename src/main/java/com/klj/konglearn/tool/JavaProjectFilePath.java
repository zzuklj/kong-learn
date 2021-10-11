package com.klj.konglearn.tool;

public class JavaProjectFilePath {

    public static void main(String[] args) {

        Class<JavaProjectFilePath> javaProjectFilePathClass = JavaProjectFilePath.class;

        // 获取当前类所在路径：绝对路径
        System.out.println(javaProjectFilePathClass.getResource("").getPath());

        // 获取项目文件编译路径
        System.out.println(javaProjectFilePathClass.getResource("/").getPath());

        //以上两种，获取的都是项目编译后的out或者target路径；

        //获取项目根路径
        System.out.println(System.getProperty("user.dir"));


    }

}
