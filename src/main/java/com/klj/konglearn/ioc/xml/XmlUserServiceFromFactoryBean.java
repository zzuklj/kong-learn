package com.klj.konglearn.ioc.xml;

import com.klj.konglearn.ioc.AbstractUserService;

public class XmlUserServiceFromFactoryBean extends AbstractUserService {
    @Override
    public void hello() {
        System.out.println("i am from xml create by FactoryBean!");
    }
}
