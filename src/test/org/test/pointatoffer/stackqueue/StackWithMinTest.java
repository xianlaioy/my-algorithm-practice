package org.test.pointatoffer.stackqueue;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.stackqueue.StackWithMin;

/**
 * User: lingguo
 * Date: 14-7-20 上午12:16
 */
public class StackWithMinTest extends BaseTest {

    @Test
    public void testMin() {
        StackWithMin.push(30);
        StackWithMin.push(40);
        StackWithMin.push(58);
        StackWithMin.push(81);
        StackWithMin.push(29);

        int min1 = StackWithMin.min();
        StackWithMin.pop();
        int min2 = StackWithMin.min();

        logger.info("min1: {}, min2: {}", min1, min2);
    }
}
