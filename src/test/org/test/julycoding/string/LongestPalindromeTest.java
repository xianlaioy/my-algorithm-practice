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


    @Test
    public void testManacher() {
        char[] str1 = "ecbabcd".toCharArray();
        char[] str2 = "cbaabc".toCharArray();

        char[] ret1 = LongestPalindrome.manacher(str1);
        char[] ret2 = LongestPalindrome.manacher(str2);
        logger.info("ret1: {}, ret2: {}", ret1, ret2);
    }

}
