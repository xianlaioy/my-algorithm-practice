package org.yousharp.careercup.bit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 *  将一个以String表示的浮点数（如3.72），转换为二进制表示；如果该浮点数无法使用二进制
 *  精确表示，则输出"ERROR"
 *
 * 思路：
 *  将浮点数分为整数和小数两部分，整数部分循环求余；
 *  小数部分如何表示？其实0.75 = 0.5 + 0.25 = 1*2^-1 + 1* 2^-2，其二进制表示即为0.11；
 *  左移1位后：1.5 = 1*2^0 + 1*2^-1 = 1.1，此时浮点值大于1，左移后该位为1，即1*2^0，如果
 *  左移后浮点值小于1，如0.35，则左移后该二进制位为0，即0*2^0；
 *  循环左移，判断值是否大于1，确定每一个二进制位；
 *
 * User: lingguo
 * Date: 14-7-12
 */
public class BinaryOfDecimal {
    private static Logger logger = LoggerFactory.getLogger(BinaryOfDecimal.class);

    public static String represent(String decimalValue) {
        String[] valueArray = decimalValue.split("\\.");
        int intPart = Integer.valueOf(valueArray[0]);
        double decPart = Double.valueOf(decimalValue) - intPart;

        // 整数部分的二进制表示：循环求余
        String intBinary = "";
        while (intPart != 0) {
            int r = intPart % 2;
            intPart = intPart >> 1;
            intBinary = r + intBinary;
        }

        // 小数部分：左移位与1比较
        String decBinary = "";
        while (decPart > 0) {
            decPart = decPart * 2;
            if (decPart >= 1) {
                decBinary = decBinary + 1;
                decPart = decPart - 1;
            } else {
                decBinary = decBinary + 0;
            }

            // 无法使用二进制精确表示
            if (decBinary.length() > 32) {
                logger.error("ERROR");
                break;
            }
        }

        return intBinary + "." + decBinary;
    }
}
