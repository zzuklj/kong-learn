package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.IUserService;
import com.klj.konglearn.ioc.extension.ExtensionBeanAnnotationUserService;
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
