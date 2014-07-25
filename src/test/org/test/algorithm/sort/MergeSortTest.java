package org.test.algorithm.sort;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.sort.MergeSort;

/**
 * User: lingguo
 * Date: 14-7-26 上午12:11
 */
public class MergeSortTest extends BaseTest {

    @Test
    public void testSort() {
        int[] data = new int[] {12, 34, 21, 45, 15, 90, 10, 20, 40, 100};
        MergeSort.sort(data);
    }

}
