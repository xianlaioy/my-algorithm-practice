package org.yousharp.pointatoffer.stackqueue;

import java.util.LinkedList;

/**
 *  问题描述：
 *      使用两个栈实现队列
 *
 *  思路：
 *      一个栈用于入队，另一个栈用于出队，当出队的栈为空时，将入队的栈的所有元素全部
 *      出栈并压入出队的栈即可；
 *
 * User: Daniel
 * Date: 13-12-14
 * Time: 上午8:13
 */
public class QueueByStacks {
	private static LinkedList<Integer> inStack = new LinkedList<Integer>();
	private static LinkedList<Integer> outStack = new LinkedList<Integer>();

    private static final int ERROR_FLAG = Integer.MAX_VALUE;

	/**
	 *  出队：从outStack出栈，如果outStack为空，则将inStack的所有元素
     *   出栈并压入到outStack中，如果outStack还是空，则队列为空；
     *
	 * @return
	 */
	public static int deQueue() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				int element = inStack.pop();
				outStack.push(element);
			}
		}
		if (outStack.isEmpty()) {
			return ERROR_FLAG;
		}
		return outStack.pop();
	}

	/**
     *  入队：向inStack压入元素即可；
     *
	 * @param element
	 */
	public static void enQueue(int element) {
		inStack.push(element);
	}

}
