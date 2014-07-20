package org.test.pointatoffer.stackqueue;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.stackqueue.ValidateQueue;

/**
 * User: lingguo
 * Date: 14-7-20 下午10:08
 */
public class ValidateQueueTest extends BaseTest {

    @Test
    public void testValidate() {
        int[] input = new int[] {3, 8, 12, 18, 21};
        int[] output1 = new int[] {8, 3, 12, 21, 18};
        int[] output2 = new int[] {12, 18, 3, 8, 21};

        boolean result1 = ValidateQueue.check(input, output1);
        boolean result2 = ValidateQueue.check(input, output2);

        logger.info("result1: {}, result2: {}", result1, result2);
    }
}
