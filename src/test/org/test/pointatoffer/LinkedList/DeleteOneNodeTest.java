package org.test.pointatoffer.LinkedList;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.ListNode;
import org.yousharp.pointatoffer.linkedlist.DeleteOneNode;

/**
 * User: lingguo
 * Date: 14-7-19 下午4:45
 */
public class DeleteOneNodeTest extends BaseTest {

    @Test
    public void testDelete() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode newHead = DeleteOneNode.delete(head, node3);
        while (newHead != null) {
            logger.info("->{}", newHead.value);
            newHead = newHead.next;
        }
    }
}
