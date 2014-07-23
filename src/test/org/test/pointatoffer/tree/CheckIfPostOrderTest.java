package org.test.pointatoffer.tree;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.tree.CheckIfPostOrder;

/**
 * User: lingguo
 * Date: 14-7-23 下午11:43
 */
public class CheckIfPostOrderTest extends BaseTest {

    @Test
    public void testCheck() {
        int[] validPostOrder = new int[] {7, 9, 11, 10, 13, 16, 12};
        int[] invalidPostOrder = new int[] {7, 9, 11, 13, 10, 16, 12};


        boolean validResult = CheckIfPostOrder.check(validPostOrder, 0, validPostOrder.length - 1);
        boolean invalidResult = CheckIfPostOrder.check(invalidPostOrder, 0, invalidPostOrder.length - 1);

        logger.info("validResult: {}, invalidResult: {}", validResult, invalidResult);
    }
}
