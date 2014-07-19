package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.SearchInSortedArray;

/**
 * User: lingguo
 * Date: 14-7-19 上午11:50
 */
public class SearchInSortedArrayTest extends BaseTest {

    @Test
    public void testSearch() {
        int[][] data = new int[][] {
                { 2,   5,   7,   9,   10 },
                { 3,   8,   9,   11,  13 },
                { 5,   9,   12,  15,  20 } ,
                { 9,   11,  32,  40,  50 }
        };

        boolean result = SearchInSortedArray.search(data, data.length, data[0].length, 0);
        logger.info("result: {}", result);
    }
}
