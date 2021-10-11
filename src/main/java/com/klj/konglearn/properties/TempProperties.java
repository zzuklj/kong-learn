package com.klj.konglearn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("klj")
public class TempProperties {
    private String p1;
    private String p2;

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
