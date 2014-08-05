package org.test.pointatoffer.array;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.array.StraightPoker;

/**
 * User: lingguo
 * Date: 14-7-19 下午1:18
 */
public class StraightPokerTest extends BaseTest {

    @Test
    public void testIsValid() {
        int[] cards = new int[] {12, 11, 8, 0, 8, 9};
        boolean resultOfBit =  StraightPoker.isValidByBit(cards, cards.length);
        boolean resultOfArray =  StraightPoker.isValidByArray(cards, cards.length);
        logger.info("bit result: {}, array result: {}", resultOfBit, resultOfArray);
    }

    @Test
    public void testVerify() {
        int[] cards = new int[] {3, 6, 5, 7, 0};
        boolean result = StraightPoker.verify(cards, cards.length);
        logger.info("result: {}", result);
    }
}
