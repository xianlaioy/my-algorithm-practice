package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.CalculatePow;

/**
 * User: lingguo
 * Date: 14-7-16 上午12:50
 */
public class CalculatePowTest extends BaseTest {


    @Test
    public void testPow() {
        double base = 2.3;
        int ex = 11;
        double result1 = CalculatePow.recurPowOne(base, ex);
        double result2 = CalculatePow.recurPowTwo(base, ex);
        logger.info("result1: {}, result2: {}", result1, result2);
    }

}
