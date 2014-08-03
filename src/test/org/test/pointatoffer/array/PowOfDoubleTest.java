package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.PowOfDouble;

/**
 * User: lingguo
 * Date: 14-7-16 上午12:50
 */
public class PowOfDoubleTest extends BaseTest {


    @Test
    public void testPow() {
        double base = 2.3;
        int ex = 11;
        double result1 = PowOfDouble.calPow1(base, ex);
        double result2 = PowOfDouble.calPow2(base, ex);
        logger.info("result1: {}, result2: {}", result1, result2);
    }

}
