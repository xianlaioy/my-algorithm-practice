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
public class PostorderOfBST {
	private static Logger logger = LoggerFactory.getLogger(PostorderOfBST.class);

	/**
	 *将序列根据最后一个节点一分为二，检查合法性，递归
	 *
	 * @param data  the sequence to check
	 * @param start the start index of data (inclusive)
	 * @param end   the end index of the data (inclusive)
	 * @return  true or false
	 */
	public static boolean check(int[] data, int start, int end) {
		// less than one node, return true
		if (start >= end) {
			return true;
		}
		int root = data[end];   // the last node is the root of the BST
		int i = start;
		// findParentByPath the left part of the BST
		while (i < end && data[i] < root) {
			i++;
		}
		int j = i;
		// findParentByPath the right part of the BST
		while (j < end && data[j] > root) {
			j++;
		}
		// check: if all left elements are less than root and all right elements are bigger than root
		if (j != end) {
			return false;
		}
		// check left sequence and right sequence recursively
		return check(data, start, i - 1) && check(data, i, end - 1);
	}

}
