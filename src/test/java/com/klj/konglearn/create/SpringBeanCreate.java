package com.klj.konglearn.create;

import com.klj.ioc.annotation.BeanAnnotationUserService;
import com.klj.ioc.annotation.ComponentUserService;
import com.klj.ioc.annotation.ConfigurationUserService;
import com.klj.ioc.extension.ExtensionBeanAnnotationUserService;
import com.klj.ioc.xml.XmlUserService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanCreate {


    String xmlPath = "bean.xml";
    @Test
    public void createBeanFromXml(){
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext(xmlPath);
        XmlUserService xmlUserService = (XmlUserService) xmlApplicationContext.getBean("xmlUserService");
        xmlUserService.hello();
    }

    String packagePath = "com.klj.ioc.annotation";
    @Test
    public void createBeanFromComponent(){
        AnnotationConfigApplicationContext AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(packagePath);
        ComponentUserService componentUserService = (ComponentUserService) AnnotationConfigApplicationContext.getBean("componentUserService");
        componentUserService.hello();
    }

    @Test
    public void createBeanFromBeanAnnotation(){
        AnnotationConfigApplicationContext AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(packagePath);
        BeanAnnotationUserService beanAnnotationUserService = (BeanAnnotationUserService) AnnotationConfigApplicationContext.getBean("beanAnnotationUserService");
        beanAnnotationUserService.hello();

        ExtensionBeanAnnotationUserService extensionBeanAnnotationUserService = (ExtensionBeanAnnotationUserService) AnnotationConfigApplicationContext.getBean("extensionBeanAnnotationUserService");
        extensionBeanAnnotationUserService.hello();
    }
}
