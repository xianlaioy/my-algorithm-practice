package org.yousharp.designpattern.creational.singleton;

/**
 * 懒汉式单例：仅在需要实例时才创建，但是为了适应多线程，需要增加同步代码。
 *
 * 双重判定：是对用synchronized同步方法的改进，尽在需要创建实例时才加锁。
 * 注意：volatile关键字，在多线程时，保证线程的读写顺序，即一个线程的写操作完成后，另一个线程才能读。
 *
 * User: Daniel
 * Date: 13-12-5
 * Time: 下午9:35
 */
public class DoubleCheckSingleton {
	// volatile keyword
	private volatile static DoubleCheckSingleton instance = null;

	// private constructor
	private DoubleCheckSingleton (){}

	// double-checking
	public static DoubleCheckSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		return instance;
	}

}
