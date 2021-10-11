package com.klj.konglearn.tool;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class YamlProperties {

    private static final String CONFIG_NAME = "application.yml";

    public static void main(String[] args) {
        readProperties();

        Properties properties = readTiledProperties();
    }

    public static Properties readProperties() {
        String path = YamlProperties.class.getClassLoader().getResource(CONFIG_NAME).getPath();
        return readFromYaml(path);
    }

    public static Properties readTiledProperties() {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource(CONFIG_NAME));
        return factoryBean.getObject();
    }

    public static Properties readFromYaml(String yamlFilePath) {
        File file = new File(yamlFilePath);
        Yaml yaml = new Yaml();
        Properties properties = new Properties();
        try {
            properties = yaml.loadAs(new FileInputStream(file), Properties.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
