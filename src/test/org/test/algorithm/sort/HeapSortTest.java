package org.test.algorithm.sort;

import org.junit.Test;
import org.yousharp.algorithm.sort.HeapSort;

/**
 * User: lingguo
 * Date: 14-7-26 上午11:47
 */
public class HeapSortTest {

    @Test
    public void testSort() {
        int[] data = new int[] {22, 90, 15, 33, 80, 45, 100, 21};
        HeapSort.sort(data);
    }
}
