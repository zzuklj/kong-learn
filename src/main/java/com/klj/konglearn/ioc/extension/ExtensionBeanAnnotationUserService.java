package com.klj.konglearn.ioc.extension;


import com.klj.konglearn.ioc.AbstractUserService;

public class ExtensionBeanAnnotationUserService extends AbstractUserService {
    @Override
    public void hello() {
        System.out.println("i am from extension annotation @Bean!");
    }
}
