package com.local.naruto.knowledge.designpattern.creative.singleton;

/**
 * 双重校验
 * 优点：线程安全，支持延时加载，调用效率高
 * 缺点：写法复杂，不简洁
 */
public class DoubleCheckSingleton {

    private static volatile DoubleCheckSingleton doubleCheck = null;

    private DoubleCheckSingleton() {

    }

    public static DoubleCheckSingleton getInstance() {
        if (doubleCheck == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (doubleCheck == null) {
                    doubleCheck = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheck;
    }

    public void doubleCheckMethod() {

    }
}
