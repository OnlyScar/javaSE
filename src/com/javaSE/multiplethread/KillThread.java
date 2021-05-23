package com.javaSE.multiplethread;

import com.javaSE.charactor.Hero;

/**
 * 功能描述
 *
 * @author luckey
 * @date 2021/5/23 16:51
 */
public class KillThread extends Thread {

    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2) {
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run() {
        while (!h2.isDead()) {
            h1.attackHero(h2);
        }
    }
}
