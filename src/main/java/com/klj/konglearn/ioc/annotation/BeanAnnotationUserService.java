package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.IUserService;

public class BeanAnnotationUserService extends IUserService {
    @Override
    public void hello() {
        System.out.println("i am from annotation @Bean!");
    }
}
