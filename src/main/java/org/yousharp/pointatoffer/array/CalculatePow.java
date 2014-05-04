package org.yousharp.pointatoffer.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 *  计算 pow(double base, int exponent)，即base的exponent次方；
 *  忽略大数问题，不得使用库函数
 * 思路：
 *  题目不难，但需要注意几个问题：
 *  1. exponent可以为正值，也可以为负值，当为负值时，需要base是否为0（浮点数的比较问题）；
 *  2. 求幂次方时，从平方（折半）的角度，可以提高效率
 * User: Daniel
 * Date: 13-12-18
 * Time: 下午11:30
 */
public class CalculatePow {
	private static Logger logger = LoggerFactory.getLogger(CalculatePow.class);

	private final double THRESHOLD = 1E-6;

	/**
	 * 计算浮点数base的exponent次幂，不考虑大数（溢出）问题
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
		double result = positivePow(base, absExponent);

		// 如果exponent为负值，取其倒数
		if (exponent < 0) {
			result = 1.0 / result;
		}
		return result;
	}

	/**
	 * 通过平方的思路计算幂值（指数exponent为正值）：
	 *  如果指数为偶数, b^e = b^(e/2) * b^(e/2)
	 *  如果指数为奇数, b^e = b^(e/2) * b^(e/2) * b
	 *  这比通过循环求幂值的效率要好一些，可以通过递归来实现。
	 * @param base
	 * @param exponent
	 * @return
	 */
	private double positivePow(double base, int exponent) {
		if (exponent == 1) {
			return base;
		}
		double result = positivePow(base, exponent >> 1);
		result *= result;               // 先计算平方
		if ((exponent & 0x1) == 1) {   // 如果指数exponent为奇数，平方外应该再乘以base
			result *= base;
		}
		return result;
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
