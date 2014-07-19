package org.test.pointatoffer.bit;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.bit.SumByBit;

/**
 * User: lingguo
 * Date: 14-7-19 下午3:27
 */
public class SumByBitTest extends BaseTest {

    @Test
    public void testCal() {
        int a = 10;
        int b = 24;

        int sum = SumByBit.cal(a, b);
        logger.info("sum: {}", sum);
    }
}
