package org.yousharp.pointatoffer.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.ListNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 题目描述：
 *  逆序打印链表的值
 *
 * 思路：
 *  思路一：逆序打印，链表中的节点后进先出，栈的特点。
 *  思路二：栈和递归本质上一致，所以可以直接使用递归实现
 *  复杂度O(n)。
 * User: Daniel
 * Date: 13-12-8
 * Time: 下午9:04
 */
public class PrintLinkedListReversely {
	private static Logger logger = LoggerFactory.getLogger(PrintLinkedListReversely.class);

	/**
	 * 使用栈逆序打印链表中的值
	 * @param head 链表的头节点
    */
	public static void stackImpl(LinkedList<Integer> head) {
		if (null == head) {
			return;
		}
        // LinkedList作为栈
		LinkedList<Integer> stack = new LinkedList<Integer>();
        // 入栈
		Iterator<Integer> it = head.iterator();
		while (it.hasNext()) {
			stack.push(it.next());
		}
        // 出栈
		while (!stack.isEmpty()) {
			logger.info("node: {}", stack.pop());
		}
	}

	/**
	 * 递归地思路：逆序打印链表的节点
	 * @param head  链表的头节点
	 */
	public static void recursionImpl(ListNode head) {
		if (null == head) {
			return;
		}
		recursionImpl(head.next);
		logger.info("node: {}", head.value);
	}
}
