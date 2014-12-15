package org.test.pointatoffer.linkedlist;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.ds.ListNode;
import org.yousharp.pointatoffer.linkedlist.MergeTwoSortedList;

/**
 * User: lingguo
 * Date: 14-7-19 下午9:45
 */
public class MergeTwoSortedListTest extends BaseTest {

    @Test
    public void testMerge() {
        ListNode firstHead = new ListNode(1);
        firstHead.next = new ListNode(3);
        firstHead.next.next = new ListNode(5);
        firstHead.next.next.next = new ListNode(14);

        ListNode secondHead = new ListNode(2);
        secondHead.next = new ListNode(6);
        secondHead.next.next = new ListNode(10);
        secondHead.next.next.next = new ListNode(20);

        ListNode newHead = MergeTwoSortedList.merge(firstHead, secondHead);
        while (newHead != null) {
            System.out.print(newHead.value + "->");
            newHead = newHead.next;
        }
    }
}
