package org.test.algorithm.sort;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.sort.InsertionSort;

/**
 * User: lingguo
 * Date: 14-7-25 上午7:40
 */
public class InsertionSortTest extends BaseTest {

    @Test
    public void testSort() {
        int[] data = new int[] {4, 68, 12, 80, 42, 16, 55};
        InsertionSort.sort(data);
    }
}
