package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：
 *  判断一个序列是否为一棵二叉搜索树的后序遍历序列。
 *
 * 思路：
 *  二叉搜索树的后序遍历序列的特征是：序列的最后一个元素为当前二叉树的根节点，该序列的左边
 *  一部分构成左子树，所有节点的值均小于根节点，序列的右边部分构成右子树，所有节点的值均大
 *  于根节点；递归遍历，如果所有子树都满足该条件，则该序列为一棵二叉搜索树的后序遍历序列；
 *
 * User: lingguo
 * Date: 14-3-26
 * Time: 下午11:45
 */
public class CheckIfPostOrder {
	private static Logger logger = LoggerFactory.getLogger(CheckIfPostOrder.class);

	/**
	 * 将序列根据最后一个节点一分为二，检查合法性，递归
	 *
	 * @param data  序列数组
	 * @param start 序列的第一个元素的索引
	 * @param end   序列的最后一个元素的索引
	 * @return  如果该序列可以为二叉树的后序遍历序列，返回true
	 */
	public static boolean check(int[] data, int start, int end) {
		// 没有元素或仅有一个元素
		if (start >= end) {
			return true;
		}

        // 最后一个元素为根节点，分离左右子树
		int root = data[end];
		int left = start;
		while (left < end && data[left] < root) {
			left++;
		}
        // 判断右子树的元素是否都大于根元素
		int right = left;
		while (right < end && data[right] > root) {
			right++;
		}
		if (right != end) {
			return false;
		}
        // 递归遍历左右子树
		return check(data, start, left - 1) && check(data, left, end - 1);
	}
}
