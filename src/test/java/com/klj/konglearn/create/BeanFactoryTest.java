package com.klj.konglearn.create;

import com.klj.konglearn.ioc.xml.XmlUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanFactoryTest {

    @Test
    public void fromBeanFactory(){
        //创建容器
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        //加载xml文件中的bean定义
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("bean.xml"));
        XmlUserService bean = listableBeanFactory.getBean(XmlUserService.class);
        bean.hello();
    }
}
