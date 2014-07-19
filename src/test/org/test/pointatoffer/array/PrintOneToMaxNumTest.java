package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.PrintOneToMaxNum;

/**
 * User: lingguo
 * Date: 14-7-19 上午11:24
 */
public class PrintOneToMaxNumTest extends BaseTest {

    @Test
    public void testStringMethod() {
        int n = 2;
        PrintOneToMaxNum.recursiveMethod(n);
        logger.info("------------------------------");
        PrintOneToMaxNum.stringMethod(n);
    }
}
