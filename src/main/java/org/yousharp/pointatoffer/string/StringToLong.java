package org.yousharp.pointatoffer.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题：
 *  将一个字符串转换成整数；
 *
 * 思路：
 *  主要是对各种正常和异常情况进行处理：
 *      正常：字符串中都是数字；包含正负号；
 *      异常：字符串为空或null；字符串中包含非数字字符；
 *  另外，就是如何判断字符串表示的整数是否发生了溢出；在计算的过程中，如果正数变成了负数，
 *  则认为是发生了溢出。
 *
 * User: Daniel
 * Date: 14-1-14
 * Time: 上午8:03
 */
public class StringToLong {
	private static Logger logger = LoggerFactory.getLogger(StringToLong.class);

	/**
	 * 将字符串转换为对应的整数形式
     *
	 * @param str   字符串
	 * @return      对应的整数输出
	 */
	public static Long convert(String str) {
        // 异常
		if (null == str || str.isEmpty()) {
			logger.info("param is null.");
			return null;
		}

		boolean isPositive = true;
		int begin = 0;

		// 是否包含符号
		if ('+' == str.charAt(0)) {
			begin++;
		} else if ('-' == str.charAt(0)) {
			begin++;
			isPositive = false;
		}

		int i = 0;
		long num = 0;
		// 遍历每一个字符
		for (i = begin; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				num = 10 * num + str.charAt(i) - '0';
				// overflow
				if (num < 0) {
					logger.info("overflow error, str: {}", str);
					return null;
				}
			} else {
                logger.error("invalid char: {}", str.charAt(i));
				return null;
			}
		}

		// if convert successfully
		if (i == str.length()) {
			if (!isPositive) {
				num = -num;
			}
			return num;
		}
		return null;
	}
}
