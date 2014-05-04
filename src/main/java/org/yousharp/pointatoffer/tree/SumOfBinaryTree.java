package org.yousharp.pointatoffer.tree;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

/**
 * 问题描述：二叉树中，求和为某一值的路径（路径为根节点到叶节点的节点值的和）
 *
 * User: lingguo
 * Date: 14-3-27
 * Time: 上午12:03
 */
public class SumOfBinaryTree {
	private static Logger logger = LoggerFactory.getLogger(SumOfBinaryTree.class);

	/**
	 * given a value: check if the sum of any paths of the binary tree is equal to the value.
	 *
	 * @param root  the root of the binary tree
	 * @param actualSum the current sum of the path
	 * @param expectedSum   the given sum
	 * @param path  one path
	 */
	public static void pathWithSum(TreeNode root, int actualSum, int expectedSum, LinkedList<TreeNode> path) {
		// add the current node to the path and sum
		path.addLast(root);
		actualSum += root.value;
		// if it is leaf node, check the sum of the path
		if (root.left == null && root.right == null) {
			if (actualSum == expectedSum) {
				printPath(path);
			}
			// return, remove the node from the path and sum
			path.pollLast();
//			actualSum -= root.value;
			return;
		}
		// traverse left and right child recursively
		if (root.left != null) {
			pathWithSum(root.left, actualSum, expectedSum, path);
		}
		if(root.right != null) {
			pathWithSum(root.right, actualSum, expectedSum, path);
		}
		// return to previous level
		path.pollLast();
//		actualSum -= root.value;
	}

	public static void printPath(LinkedList<TreeNode> path) {
		for (TreeNode node: path) {
			logger.info("{}", node.value);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(7);

		LinkedList<TreeNode> path = new LinkedList<TreeNode>();
		SumOfBinaryTree.pathWithSum(root, 0, 22, path);

	}
}
