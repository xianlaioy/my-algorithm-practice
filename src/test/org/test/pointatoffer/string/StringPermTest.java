package org.test.pointatoffer.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.string.StringPermutation;

/**
 * User: lingguo
 * Date: 14-7-21 下午8:58
 */
public class StringPermTest extends BaseTest {

    @Test
    public void testPerm() {
        String s = "abcd";
        StringPermutation.permBySwap(s.toCharArray(), 0);
        logger.info("-------------------------------");
        StringPermutation.permByPrefix("", s);
    }
}
