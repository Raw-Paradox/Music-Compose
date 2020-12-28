package com.cyb.musicplayer;

/**
 * Created by Paradoox on 2020/12/24.
 */
public class Example {
    Example(String str) {
        this.str = str;
    }

    String str;

    public static void main(String[] args) throws InterruptedException {
        String string = "origin";
        System.out.println(string.hashCode());
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(string.hashCode());
        }).start();
//        Thread.sleep(2000);
        System.out.println("main thread deaded");
        System.out.println(string.hashCode());
    }
}
