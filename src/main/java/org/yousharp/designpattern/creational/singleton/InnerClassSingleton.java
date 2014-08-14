package org.yousharp.designpattern.creational.singleton;

/**
 * 将实例作为类的静态变量，仅在类加载时创建一次；
 * 如果需要使用单例模式，强烈推荐这种实现方式。
 *
 * User: Daniel
 * Date: 13-12-5
 * Time: 下午10:04
 */
public class InnerClassSingleton {
	// private constructor
	private InnerClassSingleton() {}

	// inner class, create an instance
	private static class LazyHolder {
		private static final InnerClassSingleton instance = new InnerClassSingleton();
	}

	// get instance from inner class
	public static InnerClassSingleton getInstance() {
		return LazyHolder.instance;
	}
}
