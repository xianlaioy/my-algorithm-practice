package org.yousharp.pointatoffer.linkedlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.ListNode;

/**
 * 问题描述：
 *  返回链表中倒数第k个节点
 *
 * 思路：
 *  使用两个指针，第一个指针先走(k-1)步，第二个指针不动，此时两个指针相差k个节点；然后两个指针同时向前走，直到第一个指针
 *  到达链表尾节点，此时第二个指针即为链表的倒数第k个节点。
 *  注意：需要考虑到链表不够k个节点的情况。
 *
 * User: lingguo
 * Date: 14-3-11
 * Time: 下午11:51
 */
public class FindKthNode {
	private static Logger logger = LoggerFactory.getLogger(FindKthNode.class);

	/**
     * 查找链表中倒数第k个节点
	 * @param head  链表的头节点
	 * @param k 倒数第k个节点
	 * @return
	 */
	public static ListNode find(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}

		// 第一个节点先向前走k-1步
		ListNode firstNode = head;
		int i = 0;
		while ((i < k -1) && (firstNode.next != null)) {
				firstNode = firstNode.next;
				i++;
		}
		// 链表的长度小于k
		if (i != k - 1) {
			return null;
		}

		// 两个节点同时走，直到第一个节点到达尾节点
		ListNode secondNode = head;
		while (firstNode.next != null) {
			firstNode = firstNode.next;
			secondNode = secondNode.next;
		}
		return secondNode;
	}
}
