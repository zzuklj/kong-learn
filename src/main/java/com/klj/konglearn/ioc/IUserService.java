package com.klj.konglearn.ioc;

public abstract class IUserService {
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
