package com.klj.konglearn.reactor;

import com.klj.konglearn.model.game.Boss;
import com.klj.konglearn.model.game.PrimaryPlayer;
import com.klj.konglearn.model.game.SeniorPlayer;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

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
        Flux<Integer> integerFlux = Flux.just(2, 5, 3, 7, 4, 1);
        integerFlux.subscribe(System.out::println);
    }
}
