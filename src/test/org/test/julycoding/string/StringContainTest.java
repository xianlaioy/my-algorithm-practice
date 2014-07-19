package org.test.julycoding.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.StringContain;

/**
 * User: lingguo
 * Date: 14-7-16 上午12:25
 */
public class StringContainTest extends BaseTest {

    @Test
    public void testHashCheck() {
        char[] s1 = "I LOVE NBA!".toCharArray();
        char[] s2 = "LOVE YOU".toCharArray();
        char[] s3 = "NBA AI".toCharArray();

        boolean r1 = StringContain.hashCheck(s1, s2);
        boolean r2 = StringContain.hashCheck(s1, s3);
        logger.info("r1: {}, r2: {}", r1, r2);
    }
}
