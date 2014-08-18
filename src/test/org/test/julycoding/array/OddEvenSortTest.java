package org.test.julycoding.array;

import junit.framework.TestCase;
import org.yousharp.julycoding.array.OddEvenSort;

/**
 * @author: lingguo
 * @time: 2014/8/18 16:01
 */
public class OddEvenSortTest extends TestCase {

    public void testSort() {
        int[] data = {10, 80, 23, 70, 31, 64, 28, 101, 38, 17};
        OddEvenSort.sort1(data, 0, data.length - 1);

        OddEvenSort.sort2(data, 0, data.length - 1);
    }
}
