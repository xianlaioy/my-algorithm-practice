package org.test.misc;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.LongestPalindrome;

/**
 * User: lingguo
 * Date: 14-7-29 下午9:35
 */
public class MiscTest extends BaseTest {

    @Test
    public void testProcess() {
        char[] src = "abcbad".toCharArray();
        char[] dest = LongestPalindrome.preProcess(src);
        logger.info("dest: {}", dest);
    }
}
