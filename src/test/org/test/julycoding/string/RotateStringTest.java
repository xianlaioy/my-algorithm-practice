package org.test.julycoding.string;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.BaseTest;
import org.yousharp.ds.ListNode;
import org.yousharp.julycoding.string.RotateString;

/**
 * User: lingguo
 * Date: 14-7-14
 */
public class RotateStringTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(RotateString.class);

    @Test
    public void testRotateLeftString() {
        char[] sentence = "I Love You!".toCharArray();
        int n = 6;
        char[] result = RotateString.leftRotateString(sentence, n);
        logger.info("result: {}", new String(result));

    }

    @Test
    public void testRotateSentence() {
        char[] sentence = "What's your name?".toCharArray();
        char[] result = RotateString.rotateSentence(sentence);
        logger.info("result: {}", new String(result));
    }

    @Test
    public void testRotateRightString() {
        char[] str = "come on, coder!".toCharArray();
        int n = 4;
        char[] result = RotateString.rightRotateString(str, n);
        logger.info("result: {}", new String(result));
    }


    @Test
    public void rotateLinkList() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode newHead = RotateString.rotateLinkList(head, 4);
        while (newHead != null) {
            logger.info("{}->", newHead.value);
            newHead = newHead.next;
        }
    }
}
