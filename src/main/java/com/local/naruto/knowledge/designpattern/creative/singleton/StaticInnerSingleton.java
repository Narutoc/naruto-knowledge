package com.local.naruto.knowledge.designpattern.creative.singleton;

/**
 * 静态内部类
 * 优点：延迟加载，线程安全（java中class加载时互斥的），也减少了内存消耗，推荐使用内部类方式。
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton() {

    }

    private static class InnerSingleton {

        private static final StaticInnerSingleton staticInner = new StaticInnerSingleton();
    }

    public static StaticInnerSingleton getInstance() {
        return InnerSingleton.staticInner;
    }

    public void staticMethod() {

    }
}
