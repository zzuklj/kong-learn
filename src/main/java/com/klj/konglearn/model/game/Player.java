package com.klj.konglearn.model.game;

import java.util.Random;

public abstract class Player extends Role implements KillBossCallBack{

    //砍一刀的掉血量
    private int perKill;

    public Player(String name, int perKill) {
        super(name);
        this.perKill = perKill;
    }

    private Random random = new Random();

    /**
     * 打boss前放狠话
     */
    abstract void onBefore();

    @Override
    public void onKill(Boss boss) {
        int nextInt = random.nextInt(20);
        onBefore();
        for(int i = 0; i < nextInt; i++){
            boss.subXueLiang(getPerKill());
            System.out.println(boss.getName() + " 被 " + this.getName() +  " 砍掉 " + getPerKill() + " 血量，还剩 " + boss.getXueLiang() + " 血量！");
        }
    }

    public int getPerKill() {
        return perKill;
    }

    public void setPerKill(int perKill) {
        this.perKill = perKill;
    }
}
