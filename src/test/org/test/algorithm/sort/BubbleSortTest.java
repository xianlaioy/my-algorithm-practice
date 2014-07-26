package org.test.algorithm.sort;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.sort.BubbleSort;

/**
 * User: lingguo
 * Date: 14-7-26 下午2:53
 */
public class BubbleSortTest extends BaseTest {

    @Test
    public void testSort() {
        int[] data = new int[] {22, 90, 15, 33, 80, 45, 100, 21};
        BubbleSort.sort(data);
        System.out.println();
        BubbleSort.sortX(data);
    }
}
