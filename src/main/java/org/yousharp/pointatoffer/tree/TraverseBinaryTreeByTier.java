package org.yousharp.pointatoffer.tree;

import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

/**
 * 分层遍历二叉树 * User: Daniel
 * Date: 13-12-22
 * Time: 下午12:26
 */
public class TraverseBinaryTreeByTier {
	private static Logger logger = LoggerFactory.getLogger(TraverseBinaryTreeByTier.class);

	/**
	 * traverse a binary tree by tier
	 *
	 * @param head
	 */
	public static void traverse(TreeNode head) {
		if (null == head) {
			return;
		}

		// the linked list is used as a queue
		LinkedList<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.addLast(head);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.pollFirst();
			logger.info("node: {}", node.value);
			if (null != node.left) {
				nodeQueue.add(node.left);
			}
			if (null != node.right) {
				nodeQueue.add(node.right);
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
		TraverseBinaryTreeByTier.traverse(root);
	}
}
