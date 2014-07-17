package org.yousharp.pointatoffer.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 *  计算 pow(double base, int ex)，即base的ex次方；
 *  忽略大数问题，不得使用库函数
 *
 * 思路：
 *  题目不难，但需要注意几个问题：
 *  1. exponent可以为正值，也可以为负值，当为负值时，需要判断base是否为0（浮点数的比较问题）；
 *  2. 求幂次方时，二分平方的思路，非常棒。
 *
 * User: Daniel
 * Date: 13-12-18
 * Time: 下午11:30
 */
public class CalculatePow {
	private static Logger logger = LoggerFactory.getLogger(CalculatePow.class);

	private final double THRESHOLD = 1E-6;

	/**
	 * 计算浮点数base的exponent次幂，不考虑大数（溢出）问题
     *
	 * @param base
	 * @param exponent
	 * @return  -1表示异常，否则，返回值为结果值
	 */
	public double getPow(double base, int exponent) {
		if (isEqual(base, 0.0)) {
			if (exponent < 0) {
				logger.info("error input");
				return -1;
			}
			return 1.0;
		}

		// 计算exponent为正值时的结果
		int absExponent = exponent;
		if (exponent < 0) {
			absExponent = -exponent;
		}
		double result = recurPowOne(base, absExponent);

		// 如果exponent为负值，取其倒数
		if (exponent < 0) {
			result = 1.0 / result;
		}
		return result;
	}

	/**
	 * 计算base的ex次方，其中ex为整数，二分法，地推实现：
	 *  如果指数为偶数, b^e = b^(e/2) * b^(e/2)
	 *  如果指数为奇数, b^e = b^(e/2) * b^(e/2) * b
	 *  这比通过循环求幂值的效率要好一些，可以通过递归来实现。
     *
	 * @param base
	 * @param ex
	 * @return
	 */
	public static double recurPowOne(double base, int ex) {
		if (ex == 1) {
			return base;
		}
		double result = recurPowOne(base, ex >> 1);
		result *= result;               // 先计算平方
		if ((ex & 0x1) == 1) {   // 如果指数exponent为奇数，平方外应该再乘以base
			result *= base;
		}
		return result;
	}

    /**
     * 计算base的ex次方，ex为正数，递归的另一种实现方式，更直观
     *
     * @param base
     * @param ex
     * @return
     */
    public static double recurPowTwo(double base, int ex) {
        if (ex == 1) {
            return base;
        }
        // 根据奇偶分支
        if ((ex & 1) == 1) {
            return recurPowTwo(base, ex >> 1) * recurPowTwo(base, ex >> 1) * base;
        } else {
            return recurPowTwo(base, ex >> 1) * recurPowTwo(base, ex >> 1);
        }
    }

	/**
	 * 比较两个浮点数是否相等
	 * @param d1
	 * @param d2
	 * @return 如果相等，返回true，否则返回false；
	 */
	private boolean isEqual(double d1, double d2) {
		if ((d1 - d2) < THRESHOLD && (d1 - d2) > -THRESHOLD) {
			return true;
		}
		return false;
	}

}
