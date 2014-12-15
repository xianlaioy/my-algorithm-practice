package org.test.pointatoffer.linkedlist;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.ds.ListNode;
import org.yousharp.pointatoffer.linkedlist.LastNumberInCircle;

import java.util.ArrayList;

/**
 * User: lingguo
 * Date: 14-7-19 下午5:42
 */
public class LastNumberInCircleTest extends BaseTest {

    @Test
    public void testFindByBuildingNode() {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode last1 = LastNumberInCircle.findByBuildingList(head, 3);

        ArrayList<Integer> numList = Lists.newArrayList(0, 1, 2, 3, 4);
        int last2 = LastNumberInCircle.findByArrayList(numList, 3);

        int last3 = LastNumberInCircle.findByLoop(5, 3);

        int last4 = LastNumberInCircle.findByRecursion(5, 3);

        logger.info("last1: {}, last2: {}, last3: {}, last4: {}", last1.value, last2, last3, last4);
    }
}
