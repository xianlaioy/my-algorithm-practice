package org.test.algorithm.search;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.algorithm.search.BinarySearch;

/**
 * @author: lingguo
 * @time: 2014/8/31 11:27
 */
public class BinarySearchTest extends BaseTest {

    @Test
    public void testSearch() {
        int[] data = {3, 6, 9, 11, 15, 19, 20, 25, 28, 35};
        int x = 29;
        int rs1 = BinarySearch.search_1(data, data.length, x);
        int rs2 = BinarySearch.search_2(data, data.length, x);
        int rs3 = BinarySearch.search_3(data, data.length, x);

        logger.info("rs1: {}, rs2: {}, rs3: {}", rs1, rs2, rs3);
    }
}
