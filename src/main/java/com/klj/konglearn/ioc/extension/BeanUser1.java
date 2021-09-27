package com.klj.konglearn.ioc.extension;

import com.klj.konglearn.ioc.AbstractUserService;

public class BeanUser1 extends AbstractUserService {
    @Override
    public void hello() {
        System.out.println("i am bean userService1");
    }
}
