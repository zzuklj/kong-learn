package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.AbstractUserService;

public class BeanAnnotationUserService extends AbstractUserService {
    @Override
    public void hello() {
        System.out.println("i am from annotation @Bean under @Configuration!");
    }
}
