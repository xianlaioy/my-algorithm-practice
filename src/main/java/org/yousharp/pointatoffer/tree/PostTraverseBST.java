package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 问题描述：判断一个序列是否为一棵二叉搜索树的后续遍历序列。
 *
 * User: lingguo
 * Date: 14-3-26
 * Time: 下午11:45
 */
public class PostTraverseBST {
	private static Logger logger = LoggerFactory.getLogger(PostTraverseBST.class);

	/**
	 * check if a given sequence is a post traverse sequence of a Binary Search Tree.
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
		// find the left part of the BST
		while (i < end && data[i] < root) {
			i++;
		}
		int j = i;
		// find the right part of the BST
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

	public static void main(String[] args) {
		int[] data = new int[] {5, 7, 6, 9, 11, 8, 10};
		logger.info("{}", PostTraverseBST.check(data, 0, data.length - 1));
	}
}
