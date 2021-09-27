package com.klj.konglearn.ioc;

import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractUserService {
    private Integer id;

    private String name;

    protected abstract void hello();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
