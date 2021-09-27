package com.klj.konglearn.create;

import com.klj.konglearn.ioc.annotation.ComponentUserService;
import com.klj.konglearn.ioc.annotation.MyAppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyAppConfigTest {

    @Test
    public void init(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAppConfig.class);
        ComponentUserService userService = applicationContext.getBean(ComponentUserService.class);
        userService.hello();
    }
}
