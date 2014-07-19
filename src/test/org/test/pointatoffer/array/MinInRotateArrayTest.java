package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.MinInRotateArray;

/**
 * User: lingguo
 * Date: 14-7-17 下午10:34
 */
public class MinInRotateArrayTest extends BaseTest {

    @Test
    public void testGetMin() {
        int[] data = new int[] {3, 5, 7, 9, 1, 2};
        logger.info("min: {}", MinInRotateArray.getMin(data, 0, data.length - 1));
    }
}
