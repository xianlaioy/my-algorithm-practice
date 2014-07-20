package org.test.pointatoffer.stackqueue;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.stackqueue.StackByQueues;

/**
 * User: lingguo
 * Date: 14-7-19 下午11:40
 */
public class StackByQueueTest extends BaseTest {

    @Test
    public void testImpl() {
        StackByQueues.push(10);
        StackByQueues.push(20);
        StackByQueues.push(30);

        int top = StackByQueues.pop();
        logger.info("top: {}", top);
    }
}
