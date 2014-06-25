package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

import java.util.LinkedList;

/**
 * 问题描述：
 *  层次遍历二叉树；
 *
 * 思路：
 *  对于某一个节点来说，先遍历左节点，然后遍历右节点，然后遍历左节点的左、右节点，
 *  右节点的左右节点，可以利用队列的先进先出特性，保存要遍历的节点，达到层次遍历
 *  的结果。
 *
 * User: Daniel
 * Date: 13-12-22
 * Time: 下午12:26
 */
public class TierTraverseBT {
	private static Logger logger = LoggerFactory.getLogger(TierTraverseBT.class);

	/**
	 * 层次遍历二叉树
	 *
	 * @param head
	 */
	public static void traverse(TreeNode head) {
		if (null == head) {
			return;
		}

		// 使用队列保存要遍历的节点
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.addLast(head);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.pollFirst();
			logger.info("node: {}", node.value);
			if (null != node.left) {
				nodeQueue.addLast(node.left);
			}
			if (null != node.right) {
				nodeQueue.addLast(node.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(6);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(11);
		TierTraverseBT.traverse(root);
	}
}
