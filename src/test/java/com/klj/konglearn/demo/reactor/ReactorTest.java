package com.klj.konglearn.demo.reactor;

import com.klj.konglearn.model.game.Boss;
import com.klj.konglearn.model.game.PrimaryPlayer;
import com.klj.konglearn.model.game.SeniorPlayer;
import org.junit.jupiter.api.Test;

public class ReactorTest {

    @Test
    public void killBoss(){
        Boss boss = new Boss("monster", 10000);
        PrimaryPlayer tony = new PrimaryPlayer("tony");
        SeniorPlayer tom = new SeniorPlayer("tom");
        tony.onKill(boss);
        tom.onKill(boss);
    }

    @Test
    public void FluxMonoTest(){
    }
}
