package com.klj.konglearn.ioc.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 可以在spring的bean创建之前，修改bean的定义属性。
 * Spring允许BeanFactoryPostProcessor在容器实例化任何其它bean之前读取配置元数据，并可以根据需要进行修改，
 * 例如可以把bean的scope从singleton改为prototype，也可以把property的值给修改掉。
 * 可以同时配置多个BeanFactoryPostProcessor，并通过设置'order'属性来控制各个BeanFactoryPostProcessor的执行次序。
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("klj <== 调用自定义BeanFactoryPostProcessor ====> " + this.getClass().getName());
        BeanDefinition bd = beanFactory.getBeanDefinition("xmlUserService");
        MutablePropertyValues pv = bd.getPropertyValues();
        if(pv.contains("name")){
            pv.addPropertyValue("name", "xml-klj-update-name");
        }
    }
}
