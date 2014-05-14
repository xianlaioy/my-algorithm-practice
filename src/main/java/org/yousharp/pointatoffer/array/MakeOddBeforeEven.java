package org.yousharp.pointatoffer.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 *  给定数组，调整数组中元素的顺序，使得所有的奇数都位于数组的前部分，所有的偶数都位于数组的后部分。
 * 思路：
 *  - 使用两个指针，第一个指针指向数组首元素，第二个指针指向数组尾元素，在两个指针相遇前，第一个指针向后移动，
 *  直到遇到偶数，第二个指针向前移动，直到遇到奇数，然后两个指针指向的元素交换；重复上述步骤，直到两个指针
 *  相遇为止；复杂度O(n)。
 *  - 这里，奇偶重排只是同类型问题中的一种，因此可以奇偶判断提取成一个方法，降低耦合度，可以提高代码的重用性。
 * User: lingguo
 * Date: 14-3-11
 * Time: 下午10:46
 */
public class MakeOddBeforeEven {
	private static Logger logger = LoggerFactory.getLogger(MakeOddBeforeEven.class);

	/**
     * 调整数组中元素的顺序，使所有的奇数位于数组的前部分，偶数位于数组的后部分；
     * 定义首尾指针，首指针前进，尾指针后退，当首指针遇到偶数且尾指针遇到奇数时，元素互换。
	 * @param data  输出数组
	 * @param length    数组的长度
	 */
	public static int[] adjust(int[] data, int length) {
		int first = 0;
		int last = length - 1;
		while (first < last) {
			// 首指针寻找第一个偶数
			while ((first < last) && (isOdd(data[first]))) {
				first++;
			}
			// 尾指针寻找第一个奇数
			while ((first < last) && (!isOdd(data[last]))) {
				last--;
			}
			// 首尾元素互换
			if (first < last) {
				int tmp = data[first];
				data[first++] = data[last];
				data[last++] = tmp;
			}
		}
        return data;
	}

    /**
     * 判断一个数是否为奇数
     * @param num
     * @return
     */
	public static boolean isOdd(int num) {
		if ((num & 0x01) == 1) {
			return true;
		}
		return false;
	}
}

/**
 * 思路：使用两个指针，分别指向数组的首元素和尾元素，首指针判断当前元素是否尾奇数，尾元素判断当前元素
 * 是否尾偶数，如果达到交换的条件，则奇偶互换。这里应该将判断逻辑抽取为独立的函数。
 */