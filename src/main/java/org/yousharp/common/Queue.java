package org.yousharp.common;

/**
 * 基本数据结构：队列的实现
 *
 * User: Daniel
 * Date: 13-12-14
 * Time: 上午11:12
 */
public class Queue {
	public ListNode front;
	public ListNode tail;

	/**
	 * 入队：节点插入到队列的头部
     *
	 * @param newNode
	 */
	public void enqueue(ListNode newNode) {
        // 快速失败
        if(null == newNode) {
            return;
        }

        if (null == front) {
            front = newNode;
            tail = front;
        } else {
            front.next = newNode;
            front = newNode;
        }
	}

	/**
	 * 出队：删除的是队尾的元素(如果删除队头元素，会比较麻烦一些)
     *
	 * @return
	 */
	public ListNode dequeue() {
        if (front == null) {
            return null;
        }
		// 队列中有多个元素
		if (front != tail) {
			ListNode tailBak = new ListNode(tail.value);
			tail = tail.next;
			return tailBak;
		// 队列中只有一个元素
		} else if (front == tail) {
			ListNode tailBak = new ListNode(tail.value);
			front = null;
			tail = null;
			return tailBak;
		}
		return null;    // the queue is empty
	}

	/**
	 * 返回队列的大小
     *
	 * @return
	 */
	public int size() {
		int size = 0;
		if (null == tail) {
			return size;
		}
		ListNode tailBak = tail;
		while (tailBak != front) {
			size++;
			tailBak = tailBak.next;
		}
        size++;
		return size;
	}
}
