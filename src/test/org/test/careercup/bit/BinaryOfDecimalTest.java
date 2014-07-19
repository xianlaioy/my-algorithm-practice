package org.test.careercup.bit;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.careercup.bit.BinaryOfDecimal;

/**
 * User: lingguo
 * Date: 14-7-12
 */
public class BinaryOfDecimalTest extends BaseTest {

    @Test
    public void testRepresent() {
        String decimalValue = "3.75";
        String binaryOfDec = BinaryOfDecimal.represent(decimalValue);
        logger.info("binaryOfDec: {}", binaryOfDec);
    }
}
