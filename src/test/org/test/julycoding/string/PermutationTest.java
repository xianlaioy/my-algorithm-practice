package org.test.julycoding.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.Permutation;

/**
 * User: lingguo
 * Date: 14-7-30 下午9:05
 */
public class PermutationTest extends BaseTest {

    @Test
    public void testSwapAndRecur() {
        char[] str = "abcd".toCharArray();
        Permutation.swapAndRecur(str, 0, str.length - 1);
    }

    @Test
    public void testHasNextPerm() {
        char[] str = "abcd".toCharArray();

        do {
            System.out.println(str);
        } while (Permutation.hasNextPerm(str));
    }
}
