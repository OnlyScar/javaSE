package com.javaSE.multiplethread;

import com.javaSE.charactor.Hero;

public class TestThread {
    public static void main(String[] args) {

        Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;

        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;

        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;

        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;

        // 设计一个类KillThread 继承Thread，并且重写run方法
        // 启动线程办法： 实例化一个KillThread对象，并且调用其start方法
        KillThread killThread1 = new KillThread(gareen, teemo);
        killThread1.start();
        KillThread killThread2 = new KillThread(bh, leesin);
        killThread2.start();

        // 创建类Battle，实现Runnable接口
        // 启动的时候，首先创建一个Battle对象，然后再根据该battle对象创建一个线程对象，并启动
        Battle battle1 = new Battle(gareen, teemo);
        new Thread(battle1).start();

        Battle battle2 = new Battle(bh, leesin);
        new Thread(battle2).start();

        // 使用匿名类，继承Thread,重写run方法，直接在run方法中写业务代码
        // 匿名类的一个好处是可以很方便的访问外部的局部变量
        Thread t1 = new Thread() {
            public void run() {
                // 匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                // 但是在JDK7以后，就不是必须加final的了
                while (!teemo.isDead()) {
                    gareen.attackHero(teemo);
                }
            }
        };
        t1.start();

        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };
        t2.start();
    }
}
