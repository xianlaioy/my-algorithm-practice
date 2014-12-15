package org.test.careercup.bit;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.careercup.bit.SubstringOfBit;

/**
 * User: lingguo
 * Date: 14-7-14
 */
public class SubstringOfBitTest extends BaseTest {

    @Test
    public void testUpdateBits1() {
        int m = Integer.parseInt("10101", 2);
        int n = Integer.parseInt("10000000100", 2);
        int i = 2;
        int j = 6;

        int result1 = SubstringOfBit.updateBits1(m, n, i, j);
        int result2 = SubstringOfBit.updateBits2(m, n, i, j);
        logger.info("result1: {}, result2: {}", Integer.toBinaryString(result1), Integer.toBinaryString(result2));
    }
}
