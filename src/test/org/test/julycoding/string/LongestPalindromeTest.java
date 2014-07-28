package org.test.julycoding.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.LongestPalindrome;

/**
 * User: lingguo
 * Date: 14-7-28 下午11:17
 */
public class LongestPalindromeTest extends BaseTest {

    @Test
    public void testCenter() {
        char[] str = "12212321".toCharArray();
        char[] str2 = "abaaba".toCharArray();
        char[] pal = LongestPalindrome.center(str2);
        logger.info("pal: {}", pal);
    }

}
