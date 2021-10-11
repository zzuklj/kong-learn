package com.klj.konglearn.ftl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.klj.konglearn.tool.YamlProperties.readFromYaml;

public class FtlConfiguration {

    private static final String TEMPLATE_PATH = "src/main/java/com/klj/konglearn/ftl/template";
    private static final String CLASS_PATH = "src/main/java/com/klj/konglearn/ftl/out";
    private static final String TEMPLATE_DATA_PATH = "D:\\gittest\\kong-learn\\src\\main\\java\\com\\klj\\konglearn\\ftl\\template\\template-data.yml";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));

            // step3 加载数据模型
            Properties properties = readFromYaml(TEMPLATE_DATA_PATH);

            // step4 加载模版文件
            Template template = configuration.getTemplate("hello.ftl");

            // step5 生成数据
            File docFile = new File(CLASS_PATH + "\\" + "hello.yml");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));

            // step6 输出文件
            template.process(properties, out);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
