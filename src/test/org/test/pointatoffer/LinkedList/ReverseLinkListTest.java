package org.test.pointatoffer.LinkedList;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.ListNode;
import org.yousharp.pointatoffer.linkedlist.ReverseLinkList;

/**
 * User: lingguo
 * Date: 14-7-19 下午10:03
 */
public class ReverseLinkListTest extends BaseTest {

    @Test
    public void testReverse() {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(13);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode newHead = ReverseLinkList.reverse(head);

        while (newHead != null) {
            logger.info("->{}", newHead.value);
            newHead = newHead.next;
        }
    }
}
