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
public class CheckSubBinaryTree {
	private static Logger logger = LoggerFactory.getLogger(CheckSubBinaryTree.class);

	/**
	 *  遍历二叉树A，寻找与二叉树B的根节点相同的节点，比较是否能构成子树的结构
	 *
	 * @param TreeA   二叉树A
	 * @param TreeB   二叉树B
	 * @return   true如果二叉树B是二叉树A的子结构
	 */
	private boolean check(TreeNode TreeA, TreeNode TreeB) {
		//  合法性检查
		if (null == TreeA || null == TreeB) {
			return false;
		}

		boolean result = false;
		//  判断是否包含
		if (TreeA.value == TreeB.value) {
			result = isContain(TreeA, TreeB);
		}
		//  当前节点不符合，则检查其左节点
		if (false == result) {
			result = check(TreeA.left, TreeB);
		}
		//  判断右节点
		if (false == result) {
			result = check(TreeA.right, TreeB);
		}
		return result;
	}

	/**
	 *  判断树B是否为树A的子结构
     *
	 * @param TreeA
	 * @param TreeB
	 * @return
	 */
	private boolean isContain(TreeNode TreeA, TreeNode TreeB) {
		//  树B为空
		if (null == TreeB) {
			return true;
		}
		//  树A为空
		if (null == TreeA) {
			return false;
		}

        //  当前节点值不相等
        if (TreeA.value != TreeB.value) {
            return false;
        }

		return (isContain(TreeA.left, TreeB.left) && isContain(TreeA.right, TreeB.right));

	}
}

