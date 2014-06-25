package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

import java.util.LinkedList;

/**
 * 问题描述：
 *  求二叉树的镜像
 *
 * 思路：
 *  二叉树的镜像，就是将二叉树的每一个节点的左右子节点交换；具体实现上：
 *  算法一：通过递归，先序遍历，当节点不为空时，将左右子节点互换；
 *  算法二：递归的本质也是栈，遍历的方式对结果不影响，所以可以通过层次遍历，将
 *  节点保存在栈中，然后将栈中的每一个节点的左右子节点互换；
 *
 * User: Daniel
 * Date: 13-12-22
 * Time: 上午11:29
 */

public class MirrorOfBinaryTree {
	private static Logger logger = LoggerFactory.getLogger(MirrorOfBinaryTree.class);

	/**
	 * 通过递归的思路，先序遍历每一个节点，互换节点的左右子节点；
	 *
	 * @param root
	 */
	private static void mirrorByRecursion(TreeNode root) {
		if (null == root) {
			return;
		}

		// 节点不为空，则交换其左右子节点
		TreeNode leftBak = root.left;
		root.left = root.right;
		root.right = leftBak;

		// 递归遍历左右子树
		mirrorByRecursion(root.left);
		mirrorByRecursion(root.right);
	}

	/**
	 * 借助栈，使用层次遍历的思路，遍历每一个节点，并交换其左右子节点；
	 *
	 * @param root
	 */
	public static void mirrorByStack(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);   // push the root to the stack
		while (!stack.isEmpty()) {
			TreeNode currNode = stack.pop();    // get the top node
			if (currNode != null) {
				// push left and right children
				stack.push(currNode.left);
				stack.push(currNode.right);

				// swap left and right children
				TreeNode leftBak = currNode.left;
				currNode.left = currNode.right;
				currNode.right = leftBak;
			}
		}
	}

}
