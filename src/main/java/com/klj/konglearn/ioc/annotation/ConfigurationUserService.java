package com.klj.ioc.annotation;

import com.klj.ioc.IUserService;
import com.klj.ioc.extension.ExtensionBeanAnnotationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationUserService extends IUserService {

    @Override
    public void hello() {
        System.out.println("i am from annotation @Configuration!");
    }

    @Bean
    public BeanAnnotationUserService beanAnnotationUserService(){
        return new BeanAnnotationUserService();
    }

    @Bean
    public ExtensionBeanAnnotationUserService extensionBeanAnnotationUserService(){
        return new ExtensionBeanAnnotationUserService();
    }

}
