package org.test.pointatoffer.bit;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.bit.Count1sOfBit;

/**
 * User: lingguo
 * Date: 14-7-19 下午3:51
 */
public class Count1sOfBitTest extends BaseTest {

    @Test
    public void testCount() {
        int n = 103;
        int count1 = Count1sOfBit.countByAnd(n);
        int count2 = Count1sOfBit.countByShiftLeft(n);
        int count3 = Count1sOfBit.countByShiftRight(n);

        logger.info("count1: {}, count2: {}, count3: {}", count1, count2, count3);
    }
}
