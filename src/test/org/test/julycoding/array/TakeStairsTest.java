package org.test.julycoding.array;

import junit.framework.TestCase;
import org.yousharp.julycoding.array.TakeStairs;

/**
 * @author: lingguo
 * @time: 2014/8/18 16:29
 */
public class TakeStairsTest extends TestCase {

    public void testJump() {
        int n = 10;
        int totalCount = TakeStairs.jump(n);
        System.out.println("totalCount: " + totalCount);
    }
}
