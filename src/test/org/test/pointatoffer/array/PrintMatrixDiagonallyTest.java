package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.PrintMatrixDiagonally;

/**
 * User: lingguo
 * Date: 14-7-17 下午11:48
 */
public class PrintMatrixDiagonallyTest extends BaseTest {

    @Test
    public void testPrint() {
        int[][] data = new int[][] {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        PrintMatrixDiagonally.print(data, data.length);

    }

}
