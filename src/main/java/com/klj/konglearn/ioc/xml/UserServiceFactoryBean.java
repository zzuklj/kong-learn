package com.klj.konglearn.ioc.xml;

import com.klj.konglearn.ioc.AbstractUserService;
import org.springframework.beans.factory.FactoryBean;

public class UserServiceFactoryBean implements FactoryBean<AbstractUserService> {
    @Override
    public AbstractUserService getObject() throws Exception {
        return new XmlUserServiceFromFactoryBean();
    }

    @Override
    public Class<?> getObjectType() {
        return XmlUserServiceFromFactoryBean.class;
    }
}
