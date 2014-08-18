package org.test.julycoding.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.array.SumOfAnyNum;

import java.util.LinkedList;

/**
 * @author: lingguo
 * @time: 2014/8/16 12:03
 */
public class SumOfAnyNumTest extends BaseTest {

    @Test
    public void testCalculate() {
        LinkedList stack = new LinkedList();
        int n = 10;
        int sum = 15;
        SumOfAnyNum.calculate(n, sum, stack);
    }
}
