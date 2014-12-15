package org.test.algorithm.sort;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.Util;
import org.yousharp.algorithm.sort.QuickSort;

/**
 * User: lingguo
 * Date: 14-7-25 下午11:11
 */
public class QuickSortTest extends BaseTest {

    @Test
    public void testSort() {
        int[] data = new int[] {12, 34, 21, 45, 15, 90, 10, 20, 40, 100};
        QuickSort.sort(data, 0, data.length - 1);
        Util.show(data);
    }

    @Test
    public void testSort2() {
        int[] data = {34, 21};
        QuickSort.sort(data, 0, data.length - 1);
        Util.show(data);
    }
}
