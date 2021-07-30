package com.klj.konglearn.model.game;

public class Boss extends Role {

    //血量
    private int xueLiang;

    public Boss(String name, int xueLiang) {
        super(name);
        this.xueLiang = xueLiang;
    }

    public int getXueLiang() {
        return xueLiang;
    }

    public void setXueLiang(int xueLiang) {
        this.xueLiang = xueLiang;
    }

    public void subXueLiang(int subXueLiang) {
        this.xueLiang = this.xueLiang - subXueLiang;
    }
}
