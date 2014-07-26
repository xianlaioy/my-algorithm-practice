package org.test.algorithm.sort;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.sort.ShellSort;

/**
 * User: lingguo
 * Date: 14-7-26 上午10:32
 */
public class ShellSortTest extends BaseTest {

    @Test
    public void testSort() {
        int[] data = new int[] {22, 90, 15, 33, 80, 45, 100, 21};
        ShellSort.sort(data);
    }
}
