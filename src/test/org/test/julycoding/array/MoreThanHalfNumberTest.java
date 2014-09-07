package org.test.julycoding.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.array.MoreThanHalfNumber;

/**
 * @author: lingguo
 * @time: 2014/8/31 14:11
 */
public class MoreThanHalfNumberTest extends BaseTest {

    @Test
    public void testFind() {
        int[] data = {12, 15, 10, 12, 13, 12, 12, 18, 12, 19, 12, 12};
        int rs = MoreThanHalfNumber.find(data, data.length);
        logger.info("rs: {}", rs);
    }
}
