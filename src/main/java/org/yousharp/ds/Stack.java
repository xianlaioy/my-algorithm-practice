package org.yousharp.ds;

/**
 * 栈的定义
 *
 * User: Daniel
 * Date: 13-12-14
 * Time: 上午9:01
 */
public class Stack {
	public ListNode top;

	/**
	 * 返回栈顶
     *
	 * @return
	 */
	public ListNode peek() {
		if (null == top) {
			return null;
		}
		return top;
	}

	/**
	 * 入栈
     *
	 * @param newNode
	 */
	public void push(ListNode newNode) {
		if (null != newNode) {
			newNode.next = top;
			top = newNode;
		}
	}

	/**
	 * 出栈
     *
	 * @return
	 */
	public ListNode pop() {
		if (null == top) {
			return null;
		}
		ListNode topBak = new ListNode(top.value);
		top = top.next;
		return topBak;
	}

	/**
	 * 返回栈的大小
     *
	 * @return
	 */
	public int size() {
		int size = 0;
		ListNode topBak = top;
		while (null != topBak) {
			size ++;
			topBak = topBak.next;
		}
		return size;
	}
}
