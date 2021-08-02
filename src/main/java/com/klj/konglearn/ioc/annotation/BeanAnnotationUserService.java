package com.klj.ioc.annotation;

import com.klj.ioc.IUserService;

public class BeanAnnotationUserService extends IUserService {
    @Override
    public void hello() {
        System.out.println("i am from annotation @Bean!");
    }
}
