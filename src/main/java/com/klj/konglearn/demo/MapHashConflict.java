package com.klj.konglearn.demo;

import com.klj.konglearn.entity.UserOverride;

import java.util.HashMap;
import java.util.stream.IntStream;

public class MapHashConflict {

    private static void conflictMap(){
        HashMap<UserOverride, Integer> hashMap = new HashMap<>();
        IntStream.range(0,20).forEach(i -> {
            UserOverride klj = new UserOverride(i, "klj");
            hashMap.put(klj, i);
        });
        System.out.println(hashMap.size());
    }

    public static void main(String[] args) {
        conflictMap();
    }
}
