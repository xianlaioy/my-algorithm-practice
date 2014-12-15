package org.yousharp.pointatoffer.tree;

import org.junit.Test;
import org.yousharp.ds.TreeNode;

import java.util.LinkedList;

/**
 * @author: lingguo
 * @time: 2014/10/15 21:11
 */
public class FullBTCheck {

    public boolean checkFullBT1(TreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        return checkFullBT(root.left) && checkFullBT(root.right);
    }

    public boolean checkFullBT(TreeNode root) {
        if (root == null) {
            return true;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        TreeNode node = null;
        /**
         * 层次遍历，无论节点的左右节点是否为null，都放入队列
         */
        while ((node = nodeQueue.pop()) != null) {
            nodeQueue.push(node.left);
            nodeQueue.push(node.right);
        }

        /**
         * 如果是完全二叉树，则null都在队列的尾部
         */
        while (!nodeQueue.isEmpty()) {
            if (nodeQueue.pop() != null) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {

    }
}
