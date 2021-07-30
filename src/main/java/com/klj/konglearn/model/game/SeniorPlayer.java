package com.klj.konglearn.model.game;

/**
 * 高级玩家
 */
public class SeniorPlayer extends Player{
    public SeniorPlayer(String name) {
        super(name, 10);
    }

    @Override
    public void onBefore() {
        System.out.println("弄死你跟切白菜一样！");
    }
}
