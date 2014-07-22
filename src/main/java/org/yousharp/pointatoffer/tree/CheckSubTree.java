package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

/**
 * 问题描述：
 *  两个二叉树，判断二叉树A是否包含二叉树B，即二叉树B是否为二叉树A的子结构。
 *
 * 思路：
 *  将问题分为两步，第一步是遍历二叉树A的每一个节点，寻找与二叉树B的根节点相同的节点；
 *  第二步，对于A中每一个与B的根节点相同的节点，判断B是否为以该节点为根节点的二叉树的子树。
 *  两个步骤都可以通过递归来完成。
 *
 * Uer: Daniel
 * Date: 13-12-22
 * Time: 下午1:59
 */
public class CheckSubTree {
	private static Logger logger = LoggerFactory.getLogger(CheckSubTree.class);

	/**
	 *  遍历二叉树A，寻找与二叉树B的根节点相同的节点，比较是否能构成子树的结构。
     *  如果B树为空，则认为是子结构；
	 *
	 * @param treeA   二叉树A
	 * @param treeB   二叉树B
	 * @return   true如果二叉树B是二叉树A的子结构
	 */
	public static boolean check(TreeNode treeA, TreeNode treeB) {
		//  B树为空
		if (treeB == null) {
			return true;
		}
        // A树为空
        if (treeA == null) {
            return false;
        }

		//  如果节点值相等，则判断是否为子结构
		if (treeA.value == treeB.value) {
			if(subTree(treeA, treeB)) {
                return true;
            }
		}
		//  左右子树是否符合
		return (subTree(treeA.left, treeB) || subTree(treeA.right, treeB));
	}

	/**
	 *  判断树B是否为树A的子结构
     *
	 * @param treeA
	 * @param treeB
	 * @return
	 */
	private static boolean subTree(TreeNode treeA, TreeNode treeB) {
		// 都为空
		if (treeA == null && treeB == null) {
			return true;
		}
		// 一个不为空
		if (treeA == null || treeB == null) {
			return false;
		}

        //  当前节点值不相等
        if (treeA.value != treeB.value) {
            return false;
        }

		return (subTree(treeA.left, treeB.left) && subTree(treeA.right, treeB.right));
	}
}

