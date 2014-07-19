package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.OddNumBeforeEven;

/**
 * User: lingguo
 * Date: 14-7-17 下午9:48
 */
public class OddNumBeforeEvenTest extends BaseTest {

    @Test
    public void testAdjust() {
        int[] data = new int[] {10, 21, 33, 44, 90, 19, 39, 20};
        logger.info("data adjusted: {}", OddNumBeforeEven.adjust(data, data.length));
    }
}
