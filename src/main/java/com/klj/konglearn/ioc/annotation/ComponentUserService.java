package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.AbstractUserService;
import org.springframework.stereotype.Component;

@Component
//@Service
//@Controller
//@Repository
public class ComponentUserService extends AbstractUserService {
    @Override
    public void hello(){
        System.out.println("i am from annotation @Component!");
    }

}
