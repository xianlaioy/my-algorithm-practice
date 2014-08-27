package org.yousharp.designpattern.creational.singleton;

/**
 * 懒汉式单例：仅在需要时才创建单例
 *
 * 使用synchronized将接口方法getInstance()同步，可以用于多线程环境。
 *
 * 但是synchronized对性能影响较大，而且当线程访问方法时，无论实例是否
 * 已经创建，都需要先同步方法，才能访问。应该仅在实例没有被创建时，同步访问，
 * 否则直接返回实例.
 *
 * @see org.yousharp.designpattern.creational.singleton.DoubleCheckSingleton
 *
 * @author: lingguo
 * @time: 2014/8/13 21:32
 */
public class SynchronizedSingleton {
    private static volatile SynchronizedSingleton instance = null;

    private SynchronizedSingleton() {}

    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}
