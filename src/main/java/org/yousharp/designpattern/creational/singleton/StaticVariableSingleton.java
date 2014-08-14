package org.yousharp.designpattern.creational.singleton;

/**
 * 饿汉式单例，在类加载时即创建实例；
 *
 * 缺点：类的实例仅在类加载时创建一次，无论运行时是否需要；如果该类的实例不是很大，创建了不使用也没关系，
 * 那么这是一种很好的实现单例模式的方法。
 *
 * User: Daniel
 * Date: 13-12-4
 * Time: 下午11:00
 */
public class StaticVariableSingleton {
	// volatile reads and writes establish a happen-before relationship
	private volatile static StaticVariableSingleton instance = new StaticVariableSingleton();

	// private constructor
	private StaticVariableSingleton() {}

	// return the instance
	public static StaticVariableSingleton getInstance() {
		return instance;
	}
}
