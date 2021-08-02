package com.klj.ioc.extension;

import com.klj.ioc.IUserService;

public class ExtensionBeanAnnotationUserService extends IUserService {
    @Override
    public void hello() {
        System.out.println("i am from extension annotation @Bean!");
    }
}
