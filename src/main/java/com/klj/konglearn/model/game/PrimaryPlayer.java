package com.klj.konglearn.model.game;

/**
 * 初级玩家
 */
public class PrimaryPlayer extends Player{

    public PrimaryPlayer(String name) {
        super(name, 5);
    }

    @Override
    public void onBefore() {
        System.out.println("菜鸟也能弄死你！");
    }
}
