package org.test.pointatoffer.linkedlist;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.ds.ListNode;
import org.yousharp.pointatoffer.linkedlist.PrintLinkedListReversely;

/**
 * User: lingguo
 * Date: 14-7-19 下午9:56
 */
public class PrintLinkedListReverselyTest extends BaseTest {

    @Test
    public void testPrint() {
        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(12);
        ListNode node3 = new ListNode(13);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        PrintLinkedListReversely.printByRecursion(head);
        PrintLinkedListReversely.printUseStack(head);

    }
}
