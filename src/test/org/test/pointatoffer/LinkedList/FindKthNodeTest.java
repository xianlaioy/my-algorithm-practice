package org.test.pointatoffer.LinkedList;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.common.ListNode;
import org.yousharp.pointatoffer.linkedlist.FindKthNode;

/**
 * User: lingguo
 * Date: 14-7-19 下午4:59
 */
public class FindKthNodeTest extends BaseTest {

    @Test
    public void testFind() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode kth = FindKthNode.find(head, 6);
        logger.info("kth: {}", kth.value);
    }
}
