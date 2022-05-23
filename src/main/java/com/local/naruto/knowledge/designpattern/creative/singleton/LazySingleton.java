package com.local.naruto.knowledge.designpattern.creative.singleton;

/**
 * 懒汉模式
 * 优点：延迟加载（需要的时候才去加载）,适合单线程操作
 * 缺点： 线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
 */
public class LazySingleton {

    private static LazySingleton lazy = null;

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }

    public void lazyMethod() {

    }
}
