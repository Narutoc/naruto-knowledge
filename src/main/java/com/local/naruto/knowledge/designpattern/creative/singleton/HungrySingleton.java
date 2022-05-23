package com.local.naruto.knowledge.designpattern.creative.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {

    private static final HungrySingleton hunger = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return hunger;
    }

    public void hungerMethod() {

    }
}
