package com.klj.konglearn.jvm.agent;

import java.util.ArrayList;

/**
 * @author 0
 */
public class HeapTest {
    Byte[] b = new Byte[1024 * 100];//100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList list = new ArrayList();
        while(true){
            list.add(new HeapTest());
            Thread.sleep(10);
        }
    }


}
