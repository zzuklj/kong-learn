package com.klj.konglearn.demo.ocr;

import com.baidu.aip.ocr.AipOcr;
import com.klj.konglearn.properties.OcrBaiduProperties;
import org.json.JSONObject;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static com.klj.konglearn.tool.YamlProperties.readTiledProperties;

public class BaiduOcr {

    static AipOcr baiduAipiOcr;

    static {
        Properties properties = readTiledProperties();
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        //错误示例
        //TempProperties tempProperties = new Binder(source).bind("klj", Bindable.of(TempProperties.class)).get();

        Properties bindProperties = new Binder(source).bind("ocr.baidu", Bindable.of(Properties.class)).get();
        OcrBaiduProperties orcBaiduProperties = new Binder(new MapConfigurationPropertySource(bindProperties))
                .bind(ConfigurationPropertyName.EMPTY, Bindable.of(OcrBaiduProperties.class)).get();

        baiduAipiOcr = new AipOcr(orcBaiduProperties.getAppId(), orcBaiduProperties.getApiKey(), orcBaiduProperties.getSecretKey());

        // 可选：设置网络连接参数
        baiduAipiOcr.setConnectionTimeoutInMillis(2000);
        baiduAipiOcr.setSocketTimeoutInMillis(60000);

    }

    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        FileInputStream fileInputStream = new FileInputStream(
                new File(property, "src/main/resources/static/pic/school_choose.png"));
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);

        JSONObject res = baiduAipiOcr.basicGeneral(bytes, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }
}
