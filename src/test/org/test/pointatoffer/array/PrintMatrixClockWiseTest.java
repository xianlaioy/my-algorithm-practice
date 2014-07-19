package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.PrintMatrixClockWise;

/**
 * User: lingguo
 * Date: 14-7-17 下午10:13
 */
public class PrintMatrixClockWiseTest extends BaseTest {

    @Test
    public void testPrint() {
        int[][] matrix = new int[][] {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};

        PrintMatrixClockWise.print(matrix, matrix[0].length, matrix.length);

    }
}
