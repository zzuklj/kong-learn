package com.klj.konglearn.config;

import com.klj.konglearn.properties.TempProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@EnableConfigurationProperties(TempProperties.class)
@Component
public class TempConfig {

}
