package com.klj.konglearn.ioc.extension;

import com.klj.konglearn.ioc.AbstractUserService;

public class BeanUser2 extends AbstractUserService {

    private BeanUser1 beanUser1;

    @Override
    public void hello() {
        System.out.println("i am bean userService2");
    }

    public BeanUser1 getBeanUser1() {
        return beanUser1;
    }

    public void setBeanUser1(BeanUser1 beanUser1) {
        this.beanUser1 = beanUser1;
    }
}
