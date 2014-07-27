package org.test.julycoding.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.Palindrome;

/**
 * User: lingguo
 * Date: 14-7-27 下午11:48
 */
public class PalindromeTest extends BaseTest {

    @Test
    public void testCheck() {
        char[] str1 = "IamaI".toCharArray();
        char[] str2 = "Iamai".toCharArray();

        logger.info("str1, check1: {}, check2: {}", Palindrome.check(str1), Palindrome.check2(str1));
        logger.info("str2, check1: {}, check2: {}", Palindrome.check(str2), Palindrome.check2(str2));
    }
}
