package org.test.pointatoffer.string;

import org.junit.Test;
import org.test.BaseTest;
import org.yousharp.pointatoffer.string.StringToLong;

/**
 * User: lingguo
 * Date: 14-7-21 下午9:37
 */
public class StringToLongTest extends BaseTest {

    @Test
    public void testConvert() {
        String s1 = "234596";
        String s2 = "-7439234";
        String s3 = "+7434512";
        String s4 = "";
        String s5 = "4546fd088";
        String s6 = "12345678998765432112345678998765432100";

        logger.info("s1: {}, s2: {}, s3: {}, s4: {}, s5: {}", StringToLong.convert(s1),
                StringToLong.convert(s2), StringToLong.convert(s3), StringToLong.convert(s4),
                StringToLong.convert(s5), StringToLong.convert(s6));
    }
}
