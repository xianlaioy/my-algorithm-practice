package org.yousharp.pointatoffer.stackqueue;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 * 两个整数序列，第一个表示栈的压入顺序，请判断第二个序列是否为栈的弹出顺序。
 * (假设压入序列的数字均不相同）
 *
 * User: lingguo
 * Date: 14-3-26
 * Time: 下午9:27
 */
public class CheckValidQueueSequence {
	private static Logger logger = LoggerFactory.getLogger(CheckValidQueueSequence.class);

	/**
	 * two sequences: the first one represents the process of push, check if the second one
	 * can be the process of pop.
	 *
	 * @param input the order of push element to stack
	 * @param output    the order of pop element from stack
	 * @return  if the output data is valid pop sequence
	 */
	public static boolean check(int[] input, int[] output) {
		// we need an assist stack
		LinkedList<Integer> stack = new LinkedList<Integer>();

		// index of the input data and output data
		int inputIndex = 0;
		int outputIndex = 0;
		// traverse the output data
		for (outputIndex = 0; outputIndex < output.length; outputIndex++) {
			// first compare with the middle stack
			if (!stack.isEmpty()) {
				if (stack.peek() == output[outputIndex]) {  // equal to the top, just pop and move forward
					stack.pop();
					continue;
				} else {    // otherwise, and there is no more data in input, invalid
					if (inputIndex == input.length) {
						return false;
					}
				}
			}

			// second compare with the input data, if not equal, push to stack and move forward
			while (inputIndex < input.length && output[outputIndex] != input[inputIndex]) {
				stack.push(input[inputIndex]);
				inputIndex++;
			}
			inputIndex ++;  // be aware: if the input data is equal to the output data, both of them move one step forward
		}
		// when the input data, output data and the stack are all empty, valid output
		if (inputIndex == input.length && outputIndex == output.length && stack.isEmpty()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] input = new int[] {8, 9, 6, 4, 3};
		int[] output = new int[] {6, 9, 4, 3, 8};

		System.out.println(CheckValidQueueSequence.check(input, output));

	}
}
