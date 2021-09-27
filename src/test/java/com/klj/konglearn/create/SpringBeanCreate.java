package com.klj.konglearn.create;


import com.klj.konglearn.ioc.annotation.BeanAnnotationUserService;
import com.klj.konglearn.ioc.annotation.ComponentUserService;
import com.klj.konglearn.ioc.annotation.LiteConfigurationUserService;
import com.klj.konglearn.ioc.annotation.SimpleUserService;
import com.klj.konglearn.ioc.extension.BeanUser1;
import com.klj.konglearn.ioc.extension.ExtensionBeanAnnotationUserService;
import com.klj.konglearn.ioc.xml.XmlUserService;
import com.klj.konglearn.ioc.xml.XmlUserServiceFromFactoryBean;
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

    @Test
    public void createBeanFromXmlByFactoryBean(){
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext(xmlPath);
        XmlUserServiceFromFactoryBean xmlUserServiceFromFactoryBean = (XmlUserServiceFromFactoryBean) xmlApplicationContext.getBean("userServiceFactoryBean");
        xmlUserServiceFromFactoryBean.hello();
    }

    String packagePath = "com.klj.konglearn.ioc";
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

    @Test
    public void createBeanFromFullLiteConfigure(){
        AnnotationConfigApplicationContext AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(LiteConfigurationUserService.class);

        BeanUser1 beanUser1 = (BeanUser1) AnnotationConfigApplicationContext.getBean("beanUser1");
        beanUser1.hello();

//        BeanUser2 beanUser2 = (BeanUser2) AnnotationConfigApplicationContext.getBean("beanUser2");
//        beanUser2.getBeanUser1().hello();
//        beanUser2.hello();
    }

    @Test
    public void createBeanByMyBeanDefinitionRegistryPostProcessor(){
        AnnotationConfigApplicationContext AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext(packagePath);
        SimpleUserService simpleUserService = (SimpleUserService) AnnotationConfigApplicationContext.getBean("simpleUserService");
        simpleUserService.hello();
    }
}
