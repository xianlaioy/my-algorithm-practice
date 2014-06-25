package org.yousharp.pointatoffer.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yousharp.common.TreeNode;

import java.util.LinkedList;

/**
 * 问题描述：
 *    给定二叉树中的两个节点，求这两个节点的第一个公共父节点。
 *
 * 思路：
 *   如果只是一棵普通的二叉树，有两种思路：
 *      思路一：遍历二叉树，分别计算从根节点到这两个节点的路径，如果这两个节点的公共父节点存在
 *       ，则这两条路径肯定是相交的，第一个公共父节点就是这两条路径的最后一个交点。
 *      思路二：两个节点的第一个公共父节点有一个特点：这两个节点，一个在其左子树中，另一个在其
 *       右子树中。从根节点开始遍历，如果两个节点都在当前节点的左子树中，则遍历其左子树，如果两
 *       个节点都在当前节点的右子树中，则遍历右子树，如果一个在其左子树，另一个在其右子树，则当
 *       前节点即为所求。
 *   如果这是一棵特殊的二叉树，如搜索二叉树，即节点的值大于左节点的值，而小于右节点的值，根据这个
 *   特点，层次遍历二叉树，寻找第一个满足这个条件的节点即可。
 *
 * User: Daniel
 * Date: 14-1-12
 * Time: 下午8:28
 */
public class FirstCommonParent {
	private static Logger logger = LoggerFactory.getLogger(FirstCommonParent.class);

    /**
     *  方法一：已知根节点到两个节点的路径后，它们的第一个公共父节点即两条路径的最后一个
     *  交点
     *
     * @param root
     * @param first
     * @param second
     * @return
     */
    public TreeNode pathIntersection(TreeNode root, TreeNode first, TreeNode second) {
        if (null == root || null == first || null == second) {
            return null;
        }

        LinkedList<TreeNode> firstPath = new LinkedList<TreeNode>();
        LinkedList<TreeNode> secondPath = new LinkedList<TreeNode>();

        //  获取路径
        boolean isLeftFound = getTreePath(root, first, firstPath);
        boolean isRightFound = getTreePath(root, second, secondPath);

        //  计算两条路径的最后一个交点
        if (isLeftFound && isRightFound) {
            for (int i = 0; i < firstPath.size() && i < secondPath.size(); i++) {
                if (firstPath.get(i) != secondPath.get(i)) {
                    return firstPath.get(i-1);
                }
            }
        }
        return null;
    }

    /**
     *   方法一：遍历二叉树，计算根节点到某一节点的路径
     *
     * @param root
     * @param node
     * @param path
     * @return
     */
    public static boolean getTreePath(TreeNode root, TreeNode node, LinkedList<TreeNode> path) {
        if (null == root) {
            return  false;
        }

        //  将当前节点加入到路径中
        path.add(root);

        //   当前节点即是，则返回
        if (node == root) {
            return true;
        }

        //  当前节点不是，递归查找左子树和右子树
        boolean isFound = false;
        isFound = getTreePath(root.left, node, path);
        if (!isFound) {
            isFound = getTreePath(root.right, node, path);
        }

        //  当前节点及其左右子树中都没有该节点，从路径中去掉该节点，继续遍历
        if (!isFound) {
            path.remove(root);
        }
        return isFound;
    }

	/**
	 *  方法二：如果是搜索二叉树，则遍历二叉树，比较节点的值，查找第一个节点，该节点的
     *  值介于两个节点的值之间。
     *
	 * @param root
	 * @param first
	 * @param second
	 * @return
	 */
	public TreeNode findInBSTree(TreeNode root, TreeNode first, TreeNode second) {
		// check params
		if (null == root || null == first || null == second) {
			return null;
		}

		while (null != root) {
			if (first.value < second.value) {
				// got it
				if ((root.value < second.value) && (root.value > first.value)) {
					return root;
				} else if (root.value > second.value) {     // find in the right branch
					root = root.left;
				} else if (root.value < first.value) {        // find in the left branch
					root = root.right;
				} else {
					return null;    // root equals to either of the nodes, illegal
				}
			} else if (first.value > second.value) {
				if ((root.value > second.value) && (root.value < first.value)) {    // got it
					return root;
				} else if (root.value < second.value) {     // find in the left branch
					root = root.right;
				} else if (root.value > first.value) {      // find in the right branch
					root = root.left;
				} else {    // illegal
					return null;
				}
			} else {        // illegal
				return null;
			}
		}
		return null;    // not found
	}


}
