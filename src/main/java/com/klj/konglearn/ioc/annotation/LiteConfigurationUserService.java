package com.klj.konglearn.ioc.annotation;


import com.klj.konglearn.ioc.extension.BeanUser1;
import com.klj.konglearn.ioc.extension.BeanUser2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = true)
//@Component
public class LiteConfigurationUserService {

    @Bean
    public BeanUser1 beanUser1(){
        return new BeanUser1();
    }

    @Bean
    @ConditionalOnMissingBean()
    public BeanUser2 beanUser2(){
        BeanUser2 beanUser2 = new BeanUser2();
        beanUser2.setBeanUser1(beanUser1());
        return beanUser2;
    }

}
