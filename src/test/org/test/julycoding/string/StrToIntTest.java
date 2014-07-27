package org.test.julycoding.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.julycoding.string.StrToInt;

/**
 * User: lingguo
 * Date: 14-7-26 下午5:20
 */
public class StrToIntTest extends BaseTest {

    @Test
    public void testConvert() {
        char[] s0 = "345923".toCharArray();
        char[] s1 = "-93485".toCharArray();
        char[] s2 = "+457845".toCharArray();
        char[] s3 = "    49584".toCharArray();

        char[] s4 = null;
        char[] s5 = "".toCharArray();
        char[] s6 = "   ".toCharArray();
        char[] s7 = "    +".toCharArray();
        char[] s8 = "    -".toCharArray();
        char[] s9 = "123456789012".toCharArray();
        char[] s10 = "-1234567891234".toCharArray();

        System.out.println(StrToInt.convert(s10));
    }
}
