package com.klj.ioc.annotation;

import com.klj.ioc.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
//@Service
//@Controller
//@Repository
public class ComponentUserService extends IUserService {

    public void hello(){
        System.out.println("i am from annotation @Component!");
    }

}
