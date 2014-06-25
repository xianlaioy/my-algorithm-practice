package org.yousharp.pointatoffer.stackqueue;

import java.util.LinkedList;

/**
 *  问题描述：
 *       使用两个队列实现栈的入栈和出栈操作；
 *
 *   思路：
 *       始终维持一个队列为空，一个队列非空；入栈的时候向非空的队列插入一个元素；出栈的时候，将非空
 *        队列中的所有元素（除队尾元素外，此元素为栈顶元素）都依次出队并插入到非空队列中。
 *
 * Usr: Daniel
 * Date: 13-12-15
 * Time: 上午11:19
 */
public class StackByQueues {
	private static LinkedList<Integer> firstQueue = new LinkedList<Integer>();
	private static LinkedList<Integer> secondQueue = new LinkedList<Integer>();

    private static final int ERROR_FLAG = Integer.MAX_VALUE;

	/**
	 *  入栈：向非空队列插入一个元素
	 *
	 * @param element
	 */
	public static void push(int element) {
		if (firstQueue.isEmpty()) {
			secondQueue.offer(element);
		} else {
			firstQueue.offer(element);
		}
	}

	/**
	 *  出栈：将非空队列除尾元素外的所有元素都出队并入队到另一个空队列中。
	 *
	 * @return
	 */
	public static int pop() {
		if (firstQueue.isEmpty() && secondQueue.isEmpty()) {
			return ERROR_FLAG;
		}
		if (firstQueue.isEmpty()) {
			while (secondQueue.size() != 1) {
				int element = secondQueue.poll();
				firstQueue.offer(element);
			}
			return secondQueue.poll();
		}
		if (secondQueue.isEmpty()) {
			while (firstQueue.size() != 1) {
				int element = firstQueue.poll();
				secondQueue.offer(element);
			}
			return firstQueue.poll();
		}
		return Integer.MAX_VALUE;
	}

}