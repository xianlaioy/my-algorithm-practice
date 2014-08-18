package org.test.julycoding.array;

import junit.framework.TestCase;
import org.yousharp.julycoding.array.MaxSubArray;

/**
 * @author: lingguo
 * @time: 2014/8/18 12:00
 */
public class MaxSubArrayTest extends TestCase {

    public void testGetMax() {
        int[] data = {1, -2, 3, 10, -4, 7, 2, -5};
        int maxSum1 = MaxSubArray.getMax(data, data.length);
        int maxSum2 = MaxSubArray.getByLoop(data, data.length);

        System.out.println("maxSum1: " + maxSum1 + ", maxSum2: " + maxSum2);
    }
}
