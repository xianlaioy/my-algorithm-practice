package org.test.pointatoffer.stackqueue;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.stackqueue.QueueByStacks;

/**
 * User: lingguo
 * Date: 14-7-19 下午11:03
 */
public class QueueByStacksTest extends BaseTest {

    @Test
    public void testImpl() {
        QueueByStacks.enQueue(10);
        QueueByStacks.enQueue(20);
        QueueByStacks.enQueue(30);

        int element = QueueByStacks.deQueue();
        logger.info("element: {}", element);
    }
}
